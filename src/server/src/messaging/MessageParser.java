package messaging;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MessageParser {

	// returns true iff message was handled without errors
	public static String handleMessage(String messageString) {
		JSONParser parser = new JSONParser();
		String messageType = null;
		JSONObject message = null;
		
		// read the message type
		try {
			Object obj = parser.parse(messageString);
			message = (JSONObject)obj;
			messageType = (String) message.get("MessageType");
			
		} catch (ParseException e) {
			e.printStackTrace();
			return createErrorMessage("");
		}
		
		IMessage m;
	
		// handle the message type
		switch(messageType) {
			case MessageCreateRoom.requestName:
				System.out.println("CreateRoomRequest");
				m = new MessageCreateRoom();
				break;
			case MessageJoinRoom.requestName:
				System.out.println("JoinRoomRequest");
				m = new MessageJoinRoom();
				break;
			case MessageChangeRoomSettings.requestName:
				System.out.println("ChangeRoomSettingsRequest");
				m = new MessageChangeRoomSettings();
				break;
			case MessageGetLeaderboard.requestName: // unimplemented
				System.out.println("GetLeaderboardRequest");
				m = new MessageGetLeaderboard();
				break;
			case MessageGetSettings.requestName: // unimplemented
				System.out.println("GetRoomSettingsRequest");
				m = new MessageGetSettings();
				break;
			default:
				System.out.println("UnknownMessageType");
				return createErrorMessage(messageType);
		}
		
		if(!m.parseMessage(message)) {
			return m.createErrorMessage();
		}
		if(!m.executeMessage()) {
			return m.createErrorMessage();
		}
		
		return m.createResponseMessage();
	}
	
	private static String createErrorMessage(String messageType) {
		return String.format("{\"MessageType\":\"Error\", \"ErrorMessage\":\"Unrecognized message type\", \"SourceMessageType\":\"%s\"}", messageType);
	}
	
}
