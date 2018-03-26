package tests;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import messaging.MessageGetLeaderboard;
import storage.Room;
import storage.StorageManager;

public class GetScoreBoardTest {
  String userName = "user";
  String user2 = "user2";
  String user3 = "user3";
  String roomName = "Unslack";
  int roomId;
  StorageManager sm = new StorageManager();
  MessageGetLeaderboard m = new MessageGetLeaderboard();
  
  
  //util
  public int createRoomWithUnproductiveSitesAndMultipleUsers() throws IOException {
    roomId = sm.createRoom(userName, roomName);
    Room room = sm.getRoom(roomId);
    room.addUnproductiveSite("www.youtube.com");
    room.addUser(user2);
    room.addUser(user3);
    room.addScoreEntry(Calendar.getInstance(), userName, 1);
    room.addScoreEntry(new GregorianCalendar(2018, 2, 20), userName, 1);
    room.addScoreEntry(new GregorianCalendar(2018, 2, 15), userName, 1);
    room.addScoreEntry(Calendar.getInstance(), user2, 1);
    room.addScoreEntry(Calendar.getInstance(), user3, 1);
    sm.updateRoom(room);
    return roomId;
  }
  
  @Before
  public void setupGetScoreTests() throws IOException {
    roomId = createRoomWithUnproductiveSitesAndMultipleUsers();
  }
  
  @Test
  public void getScoresTest() throws ParseException{
    JSONParser parser = new JSONParser();
    JSONObject message = new JSONObject();
    message.put("MessageType", "GetLeaderboardRequest");
    message.put("RoomId", Integer.toString(roomId));
    assertTrue(m.parseMessage(message));
    assertTrue(m.executeMessage());
    JSONObject response = (JSONObject)parser.parse(m.createResponseMessage());
    System.out.println(response);
    assertEquals("1", (((JSONArray)((JSONArray)response.get("LastDay")).get(0)).get(1)).toString());
    assertEquals("1", (((JSONArray)((JSONArray)response.get("LastDay")).get(1)).get(1)).toString());
    assertEquals("2", (((JSONArray)((JSONArray)response.get("LastWeek")).get(0)).get(1)).toString());
    assertEquals("3", (((JSONArray)((JSONArray)response.get("LastMonth")).get(0)).get(1)).toString());
  }
  
}
