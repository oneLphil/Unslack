package messaging;

import java.io.IOException;

import org.json.simple.JSONObject;

import storage.StorageManager;

public class MessageCreateRoom implements IMessage{

	private String uId;
	private int roomId;
	
	public MessageCreateRoom() {
		
	}
	
	@Override
	public boolean parseMessage(JSONObject message) {
		uId = (String) message.get("UserName");
		if (uId == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean executeMessage() {
		StorageManager sm = new StorageManager();
		try {
			roomId = sm.createRoom(uId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public String createResponseMessage() {
		return String.format("{\"MessageType\":\"CreateRoomResponse\", \"RoomId\":%d}", roomId);
	}
	
}
