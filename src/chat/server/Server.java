package chat.server;

import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import chat.database.DBModel;

public class Server {
	public static void main(String[] args) {
		try {
			// 서버는 특정 포트에서 대기
			int port = Adress.port;
			DatagramSocket serverSocket = new DatagramSocket(port);

			byte[] receiveData = new byte[1024];
			System.out.println("데이터 수신 중...");
			while (true) {
				// 클라이언트로부터 데이터 수신
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
				String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
				print("REQUEST: " + message);
				
				// 데이터 처리 블록
				String[] parts = message.split(";");
				
				// 로그인요청
				if (parts.length == 3 && parts[0].equals("LOGIN_REQUEST")) {
					String uid = parts[1];
					String pwd = parts[2];
					
					// 로그인성공
					String responseMessage = "LOGIN_FAILED";  // 기본값 실패
					if (DBModel.userDB.login(uid, pwd)) {
                        responseMessage = "LOGIN_SUCCESS;"+DBModel.userDB.getUserName();  
					} 
					InetAddress clientAddress = receivePacket.getAddress();
                    int clientPort = receivePacket.getPort();
                    byte[] sendData = responseMessage.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                    serverSocket.send(sendPacket);
                    print("   SENT: "+responseMessage);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void print(String text) {
		// 현재 시각 가져오기
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String currTime = currentDateTime.format(formatter);
        System.out.println(currTime+":"+text);
	}
}
