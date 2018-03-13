package messaging;

public interface IMessage {

	// parse message. return true iff parsed without error
	public boolean parseMessage(/*String message*/);
	
	// executes message behaviour after parsing a message.
	public boolean executeMessage();
	
	// creates a response message
	public String createResponseMessage();
}
