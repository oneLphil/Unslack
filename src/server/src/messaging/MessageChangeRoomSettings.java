package messaging;

import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import storage.Room;
import storage.StorageManager;

public class MessageChangeRoomSettings implements IMessage{

	public static final String requestName = "ChangeRoomSettingsRequest";
	public static final String responseName = "ChangeRoomSettingsResponse";

	// message parameters
	private int roomId;
	private JSONArray newSettings;
	
	// error flags
	boolean roomDNE = false;
	
	@Override
	public boolean parseMessage(JSONObject message) {
		roomId = Integer.parseInt((String) message.get("RoomId"));
		newSettings = (JSONArray) message.get("WebsiteSettings");
		if (!StorageManager.roomIdExists(roomId)) {
			roomDNE = true;
			return false;
		}
		else if (newSettings == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean executeMessage() {
		StorageManager sm = new StorageManager();
		sm.lockRoom(roomId);
		Room room;
		try {
			room = sm.getRoom(roomId);
		} catch (IOException e) {
			e.printStackTrace();
			sm.unlockRoom(roomId);
			return false;
		}
	
		Iterator<?> sites = newSettings.iterator();

		while (sites.hasNext()) {
			room.addUnproductiveSite(sites.next().toString());
		}
		
		try {
			sm.updateRoom(room);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		sm.unlockRoom(roomId);
		
		return true;
	}

	@Override
	public String createResponseMessage() {
		return GenericMessageGenerator.simpleResponseMessage(responseName);
	}

	@Override
	public String createErrorMessage() {
		if(roomDNE) {
			return GenericMessageGenerator.invalidRoomIdError(roomId, "ChangeRoomSettings");
		}
		return GenericMessageGenerator.messageExecutionError(requestName);
	}

}
