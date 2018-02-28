package startup;

import java.io.IOException;

import messaging.SocketManager;

public class Main {

	public static void main(String[] args) {
		System.out.println("Server starting up");
		
		// instantiate the SocketManager
		SocketManager pm = null;
		
		try {
			pm = new SocketManager();
		} catch (IOException e) {
			System.out.println("Error occured with port initialization");
			e.printStackTrace();
		}
		
		// start the SocketManager
		Thread socketManagerThread = new Thread(pm);
		socketManagerThread.start();
		
		// TODO: get rid of this for production
		// wait before shutting down server
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			// shut down the SocketManager
			pm.shutDownSocketManager();
			// join the SocketManager thread
			socketManagerThread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Shutting down server");
	}
	
}
