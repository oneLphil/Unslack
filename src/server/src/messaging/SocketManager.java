package messaging;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketManager {
	
	final public static int DEFAULT_PORT = 9999;

	private ServerSocket serverSocket;
	private Socket clientSocket;
	
	public SocketManager() throws IOException {
		try {
			serverSocket = new ServerSocket(DEFAULT_PORT);
		}catch(IOException e) {
			System.out.println("PortManager could not open the default port");
			System.out.println(e);
			return;
		}
		
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.out.println("PortManager could not accept any messages on default port");
			System.out.println(e);
			return;
		}
		
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		
		out.println("test");
		String input;
		
		while((input = in.readLine()) != null) {
			System.out.println(input);
			out.println("hello");
		}
		System.out.println("client closed");
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
	
	public void shutDownPorts() throws Exception {
		clientSocket.close();
		serverSocket.close();
	}
	
}
