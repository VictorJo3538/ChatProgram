package chat.server;

import java.net.InetAddress;

public class Adress {
	static int port = 6001;
	static InetAddress ip;
	static {
		try {
			ip = InetAddress.getByName("localhost");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
