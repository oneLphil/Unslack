package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class StorageManager {
  
    private static final String directory = "rooms" + File.separator;

	private StorageSynchronizationEnsuree<Integer> SSE = StorageSynchronizationEnsuree.getInstance();
	
	public StorageManager() {
	}
	
	/*
	 * create a new room in the system
	 */
	public int createRoom(String userId, String roomName) throws IOException {
	  int roomId = generateRoomId(userId);
	  Room newRoom = new Room(roomId, roomName);
	  newRoom.addUser(userId);
	  // TODO probably have to add an entry here
	  
	  lockRoom(roomId);
	  File dir = new File(directory);
	  // make the directory if it does not exist
	  if (!dir.exists()) {
	    dir.mkdirs();
	  }
	  writeRoom(newRoom);
	  unlockRoom(roomId);
	  
	  return roomId;
	}
	
	/*
	 * get a room read from storage
	 */
	public Room getRoom(int roomId) throws FileNotFoundException, IOException {
	  
	  RoomSerializerDeserializer roomSD = new RoomSerializerDeserializer();
	  
	  Room room;
	  File roomFile = new File(directory + roomId);
	  
	  try{
	    room = roomSD.deserialize(new FileInputStream(roomFile), roomId);
	  }
	  catch(FileNotFoundException e){
	    System.err.println("Room is not in storage");
	    return null;
	  }
      return room;
	}
	
	/*
	 * writes a room into storage
	 */
	private void writeRoom(Room room) throws IOException{
	  
	  RoomSerializerDeserializer roomSD = new RoomSerializerDeserializer();
	  int roomId = room.getRoomID();
 
	  File roomFile = new File(directory + roomId);
      try{
        roomSD.serialize(room, new FileOutputStream(roomFile));
      }
      catch(IOException e){
        System.err.println("StorageManager cannot write to file");
        e.printStackTrace();
        return;
      }
	}
	
	/*
	 * This method is for updating and changes to a room
	 * 
	 */
	public void updateRoom(Room room) throws IOException{
	  File roomFile = new File(directory + room.getRoomID());
	  if (!roomFile.exists()){
	    throw new FileNotFoundException();
	  }
	  writeRoom(room);
	}
	
	/*
	 * Helper function to generate room IDs and check if id exist in room system
	 */
	private int generateRoomId(String userId) {
	  int roomId = Math.abs(userId.hashCode());
	  File roomFile = new File(directory + roomId);
	  while (roomFile.exists()) {
	    roomId = Math.abs(UUID.randomUUID().hashCode());
	    roomFile = new File(directory + roomId);
	  }
	  return roomId;
	}
	
	/*
	 * Lock access to room via room ID
	 */
	public void lockRoom(int roomId){
	  SSE.lockStorage(roomId);
	}
	
	/*
     * Unlock access to room via room ID
     */
    public void unlockRoom(int roomId){
      SSE.unlockStorage(roomId);
    }
}
