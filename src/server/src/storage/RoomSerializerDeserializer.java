package storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class RoomSerializerDeserializer {
  
  /*
   * Serialize room into output stream
   */
  public void serialize(Room room, OutputStream output) throws IOException{
    
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
    
    //write room name
    writer.write("?RoomName: " + room.getRoomName());
    writer.newLine();
    
    writeSettings(room.getSettings(), writer);
    writeUsers(room.getUsers(), writer);
    if (!room.getScoreboard().isEmpty()){
      writeScoreBoard(room.getScoreboard(), writer);
    }
    
    
    writer.close();
    
}
  /*
   * Deserialize from input stream to a room
   */
  public Room deserialize(InputStream input, int roomId) throws IOException {
    
    BufferedReader buf = new BufferedReader(new InputStreamReader(input));
    Room newRoom = null;
    String newLine;
    while ((newLine = buf.readLine()) != null) {
      if (newLine.contains("?RoomName:")){
        String roomName = Arrays.asList(newLine.split(" ")).get(1);
        newRoom = new Room(roomId, roomName);
      }
      else if (newLine.contains("?Settings")) {
        readSettings(newRoom, buf);
      }
      else if (newLine.contains("?User IDs:")) {
        readUserIds(newRoom, buf);
      }
      else if (newLine.contains("?ScoreBoard:")) {
        readScoreboard(newRoom, buf);
      }
    }
    buf.close();
    
    return newRoom;
  }

 
  /*
   *  helper function that writes settings into output
   */
  public void writeSettings(Settings settings, BufferedWriter writer) throws IOException {
    //write Settings
    writer.write("?Settings");
    writer.newLine();
    
    writer.write("?Unproductive Sites:");
    writer.newLine();
    List<String> sites = settings.getUnproductiveSites();
    if (settings.getUnproductiveSites().isEmpty()) {
      writer.write("none");
    }
    else {
      // write unproductive in one line using separated with commas
      for (int i = 0; i < sites.size(); i++) {
        writer.write(sites.get(i));
        if (i != sites.size() - 1) {
          writer.write(",");
        }
      }
    }
    writer.newLine();
  }
  
  /*
   *  helper function that writes user IDs into output
   */
  private void writeUsers(List<String> list, BufferedWriter writer) throws IOException {
    
    writer.write("?User IDs:");
    writer.newLine();
    
    for (int i = 0; i < list.size(); i++) {
      writer.write(list.get(i));
      if (i != list.size() - 1){
        writer.write(",");
      } 
    }
    writer.newLine();
  }
  
  /*
   *  helper function that writes Score Entries into output
   */
  private void writeScoreBoard(List<ScoreEntry> scoreboard, BufferedWriter writer) throws IOException {
    
    writer.write("?ScoreBoard:");
    writer.newLine();
    
    for (ScoreEntry entry : scoreboard) {
      writer.write(Integer.toString(entry.getDate().get(Calendar.YEAR)));
      writer.write(",");
      writer.write(Integer.toString(entry.getDate().get(Calendar.MONTH)));
      writer.write(",");
      writer.write(Integer.toString(entry.getDate().get(Calendar.DAY_OF_MONTH)));
      writer.write(",");
      writer.write(entry.getUserId());
      writer.write(",");
      writer.write(Integer.toString(entry.getScore()));
      writer.newLine();
    }
  }
  
  /*
   * Helper function to read settings from buffer
   */
  private void readSettings(Room newRoom, BufferedReader buf) throws IOException {
    String newLine = buf.readLine();
    if (newLine.contains("?Unproductive Sites:")){
      newLine = buf.readLine();
      if (newLine.contains("none")){
        return;
      }
      List<String> sites = Arrays.asList(newLine.split(","));
      for (String site : sites) {
        newRoom.addUnproductiveSite(site);
      }
    }
  }
  
  /*
   * Helper function to read user ids from buffer
   */
  private void readUserIds(Room newRoom, BufferedReader buf) throws IOException {
    String newLine = buf.readLine();
    List<String> userIds = Arrays.asList(newLine.split(","));
    for (String userId : userIds) {
      newRoom.addUser(userId);
    }
  }
  
  /*
   * Helper function to read score entries from buffer
   */
  private void readScoreboard(Room newRoom, BufferedReader buf) throws IOException {
    String newLine;
    while ((newLine = buf.readLine()) != null){
      List<String> entry = Arrays.asList(newLine.split(","));
      int year = Integer.parseInt(entry.get(0));
      int month = Integer.parseInt(entry.get(1));
      int day = Integer.parseInt(entry.get(2));
      String userId = entry.get(3);
      int score = Integer.parseInt(entry.get(4));
      GregorianCalendar date = new GregorianCalendar(year, month, day);
      newRoom.addScoreEntry(date, userId, score);
    }
  }
}
