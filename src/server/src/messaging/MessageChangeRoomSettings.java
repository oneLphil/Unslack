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
	private JSONArray addSites;
	private JSONArray removeSites;
	
	// error flags
	boolean roomDNE = false;
	
	@Override
	public boolean parseMessage(JSONObject message) {
		roomId = Integer.parseInt((String) message.get("RoomId"));
		addSites = (JSONArray) message.get("AddToBlacklist");
		removeSites = (JSONArray) message.get("RemoveFromBlacklist");

		if (!StorageManager.roomIdExists(roomId)) {
			roomDNE = true;
			return false;
		}
		else if (addSites == null || removeSites == null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean executeMessage() {
		StorageManager sm = new StorageManager();
		sm.lockRoom(roomId);
		Room room;
		Iterator<?> sites;
		
		try {
			room = sm.getRoom(roomId);
		} catch (IOException e) {
			e.printStackTrace();
			sm.unlockRoom(roomId);
			return false;
		}
	
		// adds sites
		sites = addSites.iterator();
		while (sites.hasNext()) {
			try {
				room.addUnproductiveSite(sites.next().toString());
			}catch(IllegalArgumentException e) {
				// TODO, create response for user				
			}
		}
		
		// remove sites
		sites = removeSites.iterator();
		while (sites.hasNext()) {
			try {
				room.removeUnproductiveSite(sites.next().toString());				
			}catch(IllegalArgumentException e) {
				// TODO, create response for user
			}
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
