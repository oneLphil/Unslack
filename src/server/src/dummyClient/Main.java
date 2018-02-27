package dummyClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import messaging.SocketManager;

public class Main {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		// init variables
		int port = SocketManager.DEFAULT_PORT;
		Socket socket = new Socket("localhost", port);
		BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		
		System.out.println("Client startup sucessful");
		
		pw.println("hello world");
		
		System.out.println("message sent to server");

		System.out.println("Server sent: " + bf.readLine());
		
		// clean up
		pw.close();
		bf.close();
		socket.close();
		
		System.out.println("Client terminated");
	}
}
