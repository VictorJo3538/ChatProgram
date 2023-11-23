package chat.frame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("서버가 시작되었습니다. 클라이언트의 연결을 기다립니다...");
            while (true) {
                Socket clientSocket = serverSocket.accept();	// 클라이언트 연결 기다림
                System.out.println("클라이언트가 연결되었습니다.");		// 클라이언트 연결
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                String userId = reader.readLine();
                String userPwd = reader.readLine();
                if(loginA(userId, userPwd)) {
                	writer.println("LOGIN_SUCCESS");
                	System.out.println(userId+" logged in");
                	serverSocket.close();
                }else {
                	writer.println("LOGIN_FAILED");
                	serverSocket.close();
                }
                
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static boolean loginA(String id,String pwd) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("resource/user/User"));
		String str; 
		
		while((str=br.readLine())!=null) {
			if(!str.equals(id+" "+pwd)) {
				continue;
			}
			else br.close(); return true;
		}
		br.close();
		return false;
    }
	
}
