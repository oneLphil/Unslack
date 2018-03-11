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
		}
		
		IMessage m;
	
		// handle the message type
		switch(messageType) {
			case "CreateRoomRequest":
				System.out.println("CreateRoomRequest");
				m = new MessageCreateRoom();
				break;
			
			default:
				System.out.println("UnknownMessageType");
				return createErrorMessage(messageType);
		}
		
		if(!m.parseMessage(message)) {
			return createErrorMessage(messageType);
		}
		if(!m.executeMessage()) {
			return createErrorMessage(messageType);
		}
		
		return m.createResponseMessage();
	}
	
	private static String createErrorMessage(String messageType) {
		return String.format("{\"MessageType\":\"Error\", \"ErrorMessage\":\"GenericError\", \"SourceMessageType\":\"%s\"}", messageType);
	}
	
}