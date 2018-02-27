package startup;

import java.io.IOException;

import messaging.PortManager;

public class Main {

	public static void main(String[] args) {
		System.out.println("test");
		PortManager pm = null;
		
		try {
			pm = new PortManager();
		} catch (IOException e) {
			System.out.println("Error occured with port initialization");
			e.printStackTrace();
		}
		try {
			pm.shutDownPorts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Shutting down server");
	}
	
}
