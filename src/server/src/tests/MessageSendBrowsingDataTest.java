package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import messaging.MessageSendBrowsingData;
import storage.Room;
import storage.ScoreEntry;
import storage.StorageManager;

public class MessageSendBrowsingDataTest {
  String userName = "user";
  String user2 = "user2";
  String user3 = "user3";
  String roomName = "Unslack";
  int roomId;
  StorageManager sm = new StorageManager();
  MessageSendBrowsingData m = new MessageSendBrowsingData();
  
  //util
  public int createRoomWithUnproductiveSitesAndMultipleUsers() throws IOException {
    roomId = sm.createRoom(userName, roomName);
    Room room = sm.getRoom(roomId);
    room.addUnproductiveSite("www.youtube.com");
    room.addUser(user2);
    room.addUser(user3);
    sm.updateRoom(room);
    return roomId;
  }
  
  @Before
  public void setupSendScoreTests() throws IOException {
    roomId = createRoomWithUnproductiveSitesAndMultipleUsers();
  }
  
  @Test
  public void sendScoreDoesNotExistTest() throws FileNotFoundException, IOException{
    JSONObject message = new JSONObject();
    message.put("MessageType","SendDataRequest");
    message.put("RoomId", Integer.toString(roomId));
    message.put("UserId", userName);
    JSONArray entry1 = new JSONArray();
    entry1.add(0, "www.youtube.com");
    entry1.add(1, 30);
    JSONArray entry2 = new JSONArray();
    entry2.add(0, "www.unslack.com");
    entry2.add(1, 20);
    JSONArray history = new JSONArray();
    history.add(0, entry1);
    history.add(1, entry2);
    message.put("History", history);
    assertTrue(m.parseMessage(message));
    
    m.executeMessage();
    Room updatedRoom = sm.getRoom(roomId);
    List<ScoreEntry> scoreboard = updatedRoom.getScoreboard();
    for(ScoreEntry entry : scoreboard) {
      if (entry.getUserId().equals(userName)){
        assertEquals(entry.getScore(), -10);
      }
      else {
        assertEquals(entry.getScore(), 0);
      }
    }
  }
  
  @Test
  public void sendScoreExistTest() throws FileNotFoundException, IOException {
    // send 1st message
    JSONObject message = new JSONObject();
    message.put("MessageType","SendDataRequest");
    message.put("RoomId", Integer.toString(roomId));
    message.put("UserId", userName);
    JSONArray entry1 = new JSONArray();
    entry1.add(0, "www.youtube.com");
    entry1.add(1, 30);
    JSONArray history = new JSONArray();
    history.add(0, entry1);
    message.put("History", history);
    assertTrue(m.parseMessage(message));
    m.executeMessage();
    
    // send 2nd message
    message = new JSONObject();
    message.put("MessageType","SendDataRequest");
    message.put("RoomId", Integer.toString(roomId));
    message.put("UserId", user2);
    entry1 = new JSONArray();
    entry1.add(0, "www.youtube.com");
    entry1.add(1, 20);
    history = new JSONArray();
    history.add(0, entry1);
    message.put("History", history);
    assertTrue(m.parseMessage(message));
    m.executeMessage();
    Room updatedRoom = sm.getRoom(roomId);
    List<ScoreEntry> scoreboard = updatedRoom.getScoreboard();
    for(ScoreEntry entry : scoreboard) {
      if (entry.getUserId().equals(userName)){
        assertEquals(entry.getScore(), -30);
      }
      else if (entry.getUserId().equals(user2)) {
        assertEquals(entry.getScore(), -20);
      }
      else {
        assertEquals(entry.getScore(), 0);
      }
    }
  }
  
}
