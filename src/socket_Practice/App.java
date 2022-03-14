package socket_Practice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.istack.internal.logging.Logger;

public class App {
	
	private static final Logger logger = Logger.getLogger(App.class);
	
	private static final int PORT_NUMBER = 9961;
	
	public static void main(String[] args) throws IOException{
		
		logger.info(":::                            :::");
		logger.info(":::     Socket Application Process Start     :::");
		logger.info(":::                            :::");
		
		try(ServerSocket server = new ServerSocket(PORT_NUMBER)){
			while(true) {
				Socket connection = server.accept();
				Thread task = new SocketServerPractice(connection);
				task.start();
			}
		} catch (IOException e) {
			System.out.println("오류");
			e.printStackTrace();
		}
		
	}

}
