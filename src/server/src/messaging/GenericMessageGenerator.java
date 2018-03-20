package messaging;

public class GenericMessageGenerator {
	
	public static String simpleResponseMessage(String messageName) {
		return String.format("{\"MessageType\":\"%s\"}", messageName);
	}
	
	public static String invalidRoomIdError(int roomId, String sentMessageType) {
		return String.format(
				"{\"MessageType\":\"Error\", "
				+ "\"ErrorMessage\":\"Room %d does not exist\", "
				+ "\"SourceMessageType\":\"%s\"}", 
				roomId, 
				sentMessageType);
	}
	
	public static String messageExecutionError(String sentMessageType) {
		return String.format(
				"{\"MessageType\":\"Error\", "
				+ "\"ErrorMessage\":\"An error occured somewhere in message execution\", "
				+ "\"SourceMessageType\":\"%s\"}", sentMessageType);
	}
	
}
