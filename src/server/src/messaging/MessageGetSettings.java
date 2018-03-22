package messaging;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import storage.Room;
import storage.StorageManager;

public class MessageGetSettings implements IMessage {

	public static final String requestName = "GetRoomSettingsRequest";
	public static final String responseName = "GetRoomSettingsResponse";

	// message parameters
	private int roomId;
	private JSONArray jUsers;
	private JSONArray jSites;
	
	// error flags
	private boolean roomDNE = false;
	
	@Override
	public boolean parseMessage(JSONObject message) {
		roomId = Integer.parseInt((String) message.get("RoomId"));
		
		if (!StorageManager.roomIdExists(roomId)) {
			roomDNE = true;
			return false;
		}
		return true;
	}

	@Override
	public boolean executeMessage() {
		StorageManager sm = new StorageManager();
		sm.lockRoom(roomId);
		Room room;
		List<String> users;
		List<String> sites;
		
		try {
			room = sm.getRoom(roomId);
		} catch (IOException e) {
			e.printStackTrace();
			sm.unlockRoom(roomId);
			return false;
		}

		users = room.getUsers();
		sites = room.getSettings().getUnproductiveSites();
		
		jUsers = new JSONArray();
		jUsers.addAll(users);
		jUsers.toJSONString();
		
		jSites = new JSONArray();
		jSites.addAll(sites);
		jSites.toJSONString();
		
		sm.unlockRoom(roomId);
		
		return true;
	}

	@Override
	public String createResponseMessage() {
		JSONObject o = new JSONObject();
		o.put("MessageType", responseName);
		o.put("WebsiteSettings", jSites);
		o.put("Users", jUsers);
		return o.toJSONString();
	}

	@Override
	public String createErrorMessage() {
		if(roomDNE) {
			return GenericMessageGenerator.invalidRoomIdError(roomId, "ChangeRoomSettings");
		}
		return GenericMessageGenerator.messageExecutionError(requestName);
	}

}
