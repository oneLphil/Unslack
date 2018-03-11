package messaging;

import org.json.simple.JSONObject;

public interface IMessage {

	// parse message. return true iff parsed without error
	public boolean parseMessage(JSONObject message);
	
	// executes message behaviour after parsing a message.
	public boolean executeMessage();
	
	// creates a response message
	public String createResponseMessage();
}
