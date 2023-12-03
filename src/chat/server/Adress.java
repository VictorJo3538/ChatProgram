package chat.server;

import java.net.InetAddress;

public class Adress {
	static int port = 6001;
	static InetAddress ip;
	static {
		try {
			ip = InetAddress.getByName("192.168.219.100");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
