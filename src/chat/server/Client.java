package chat.server;

import java.net.*;

public class Client {
	private static DatagramSocket clientSocket;
	public static String userName;
	
    static {
    	try {
    		clientSocket = new DatagramSocket();
    	} catch (Exception e) {
			System.out.println("스태틱 초기화 에러: 클라이언트 소켓 초기화 불가");
			e.printStackTrace();
		}
    }
    
    public static boolean sendLoginRequest(String uid, String pwd) {
    	boolean res = false;
    	
    	try {
            // 전송할 데이터
            String message = "LOGIN_REQUEST;"+uid+";"+pwd;
            System.out.println("SENT: "+message);
            byte[] sendData = message.getBytes();

            // 데이터를 DatagramPacket으로 감싸서 전송
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, Adress.ip, Adress.port);
            clientSocket.send(sendPacket);
            
            // 서버로부터 응답 받기
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            // 수신된 데이터 출력
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("FromServer: " + response);
            
            // 데이터 처리 블록
			String[] parts = response.split(";");
            
            // 로그인 성공
            if (parts[0].equals("LOGIN_SUCCESS")) {
            	userName = parts[1];
            	res = true;
            } 
            // 로그인 실패
            if (parts[0].equals("LOGIN_FAILED")) {
            	res = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    	return res;
	}
}
