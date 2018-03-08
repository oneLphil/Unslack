package storage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;


public class RoomSerializerDeserializer {
  
  /*
   * Serialize room into output stream
   */
  public void serialize(Room room, OutputStream output) throws IOException{
    
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
    
    writeSettings(room.getSettings(), writer);
    writeUsers(room.getUsers(), writer);
    writeScoreBoard(room.getScoreboard(), writer);
    
    writer.close();
    
}

  /*
   *  helper function that writes settings into output
   */
  public void writeSettings(Settings settings, BufferedWriter writer) throws IOException {
    //write Settings
    writer.write("Settings");
    writer.newLine();
    writer.write("Unproductive Site:");
    writer.newLine();
    List<String> sites = settings.getUnproductiveSites();
    
    // write unproductive in one line using separated with commas
    for (int i = 0; i < sites.size(); i++) {
      writer.write(sites.get(i));
      if (i != sites.size() - 1) {
        writer.write(",");
      }
    }
    writer.newLine();
  }
  
  /*
   *  helper function that writes user IDs into output
   */
  private void writeUsers(List<Integer> users, BufferedWriter writer) throws IOException {
    
    writer.write("User IDs:");
    writer.newLine();
    
    for (int i = 0; i < users.size(); i++) {
      writer.write(users.get(i).toString());
      if (i != users.size() - 1){
        writer.write(",");
      } 
    }
    writer.newLine();
  }
  
  /*
   *  helper function that writes Score Entries into output
   */
  private void writeScoreBoard(List<ScoreEntry> scoreboard, BufferedWriter writer) throws IOException {
    
    writer.write("ScoreBoard:");
    writer.newLine();
    
    for (ScoreEntry entry : scoreboard) {
      writer.write(Integer.toString(entry.getDate().get(1)));
      writer.write(",");
      writer.write(Integer.toString(entry.getDate().get(2)));
      writer.write(",");
      writer.write(Integer.toString(entry.getDate().get(3)));
      writer.write(",");
      writer.write(Integer.toString(entry.getUserId()));
      writer.write(",");
      writer.write(Integer.toString(entry.getScore()));
      writer.newLine();
    }
  }
  
}
