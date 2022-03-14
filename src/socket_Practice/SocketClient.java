package socket_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class SocketClient {
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	
	public SocketClient(String ip,int port) {
		try {
			
			socket = new Socket(ip, port);
			System.out.println(socket.getInetAddress().getHostAddress() + " 에 연결됨");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			
			
			pw.println("발송 시작");
			pw.flush();
			
			System.out.println(br.readLine());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(socket != null) {
					socket.close();
				}
				if(pw != null) {
					pw.close();
				}
				if(br != null) {
					br.close();
				}
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
	
	
	
	
}
