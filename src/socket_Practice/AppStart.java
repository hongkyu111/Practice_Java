package socket_Practice;

public class AppStart {

	public static void main(String[] args) {
		String ip = "연결할 주소(ip)";
		int port = 9961;
		new SocketClient(ip, port);
		
	}

}
