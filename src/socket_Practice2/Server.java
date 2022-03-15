package socket_Practice2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class Server {
	
	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;
		BufferedReader sin = null;
		BufferedWriter sout = null;
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		try {
			listener = new ServerSocket(9988);
			System.out.println("계산 서버 준비");
			socket = listener.accept();
			
			sin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			sout = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String inMsg = sin.readLine();
				int data = Integer.parseInt(inMsg);
				
				if(data < 0) {
					System.out.println("연결 종료");
					break;
				}
				System.out.println("입력한 값 : " + data);
				sum += data;
				sout.write("입력한 값의 총 합 : " + sum+ "\n");
				sout.flush();
				
			}
			
		} catch (IOException e) {
			System.out.println("에러");
			e.printStackTrace();
		} finally {
			try {
				if(socket != null) {
					socket.close();
				}
				if(sc != null) {
					sc.close();
				}
				if(listener != null) {
					listener.close();
				}
			} catch (IOException e2) {
				System.out.println("에러");
				e2.printStackTrace();
			}
		}
	}
	
}
