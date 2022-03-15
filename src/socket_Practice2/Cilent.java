package socket_Practice2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cilent {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader cin = null;
		BufferedWriter cout = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			socket = new Socket("localhost",9988);
			
			cin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			cout = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				System.out.println("전송할 값 : ");
				String outMsg = sc.nextLine();
				
				cout.write(outMsg + "\n");
				cout.flush();
				try {
					int data = Integer.parseInt(outMsg);
					if(data < 0) {
						System.out.println("end");
						cout.write(outMsg + "\n");
						cout.flush();
						break;
					}
					String inMsg = cin.readLine();
					System.out.println("입력값 : " + inMsg);
					
					
				} catch (NumberFormatException e) {
					System.out.println("입력 에러");
					continue;
				}
				
			}
		} catch (IOException e) {
			System.out.println("클라이언트 에러");
		} finally {
			try {
				if(socket != null) {
					socket.close();
				}
				if(sc != null) {
					sc.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
