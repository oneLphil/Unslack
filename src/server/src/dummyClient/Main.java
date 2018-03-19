package dummyClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import networking.SocketManager;

public class Main {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		// init variables
		int port = SocketManager.DEFAULT_PORT;
		Socket socket = new Socket("localhost", port);
		BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//PrintWriter pw = new PrintWriter(socket.getOutputStream());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		System.out.println("Client startup sucessful");
		
		// create room message
		bw.write(sampleCreateRoom());

		// join room message
		//bw.write(sampleJoinRoom());
		
		// change room settings message
		//bw.write(sampleChangeRoomSettings());
		
		bw.flush();
		socket.shutdownOutput();
		
		System.out.println("message sent to server");
		
		System.out.println("Server sent: " + bf.readLine());
		
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
				+ "\"RoomId\":\"944687404\""
				+ "}";
	}
	
	public static String sampleChangeRoomSettings() {
		return "{"
				+ "\"MessageType\":\"ChangeRoomSettingsRequest\","
				+ "\"RoomId\":\"2645995\","
				+ "\"WebsiteSettings\":[\"www.facebook.com\"]"
				+ "}";
	}
}
