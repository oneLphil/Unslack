package tests;

import java.io.IOException;
import java.net.Socket;

import org.junit.jupiter.api.Test;

import messaging.SocketManager;

public class SocketManagerTest {

	public SocketManager createSocketManager() throws IOException {
		return new SocketManager();
	}
	
}
