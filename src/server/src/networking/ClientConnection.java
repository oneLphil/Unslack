package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import messaging.MessageParser;

public class ClientConnection implements Runnable{

	private Socket clientSocket;
	public static final char messageDelimChar = '\f';
	
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
		System.out.println("thread end");
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

		// handle reading the message
		String message = "";
		boolean reading = false;
		
		while(in.ready()) {
			char tmp = (char) in.read();
			
			if(reading) {
				if(tmp == messageDelimChar) {
					reading = false;
				} else {
					message += tmp;	
				}
			} else if(tmp == messageDelimChar) {
				reading = true;
			}
		}
		
		System.out.printf("mymessage: %s\n", message);
		
		// handle the message execution
		String responseMessage = MessageParser.handleMessage(message);

		out.println("HTTP/1.1 200 OK");
		out.println("Connection: close");
		out.println();
		out.flush();
		out.println(responseMessage);
		
		System.out.println("client closed");
		out.close();
		in.close();
	}

}
