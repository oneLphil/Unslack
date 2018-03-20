package messaging;

import org.json.simple.JSONObject;

public class MessageGetLeaderboard implements IMessage{

	public static final String requestName = "GetLeaderboardRequest";
	public static final String responseName = "GetLeaderboardResponse";

	@Override
	public boolean parseMessage(JSONObject message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean executeMessage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String createResponseMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
