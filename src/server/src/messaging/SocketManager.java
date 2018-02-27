package messaging;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketManager {
	
	final public static int DEFAULT_PORT = 9999;

	private ServerSocket serverSocket;
	//private Socket clientSocket;
	private List<Thread> ActiveConnections;
	
	public SocketManager() throws IOException {
		// keep track of threads
		ActiveConnections = new ArrayList<Thread>();
		
		// setup server socket
		try {
			serverSocket = new ServerSocket(DEFAULT_PORT);
		}catch(IOException e) {
			System.out.println("PortManager could not open the default port");
			System.out.println(e);
			return;
		}
		
		// accept a new connection and spawn a new thread to handle it
		try {
			Socket clientSocket = serverSocket.accept();
			ClientConnection cc = new ClientConnection(clientSocket);
			Thread thread = new Thread(cc);
			thread.start();
			ActiveConnections.add(thread);
		} catch (IOException e) {
			System.out.println("PortManager could not accept a message on the default port");
			System.out.println(e);
			return;
		}

		// terminate SocketManager only when all threads have terminated
		for (Thread t : ActiveConnections){
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		serverSocket.close();
	}
	
	public void shutDownSocketManager() throws Exception {
		serverSocket.close();
	}
	
}
