package messaging;

import java.io.IOException;

import org.json.simple.JSONObject;

import storage.StorageManager;

public class MessageCreateRoom implements IMessage{
	
	public static final String requestName = "CreateRoomRequest";
	public static final String responseName = "CreateRoomResponse";

	private String uId, roomName;
	private int roomId;
	
	public MessageCreateRoom() {
		
	}
	
	@Override
	public boolean parseMessage(JSONObject message) {
		uId = (String) message.get("UserName");
		roomName = (String) message.get("RoomName");
		if (uId == null || uId.equals("") || roomName == null || roomName.equals("")) {
			return false;
		}
		return true;
	}

	@Override
	public boolean executeMessage() {
		StorageManager sm = new StorageManager();
		try {
			roomId = sm.createRoom(uId, roomName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public String createResponseMessage() {
		return String.format("{\"MessageType\":\"%s\", \"RoomId\":%d}", responseName, roomId);
	}

	@Override
	public String createErrorMessage() {
		return String.format("{\"MessageType\":\"Error\", \"ErrorMessage\":\"%s\", \"SourceMessageType\":\"%s\"}", "Invalid arugments", requestName);
	}
	
}
