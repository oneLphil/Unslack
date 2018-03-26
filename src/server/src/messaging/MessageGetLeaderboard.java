package messaging;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import storage.Room;
import storage.StorageManager;

public class MessageGetLeaderboard implements IMessage{
    
	public static final String requestName = "GetLeaderboardRequest";
	public static final String responseName = "GetLeaderboardResponse";

	// message parameters
    private int roomId;
    JSONArray lastDay, lastWeek, lastMonth = new JSONArray();
    private StorageManager sm = new StorageManager();
    private ScoreGenerator sg = new ScoreGenerator();
    
    // error flags
    private boolean roomDNE = false;
    
	@Override
	public boolean parseMessage(JSONObject message) {
	    roomId = Integer.parseInt((String) message.get("RoomId"));
        if (!StorageManager.roomIdExists(roomId)){
          roomDNE = true;
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
        
        lastDay = sg.getScore(room.getScoreboard(), room.getUsers(), -1);
        lastWeek = sg.getScore(room.getScoreboard(), room.getUsers(), -7);
        lastMonth = sg.getScore(room.getScoreboard(), room.getUsers(), -30);
        
	    sm.unlockRoom(roomId);
	    
		return true;
	}

    @Override
    public String createResponseMessage() {
      JSONObject response = new JSONObject();
      response.put("MessageType",responseName);
      response.put("LastDay", lastDay);
      response.put("LastWeek", lastWeek);
      response.put("LastMonth", lastMonth);
      return response.toJSONString();
    }

    @Override
    public String createErrorMessage() {
      if(roomDNE) {
        return GenericMessageGenerator.invalidRoomIdError(roomId, requestName);
      }
      return GenericMessageGenerator.messageExecutionError(requestName);
    }

}
