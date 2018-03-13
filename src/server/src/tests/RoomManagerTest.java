package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import storage.Room;
import storage.StorageManager;

public class RoomManagerTest {

  String userName = "user";
  String roomName = "Unslack";
  int roomId;
  StorageManager sm = new StorageManager();
  
  //util
  public int createRoom() throws IOException {
    return sm.createRoom(userName, roomName);
  }
  
  @Before
  public void setupRoomTests() throws IOException {
    roomId = createRoom();
  }
  
  @Test
  public void createRoomTest() throws FileNotFoundException, IOException {
    Room room = sm.getRoom(roomId);
    
    // Check if room name is created correctly
    assertEquals(room.getRoomName(), roomName);
    
    // Check if unproductive sites are empty
    assertEquals(room.getSettings().getUnproductiveSites(), new ArrayList<String>());
    
    List<String> users = new ArrayList<String>();
    users.add(userName);
    // Check if owner of the room is added to users
    assertEquals(room.getUsers(), users);
    
    
  }
  
  @Test
  public void addUsersTest() throws FileNotFoundException, IOException{
    Room room = sm.getRoom(roomId);
    List<String> users = new ArrayList<String>();
    users.add(userName);
    
    // only user is in room
    assertEquals(users, room.getUsers());
    
    String newUser = "newUser";
    users.add(newUser);
    room.addUser(newUser);
    sm.updateRoom(room);
    Room updatedRoom = sm.getRoom(roomId);
    
    // new user is added to room
    assertEquals(users, updatedRoom.getUsers());
  }
  
  @Test
  public void changeUnproductiveSitesTest() throws FileNotFoundException, IOException{
    Room room = sm.getRoom(roomId);
    List<String> sites = new ArrayList<String>();
    
    // check there is no unproductive sites in setting
    assertEquals(room.getSettings().getUnproductiveSites(), sites);
    
    String newSite = "www.youtube.com";
    sites.add(newSite);
    room.addUnproductiveSite(newSite);
    sm.updateRoom(room);
    Room updatedRoom = sm.getRoom(roomId);
    
    // check if new site is added
    assertEquals(sites, updatedRoom.getSettings().getUnproductiveSites());
    
    sites.clear();
    updatedRoom.removeUnproductiveSite(newSite);
    sm.updateRoom(updatedRoom);
    Room updatedRoom2 = sm.getRoom(roomId);
    
    // check if new site is removed
    assertEquals(sites, updatedRoom2.getSettings().getUnproductiveSites());
    
  }
}
