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
		
		int roomId = 2645995;
		
		// create room message
		//bw.write(delim + sampleCreateRoom() + delim);

		// join room message
		//bw.write(delim + sampleJoinRoom(roomId) + delim);
		
		// change room settings message
		//bw.write(delim + sampleChangeRoomSettings(roomId) + delim);
		
		// get room settings message
		bw.write(delim + sampleGetRoomSettings(roomId) + delim);
		//System.out.println(sampleGetRoomSettings(roomId));
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
	
	public static String sampleJoinRoom(int roomId) {
		return "{"
		+ "\"MessageType\":\"JoinRoomRequest\", "
		+ "\"UserName\":\"User_joiner\", "
		+ "\"RoomId\":\"" + roomId +"\""
		+ "}";
	}
	
	public static String sampleChangeRoomSettings(int roomId) {
		return 	"{"
				+ "\"MessageType\":\"ChangeRoomSettingsRequest\","
				+ "\"RoomId\":\"" + roomId + "\","
				+ "\"AddToBlacklist\":[\"www.facebook.com\", \"www.twitter.com\"],"
				+ "\"RemoveFromBlacklist\":[\"www.facebook.com\"]"
				+ "}";
	}
	
	public static String sampleGetRoomSettings(int roomId) {
		return 	"{"
				+ "\"MessageType\":\"GetRoomSettingsRequest\","
				+ "\"RoomId\":\"" + roomId + "\""
				+ "}";
	}
}
