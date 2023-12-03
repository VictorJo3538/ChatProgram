package chat.user;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import chat.login.*;

public class ChatClient {    
	String server = "10.220.132.105";
	public ChatClient() {
//		ClientThread clientThread = new ClientThread();
//		new Thread(clientThread).start();
	}
	public String Login(String userId, String userPwd) {
        try (Socket socket = new Socket(server, 12345)) {
        	PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        	String response = serverReader.readLine(); //서버응답		
  	  		writer.println(userId);
  	  		writer.println(userPwd);
  	  		response = serverReader.readLine();
  	  		
      	  	if(response.equals("LOGIN_SUCCESS")) {
      	  		
                return userId;
      	  	}return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	public void onlineStatus(String userId) throws IOException {
        InetAddress serverAddress = InetAddress.getByName(server);
        DatagramSocket clientSocket = new DatagramSocket();
  	  	while(true) {
	  		boolean onlineStatus = true; // 온라인 상태
	        // 클라이언트에서 아이디와 상태를 문자열로 조합하여 서버에 전송
	        String statusMessage = userId + "," + onlineStatus;
	        DatagramPacket packet = new DatagramPacket(statusMessage.getBytes(), statusMessage.length(), serverAddress, 12345);
	        clientSocket.send(packet);
		}
	}
	public void requestAdd(String id, String pwd) {
		
	}
	public String userId(String user) {
		String userId = user;
		return userId;
	}
	public InetAddress returnIp(InetAddress ip) {
		return ip;
	}
//	private class ClientThread implements Runnable{
//		String userId;
//
//	
//		public ClientThread(String id) {
//			userId = id;
//		}
//		@Override
//		public void run() {
//			byte[] buffer = new byte[1024];
//            int bytesWrite;
//            InetAddress serverAddress = InetAddress.getByName(server);
//            DatagramSocket clientSocket = new DatagramSocket();
//      	  	while(true) {
//    	  		boolean onlineStatus = true; // 온라인 상태
//    	        // 클라이언트에서 아이디와 상태를 문자열로 조합하여 서버에 전송
//    	        String statusMessage = userId + "," + onlineStatus;
//    	        DatagramPacket packet = new DatagramPacket(statusMessage.getBytes(), statusMessage.length(), serverAddress, 12345);
//    	        clientSocket.send(packet);
//      	  	}
//		}
//	}
}
