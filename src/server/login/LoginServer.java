package server.login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class LoginServer {
    private List<ClientHandler> clients = new ArrayList<>();
    
    public static void main(String[] args) {
        LoginServer server = new LoginServer();
        server.start(12345);
    }

    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                writer.println("Checking");
                String userId = reader.readLine();
                String userPwd = reader.readLine();

                if(!loginA(userId, userPwd)) {
                	writer.println("LOGIN_FAILED");
                }
                writer.println("LOGIN_SUCCESS");
                System.out.println(userId+"connected");
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean loginA(String id,String pwd) throws IOException{
    	BufferedReader br = new BufferedReader(new FileReader("/Users/jinhyeongchan/Server/resource/user/User"));
		String str; 
		
		while((str=br.readLine())!=null) {
			if(!str.equals(id+" "+pwd)) {	//로그인 검사
				continue;					
			}
			else br.close(); return true;	//로그인 성공
		}
		br.close();
		return false;						//로그인 실패
    }
	public void addUser(String userId, String userPwd) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("resource/user/User"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("resource/user/User"));
//		String str;
//		while((str=br.readLine())!=null) {
//			String[] id = str.split(" ");
//			if(!id.equals(userId)) {
//				continue;
//			}else {
//				return;
//			}
//		}	
		bw.write(userId+" "+userPwd);
//		br.close();
		bw.close();
		return;
    }
    public class ClientHandler implements Runnable {
        private Socket clientSocket;
        private InputStream input;
        private OutputStream output;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
            try {
                this.input = socket.getInputStream();
                this.output = socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                byte[] buffer = new byte[1024];
                int bytesRead;
                
                while ((bytesRead = input.read(buffer)) != -1) {
                    String message = new String(buffer, 0, bytesRead);
                    broadcast(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clients.remove(this);
                System.out.println("Client disconnected");
            }
        }

        private void broadcast(String message) {
            for (ClientHandler client : clients) {
                try {
                    client.output.write(message.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
