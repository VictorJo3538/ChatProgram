package chat.server;

import java.net.*;

public class Client {
    private static DatagramSocket clientSocket;
    public static String userName;
    static {
        try {
            clientSocket = new DatagramSocket();
            startReceiverThread();  // 비동기적으로 메시지를 수신할 스레드 시작
        } catch (Exception e) {
            System.out.println("스태틱 초기화 에러: 클라이언트 소켓 초기화 불가");
            e.printStackTrace();
        }
    }

    private static void startReceiverThread() {
        Thread receiverThread = new Thread(() -> {
            try {
                byte[] receiveData = new byte[1024];
                while (true) {
                    // 클라이언트로부터 데이터 수신
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    clientSocket.receive(receivePacket);

                    // 수신된 데이터 출력
                    String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    System.out.println("FromServer: " + response);

                    // 데이터 처리 블록
                    String[] parts = response.split(";");
                    
                    // 로그인 응답
                    if (parts[0].split("_")[0].equals("LOGIN")) {
                    	Login.setResponse(parts);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        receiverThread.start();
    }

    public class Login {
    	static String[] parts;
    	
    	public static void sendRequest(String uid, String pwd) {
            try {
                // 전송할 데이터
                String message = "LOGIN_REQUEST;" + uid + ";" + pwd;
                System.out.println("SENT: " + message);
                byte[] sendData = message.getBytes();

                // 데이터를 DatagramPacket으로 감싸서 전송
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, Adress.ip, Adress.port);
                clientSocket.send(sendPacket);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    	
    	public static void setResponse(String[] parts) {
    		Login.parts = parts;
    	}
    	
    	public static boolean getResponse() {
            // 서버 응답에 대한 처리를 여기에 추가
            if (parts[0].equals("LOGIN_SUCCESS")) {
                userName = parts[1];
                return true;
            } else if (parts[0].equals("LOGIN_FAILED")) {
            	return false;
            }
            
            return false;
        }
    }
}

