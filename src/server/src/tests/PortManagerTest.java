package tests;

import java.io.IOException;
import java.net.Socket;

import org.junit.jupiter.api.Test;

import messaging.PortManager;

public class PortManagerTest {

	public PortManager createPortManager() throws IOException {
		return new PortManager();
	}
	
	@Test
	public void connectAndCloseSocket() throws Exception {
		PortManager pm = createPortManager();
		Socket us = new Socket("localhost", 9999);
		us.close();
	}
	
	@Test 
	public void openAPort() throws Exception {
		Thread.sleep(1000);
		PortManager pm = createPortManager();
		//Thread.sleep(1000);
		//pm.shutDownPorts();
	}
}
