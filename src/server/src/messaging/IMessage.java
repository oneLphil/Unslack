package messaging;

import org.json.simple.JSONObject;

public interface IMessage {

	public String requestName = "";
	public String responseName = "";

	// parse message. return true iff parsed without error
	public boolean parseMessage(JSONObject message);
	
	// executes message behaviour after parsing a message.
	public boolean executeMessage();
	
	// creates a response message
	public String createResponseMessage();
	
	// creates an error message based on the current state
	public String createErrorMessage();
}
