package messaging;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MessageParser {

	// returns true iff message was handled without errors
	public static String handleMessage(String messageString) {
		JSONParser parser = new JSONParser();
		String messageType = null;
		
		// read the message type
		try {
			Object obj = parser.parse(messageString);
			JSONArray array = (JSONArray)obj;
			
			JSONObject message = (JSONObject)(array.get(0));
			messageType = (String) message.get("MessageType");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		IMessage m;
		
		// handle the message type
		switch(messageType) {
			case "createRoom":
				System.out.println("CreateRoomMessage");
				m = new MessageCreateRoom();
				break;
			
			default:
				System.out.println("UnknownMessageType");
				return createErrorMessage();
		}
		
		if(!m.parseMessage()) {
			return createErrorMessage();
		}
		if(!m.executeMessage()) {
			return createErrorMessage();
		}
		
		return m.createResponseMessage();
	}
	
	private static String createErrorMessage() {
		return "Error with the message you sent";
	}
	
}
