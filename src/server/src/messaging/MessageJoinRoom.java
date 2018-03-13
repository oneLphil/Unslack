package messaging;

import java.io.IOException;

import org.json.simple.JSONObject;

import storage.Room;
import storage.StorageManager;

public class MessageJoinRoom implements IMessage {

	int RoomId;
	String uId;
	
	boolean userAlreadyExists;
	
	public MessageJoinRoom() {
		RoomId = -1;
		uId = null;
		userAlreadyExists = false;
	}
	
	@Override
	public boolean parseMessage(JSONObject message) {
		RoomId = Integer.parseInt((String) message.get("RoomId"));
		uId = (String) message.get("UserName");
		if (!StorageManager.roomIdExists(RoomId) || uId == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean executeMessage() {
		StorageManager m = new StorageManager();
		m.lockRoom(RoomId);
		
		Room r;
		try {
			r = m.getRoom(RoomId);
		} catch (IOException e) {
			e.printStackTrace();
			m.unlockRoom(RoomId);
			return false;
		}
		
		if (r.hasUser(uId)) {
			userAlreadyExists = true;
			m.unlockRoom(RoomId);
			return false;
		}
		
		r.addUser(uId);
		
		try {
			m.updateRoom(r);
		} catch (IOException e) {
			e.printStackTrace();
			m.unlockRoom(RoomId);
			return false;
		}
		
		m.unlockRoom(RoomId);
		return true;
	}

	@Override
	public String createResponseMessage() {
		return String.format("{\"MessageType\":\"JoinRoomResponse\"}");
	}

	@Override
	public String createErrorMessage() {
		if (userAlreadyExists) {
			return String.format("{\"MessageType\":\"Error\", \"ErrorMessage\":\"%s\", \"SourceMessageType\":\"%s\"}", "That username has already been taken for this room", "JoinRoomRequest");
		}
		
		return String.format("{\"MessageType\":\"Error\", \"ErrorMessage\":\"%s\", \"SourceMessageType\":\"%s\"}", "Invalid arugments", "JoinRoomRequest");
	}

}
