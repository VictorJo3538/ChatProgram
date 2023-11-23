package chat.frame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;

import chat.login.LoginPanel;

public class ChatClient {    
    public ChatClient(String userId, String userPwd) {
        try (Socket socket = new Socket("localhost", 12345)) {
        	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
        	String response = serverReader.readLine();
        	
      	  while(!response.equals("LOGIN_SUCCESS")) {
      	  	writer.println(userId);
      	  	writer.println(userPwd);
      	  	response = serverReader.readLine();
      	  }
      	
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
