package networking;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SocketManager implements Runnable {
	
	final public static int DEFAULT_PORT = 9999;
	final private static int ACCEPT_TIMEOUT_MS = 10000; // 10s
	
	private ServerSocket serverSocket;
	private List<Thread> ActiveConnections;
	private boolean terminateProcess;
	
	public SocketManager() throws IOException {
		// keep track of threads
		ActiveConnections = new ArrayList<Thread>();
		
		// setup server socket
		try {
			serverSocket = new ServerSocket(DEFAULT_PORT);
			serverSocket.setSoTimeout(ACCEPT_TIMEOUT_MS);
		}catch(IOException e) {
			System.err.println("PortManager could not open the default port");
			e.printStackTrace();
			return;
		}
		
		terminateProcess = false;
	}
	
	public void shutDownSocketManager() throws IOException, InterruptedException {
		System.out.println("SocketManager shutting down");
		
		// this operation should be threadsafe as this is the only write
		terminateProcess = true;
		
		// terminate SocketManager only when all threads have terminated
		for (Thread t : ActiveConnections){	
			t.join();
		}
		
		serverSocket.close();
	}
	
	@Override
	public void run() {
		// loop until main process signals shutdown
		while (!terminateProcess) {
			
			// accept a new connection and spawn a new thread to handle it
			try {
				Socket clientSocket = serverSocket.accept();
				ClientConnection cc = new ClientConnection(clientSocket);
				Thread thread = new Thread(cc);
				thread.start();
				ActiveConnections.add(thread);
			}  catch (SocketTimeoutException e) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				System.err.println("SocketManager did not accept a message on the default port at:" + sdf.format(cal.getTime()));
			} catch (SocketException e) {
				System.err.println("SocketManager shutdown probably began while accepting. Normal behaviour.");
				e.printStackTrace();
			}catch (IOException e) {
				System.err.println("SocketManager experienced fault in run()");
				e.printStackTrace();
				return;
			}
			
			// clean up threads which have terminated
			// prevents horrible memory leaks
			for (Thread t : ActiveConnections) {
				if(!t.isAlive()) {
					try {
						t.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}
}
