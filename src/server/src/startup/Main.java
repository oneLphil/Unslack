package startup;

import java.io.IOException;

import messaging.SocketManager;

public class Main {

	public static void main(String[] args) {
		System.out.println("test");
		SocketManager pm = null;
		
		try {
			pm = new SocketManager();
		} catch (IOException e) {
			System.out.println("Error occured with port initialization");
			e.printStackTrace();
		}
		try {
			pm.shutDownSocketManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Shutting down server");
	}
	
}
