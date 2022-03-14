package socket_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.sun.istack.internal.logging.Logger;

public class SocketServerPractice extends Thread{

	private static final Logger logger = Logger.getLogger(SocketServerPractice.class);
	
	private Socket socket;
	
	public SocketServerPractice(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			String connIp = socket.getInetAddress().getHostAddress();
			System.out.println(connIp +" 에서 연결 시도");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			
			System.out.println(br.readLine());
			
			pw.println("수신 완료");
			pw.flush();
		} catch (IOException e) {
			System.out.println("오류");
			e.printStackTrace();
		} finally {
			try {
				if(pw != null) {
					pw.close();
				}
				if(br != null) {
					br.close();
				}
				if(socket != null) {
					socket.close();
				}
			} catch (IOException e2) {
				System.out.println("오류");
				e2.printStackTrace();
			}
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
