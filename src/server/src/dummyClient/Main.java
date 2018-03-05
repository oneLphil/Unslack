package dummyClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import networking.SocketManager;

public class Main {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		// init variables
		int port = SocketManager.DEFAULT_PORT;
		Socket socket = new Socket("localhost", port);
		BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//PrintWriter pw = new PrintWriter(socket.getOutputStream());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		System.out.println("Client startup sucessful");
		
		bw.write("[{\"MessageType\":\"createRoom\"},]");
		bw.flush();
		socket.shutdownOutput();
		
		System.out.println("message sent to server");
		
		System.out.println("Server sent: " + bf.readLine());
		
		// clean up
		//bw.close();
		bf.close();
		socket.close();
		
		System.out.println("Client terminated");
	}
}
