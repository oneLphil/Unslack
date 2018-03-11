package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class StorageManager {

	private StorageSynchronizationEnsuree<Integer> SSE = StorageSynchronizationEnsuree.getInstance();
	
	public StorageManager() {
	}
	
	/*
	 * create a new room in the system
	 */
	public int createRoom(String userId) throws IOException {
	  int roomId = generateRoomId(userId);
	  Room newRoom = new Room(roomId);
	  newRoom.addUser(userId);
	  // TODO probably have to add an entry here
	  writeRoom(newRoom);
	  return roomId;
	}
	
	/*
	 * get a room read from storage
	 */
	public Room getRoom(int roomId) throws FileNotFoundException, IOException {
	  
	  RoomSerializerDeserializer roomSD = new RoomSerializerDeserializer();
	  
	  Room room;
	  File roomFile = new File("rooms"+ File.separator + roomId);
	  
	  SSE.lockStorage(roomId);
	  try{
	    room = roomSD.deserialize(new FileInputStream(roomFile), roomId);
	  }
	  catch(FileNotFoundException e){
	    System.err.println("Room is not in storage");
	    return null;
	  }
	  SSE.unlockStorage(roomId);
      return room;
	}
	
	/*
	 * writes a room into storage
	 */
	public void writeRoom(Room room) throws IOException{
	  
	  RoomSerializerDeserializer roomSD = new RoomSerializerDeserializer();
	  int roomId = room.getRoomID();
 
	  File roomFile = new File("rooms"+ File.separator + roomId);
	  SSE.lockStorage(roomId);
      try{
        roomSD.serialize(room, new FileOutputStream(roomFile));
      }
      catch(IOException e){
        System.err.println("StorageManager cannot write to file");
        e.printStackTrace();
        return;
      }
      SSE.unlockStorage(roomId);
	}
	
	/*
	 * Helper function to generate room IDs and check if id exist in room system
	 */
	private int generateRoomId(String userId) {
	  int roomId = userId.hashCode();
	  File roomFile = new File("rooms" + File.separator + roomId);
	  while (roomFile.exists()) {
	    roomId = UUID.randomUUID().hashCode();
	    roomFile = new File("rooms" + File.separator + roomId);
	  }
	  return roomId;
	}
	
}
