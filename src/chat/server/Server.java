package chat.server;

import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import chat.database.DBModel;
import chat.database.DBModel.MsgDB;


public class Server {
    private static Map<String, InetSocketAddress> clientAddresses = new HashMap<>();
    
    public static void main(String[] args) {
    	
    	
        try {
            int port = Adress.port;
            DatagramSocket serverSocket = new DatagramSocket(port);

            byte[] receiveData = new byte[1024];
            System.out.println("데이터 수신 중...");
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                print("REQUEST: " + message);

                String[] parts = message.split(";");
                
                // 로그인 요청
                if (parts[0].equals("LOGIN_REQUEST")) {
                    String uid = parts[1];
                    String pwd = parts[2];
                    
                    // 로그인 성공
                    String responseMessage = "LOGIN_FAILED"; // 기본값 실패
                    if (DBModel.userDB.login(uid, pwd)) {
                        responseMessage = "LOGIN_SUCCESS;"+DBModel.userDB.getUid()+";"+DBModel.userDB.getUserName();

                        // 클라이언트의 주소 및 포트를 저장
                        InetSocketAddress clientAddress = new InetSocketAddress(receivePacket.getAddress(), receivePacket.getPort());
                        clientAddresses.put(uid, clientAddress);
                    }
                    InetAddress clientAddress = receivePacket.getAddress();
                    int clientPort = receivePacket.getPort();
                    byte[] sendData = responseMessage.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                    serverSocket.send(sendPacket);
                    print("   SENT: "+responseMessage);
                }
                
                // 로그아웃 요청
                if (parts[0].startsWith("LOGOUT_REQUEST")) {
                	String uid = parts[1];
                	clientAddresses.remove(uid);
                }
                
                // 메시지 요청
                if (parts[0].startsWith("MESSAGE_REQUEST")) {
                	String roomNum = parts[1];
                	String text = parts[2];
                	String msg = roomNum+";"+text;
                	sendToAllClients("UPDATE_REQUEST;"+msg);
                	MsgDB.addMsg(msg);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendToAllClients(String message) {
        byte[] sendData = message.getBytes();
        for (InetSocketAddress clientAddress : clientAddresses.values()) {
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress.getAddress(), clientAddress.getPort());
            try {
                DatagramSocket socket = new DatagramSocket(); // 새로운 소켓 생성
                socket.send(sendPacket);
                socket.close();
                print("   SENT("+clientAddress+"): " + message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void print(String text) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String currTime = currentDateTime.format(formatter);
        System.out.println(currTime + ":" + text);
    }
}

