package messaging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientConnection implements Runnable{

	private Socket clientSocket;
	
	public ClientConnection(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	@Override
	public void run() {
		System.out.println("thread start");
		try {
			readMessage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readMessage() throws IOException {
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		out.println("message was recieved");
		String input;
		
		while((input = in.readLine()) != null) {
			System.out.println(input);
		}
		System.out.println("client closed");
		out.close();
		in.close();
	}

}
