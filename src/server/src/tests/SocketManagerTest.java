package tests;

import java.io.IOException;
import java.net.Socket;

import org.junit.jupiter.api.Test;

import messaging.SocketManager;

public class SocketManagerTest {

	public SocketManager createPortManager() throws IOException {
		return new SocketManager();
	}
	
	@Test
	public void connectAndCloseSocket() throws Exception {
		SocketManager pm = createPortManager();
		Socket us = new Socket("localhost", 9999);
		us.close();
	}
	
	@Test 
	public void openAPort() throws Exception {
		Thread.sleep(1000);
		SocketManager pm = createPortManager();
		//Thread.sleep(1000);
		//pm.shutDownPorts();
	}
}
