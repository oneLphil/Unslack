package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StorageManager {

	private StorageSynchronizationEnsuree<Integer> SSE = StorageSynchronizationEnsuree.getInstance();
	
	public StorageManager() {
		SSE.lockStorage(1);
		SSE.unlockStorage(1);
	}
	
	/*
	 * create a new room in the system
	 */
	public void createRoom(int roomId, int userId) throws IOException {
	  Room newRoom = new Room(roomId);
	  newRoom.addUser(userId);
	  // TODO probably have to add an entry here
	  writeRoom(newRoom);
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
	private void writeRoom(Room room) throws IOException{
	  
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
	
}
