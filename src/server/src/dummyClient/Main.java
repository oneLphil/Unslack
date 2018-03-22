package dummyClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import networking.ClientConnection;
import networking.SocketManager;

public class Main {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		// init variables
		int port = SocketManager.DEFAULT_PORT;
		Socket socket = new Socket("localhost", port);
		BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		System.out.println("Client startup sucessful");
		
		char delim = ClientConnection.messageDelimChar;
		
		// create room message
		//bw.write(delim + sampleCreateRoom() + delim);

		// join room message
		//bw.write(delim + sampleJoinRoom() + delim);
		
		// change room settings message
		bw.write(delim + sampleChangeRoomSettings() + delim);
		
		bw.flush();
		
		// delay to test read blocking 
		Thread.sleep(1000);
		
		socket.shutdownOutput();
		
		System.out.println("message sent to server");
		
		String response = "";
		
		while(bf.ready()) {
			response += (char)bf.read();
		}
		System.out.println("Server sent: " + response);
		
		// clean up
		bf.close();
		socket.close();
		
		System.out.println("Client terminated");
	}
	
	public static String sampleCreateRoom() {
		return "{"
				+ "\"MessageType\":\"CreateRoomRequest\", "
				+ "\"UserName\":\"User\", "
				+ "\"RoomName\":\"NewRoom\""
				+ "}";
	}
	
	public static String sampleJoinRoom() {
		return "{"
				+ "\"MessageType\":\"JoinRoomRequest\", "
				+ "\"UserName\":\"User_joiner\", "
				+ "\"RoomId\":\"2645995\""
				+ "}";
	}
	
	public static String sampleChangeRoomSettings() {
		return "{"
				+ "\"MessageType\":\"ChangeRoomSettingsRequest\","
				+ "\"RoomId\":\"2645995\","
				+ "\"AddToBlacklist\":[\"www.facebook.com\", \"www.twitter.com\"],"
				+ "\"RemoveFromBlacklist\":[\"www.facebook.com\"]"
				+ "}";
	}
}
