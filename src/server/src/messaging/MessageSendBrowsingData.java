package messaging;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import storage.Room;
import storage.StorageManager;

public class MessageSendBrowsingData implements IMessage {
  
    public static final String requestName = "SendDataRequest";
    public static final String responseName = "SendDataResponse";
    
    // message parameters
    private int roomId;
    private String userName;
    private JSONArray history;
    private StorageManager sm = new StorageManager();
    private ScoreGenerator sg = new ScoreGenerator();
    
    // error flags
    private boolean roomDNE = false;

	@Override
	public boolean parseMessage(JSONObject message) {
	    roomId = Integer.parseInt((String) message.get("RoomId"));
	    userName = (String) message.get("UserId");
	    history = (JSONArray)message.get("History");
	    if (!StorageManager.roomIdExists(roomId)){
	      roomDNE = true;
	      return false;
	    }
	    else if (history == null) {
	      return false;
	    }
	    else if(userName == null) {
          return false;
        }
		return true;
	}

	@Override
	public boolean executeMessage() {
	    sm.lockRoom(roomId);
	    
	    Room room;
  	    try {
            room = sm.getRoom(roomId);
        } catch (IOException e) {
            e.printStackTrace();
            sm.unlockRoom(roomId);
            return false;
        }
  	    
  	    sg.addScoreEntry(room, history, userName);
  	    
      	try {
            sm.updateRoom(room);
        } catch (IOException e) {
            e.printStackTrace();
            sm.unlockRoom(roomId);
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
        return GenericMessageGenerator.invalidRoomIdError(roomId, requestName);
      }
	  return GenericMessageGenerator.messageExecutionError(requestName);
	}

}
