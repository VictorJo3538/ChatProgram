package chat.server;

import java.net.*;
import java.util.concurrent.CompletableFuture;

import chat.room.ChatRoom;
import chat.room.ChatRoomManager;

public class Client {
    private static DatagramSocket clientSocket;
    private static ChatRoomManager roomManager;
    
    public static String uid;
    public static String userName;
    
    public static void setChatRoomManager(ChatRoomManager roomManager) {
    	Client.roomManager = roomManager;	
    }
    
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
			while (true) {
				try {
					// 클라이언트로부터 데이터 수신
					byte[] receiveData = new byte[1024];
					DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
					clientSocket.receive(receivePacket);

					// 수신된 데이터 출력
					String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
					System.out.print("FromServer: " + response);

					// 데이터 처리 블록
					String[] parts = response.split(";");

					// 서버요청 처리
					if (parts[0].startsWith("LOGIN")) {  // 로그인 응답
						Login.setResponse(parts);
					}
					
					if (parts[0].startsWith("UPDATE_REQUEST")) { // 메시지 업데이트 요청
						int roomNum = Integer.parseInt(parts[1]);
	                	String text = parts[2];
	                	Message.handleRequest(roomNum, text);
					}
					
					if (parts[0].startsWith("UPDATE_TITLE")) {
						int roomNum = Integer.parseInt(parts[1]);
	                	String title = parts[2];
	                	RoomTitle.handleRequest(title, roomNum);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		receiverThread.start();
	}
    
    public static class Login {
    	private static String[] parts = null;
    	
        public static void sendRequest(String uid, String pwd) {
            try {
                // 전송할 데이터
                String message = "LOGIN_REQUEST;" + uid + ";" + pwd;
                System.out.println("SENT: " + message);
                byte[] sendData = message.getBytes();

                // 데이터를 DatagramPacket으로 감싸서 전송
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, Adress.ip, Adress.port);
                Client.clientSocket.send(sendPacket);
            } catch (Exception e) {
            	e.printStackTrace();
            }
        }

        public static void setResponse(String[] parts) {
            Login.parts = parts;
        }

        public static CompletableFuture<Boolean> getResponse() {
            CompletableFuture<Boolean> future = new CompletableFuture<>();

            new Thread(() -> {
                while (true) {
                    synchronized (Client.class) {
                        if (parts != null) {
                            // 서버 응답에 대한 처리를 여기에 추가
                            boolean res = false;
                            if (parts[0].equals("LOGIN_SUCCESS")) {
                            	Client.uid = parts[1];
                                Client.userName = parts[2];
                                res = true;
                            } else if (parts[0].equals("LOGIN_FAILED")) {
                                res = false;
                            }

                            parts = null;
                            future.complete(res); // CompletableFuture에 결과 설정

                            break;
                        }
                    }
                }
            }).start();

            return future; // CompletableFuture를 반환
        }
    }
    
    public static class Logout {
    	public static void sendRequest(String uid) {
            try {
                // 전송할 데이터
                String message = "LOGOUT_REQUEST;"+uid;
                byte[] sendData = message.getBytes();
                
                // 데이터를 DatagramPacket으로 감싸서 전송
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, Adress.ip, Adress.port);
                Client.clientSocket.send(sendPacket);
            } catch (Exception e) {
            	e.printStackTrace();
            }
        }
    }

    public static class Message {
    	public static void sendRequest(int roomNum, String text) {
            try {
                // 전송할 데이터
                String message = "MESSAGE_REQUEST;"+roomNum+";"+text;
                System.out.print("SENT: " + message);
                byte[] sendData = message.getBytes();

                // 데이터를 DatagramPacket으로 감싸서 전송
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, Adress.ip, Adress.port);
                Client.clientSocket.send(sendPacket);
            } catch (Exception e) {
            	e.printStackTrace();
            }
        }
    	
    	public static void handleRequest(int roomNum, String text) {
    		roomManager.server.updateChatRoom(roomNum, text);
    	}
    }
    
    public static class RoomTitle {
    	public static void sendRequest(String roomTitle, int roomNum) {
    		try {
                // 전송할 데이터
                String message = "TITLE_CHANGED;"+roomNum+";"+roomTitle;
                System.out.println("SENT: " + message);
                byte[] sendData = message.getBytes();

                // 데이터를 DatagramPacket으로 감싸서 전송
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, Adress.ip, Adress.port);
                Client.clientSocket.send(sendPacket);
            } catch (Exception e) {
            	e.printStackTrace();
            }
    	}
    	
    	public static void handleRequest(String title, int roomNum) {
    		roomManager.updateTitleButtons(title, roomNum);
    	}
    }
    
}

