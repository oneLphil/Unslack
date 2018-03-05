package messaging;

public class MessageCreateRoom implements IMessage{

	public MessageCreateRoom() {
		
	}
	
	@Override
	public boolean parseMessage() {
		// TODO
		return true;
	}

	@Override
	public boolean executeMessage() {
		// TODO: send command to storage manager to create a room
		return true;
	}

	@Override
	public String createResponseMessage() {
		return "CreateRoomMessage was handled";
	}
	
}
