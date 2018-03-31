package messaging;

import java.io.IOException;

import org.json.simple.JSONObject;

import storage.Room;
import storage.StorageManager;

public class MessageJoinRoom implements IMessage {

	public static final String requestName = "JoinRoomRequest";
	public static final String responseName = "JoinRoomResponse";
	
	// message parameters
	int roomId;
	String uId;
	String roomName;

	// error flags
	boolean roomDNE;
	boolean userAlreadyExists;
	
	public MessageJoinRoom() {
		roomId = -1;
		uId = null;
		roomDNE = false;
		userAlreadyExists = false;
	}
	
	@Override
	public boolean parseMessage(JSONObject message) {
		roomId = Integer.parseInt((String) message.get("RoomId"));
		uId = (String) message.get("UserName");
		if (!StorageManager.roomIdExists(roomId)) {
			roomDNE = true;
			return false;
		}	
		else if(uId == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean executeMessage() {
		StorageManager m = new StorageManager();
		m.lockRoom(roomId);
		
		Room r;
		try {
			r = m.getRoom(roomId);
		} catch (IOException e) {
			e.printStackTrace();
			m.unlockRoom(roomId);
			return false;
		}
		
		if (r.hasUser(uId)) {
			userAlreadyExists = true;
			m.unlockRoom(roomId);
			return false;
		}
		
		r.addUser(uId);
		roomName = r.getRoomName();
		
		try {
			m.updateRoom(r);
		} catch (IOException e) {
			e.printStackTrace();
			m.unlockRoom(roomId);
			return false;
		}
		
		m.unlockRoom(roomId);
		return true;
	}

	@Override
	public String createResponseMessage() {
		//return GenericMessageGenerator.simpleResponseMessage(requestName);
		JSONObject o = new JSONObject();
		o.put("MessageType", responseName);
		o.put("RoomName", roomName);
		return o.toString();
	}

	@Override
	public String createErrorMessage() {
		if (roomDNE) {
			return GenericMessageGenerator.invalidRoomIdError(roomId, requestName);
		}
		else if (userAlreadyExists) {
			return String.format("{\"MessageType\":\"Error\", \"ErrorMessage\":\"%s\", \"SourceMessageType\":\"%s\"}", "That username has already been taken for this room", requestName);
		}
		
		return String.format("{\"MessageType\":\"Error\", \"ErrorMessage\":\"%s\", \"SourceMessageType\":\"%s\"}", "Invalid arugments", requestName);
	}

}
