package storage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/*
 * The representation of a room containing users
 * 
 */
public class Room {
  private int roomID;
  private List<User> users = new ArrayList<User>();
  private List<DailyScoreEntry> scoreboard = new ArrayList<DailyScoreEntry>();
  
  public Room(int roomID) {
    this.roomID = roomID;
  }
  
  // Add a new user to the room if the room does not contain that user
  public void addUser(User newUser) {
    if (!users.contains(newUser)){
      users.add(newUser);
    }
  }
  
  // Remove the specified user from the room
  public void removeUser(User user) {
    if (users.contains(user)) {
      users.remove(user);
    }
  }
  
  
  public void addScoreEntry(Calendar date, User user, int score) {
     for (DailyScoreEntry dailyEntry : scoreboard) {
       // If the date is already in scoreboard, add the entry to that date
       if (dailyEntry.getDate() == date){
         dailyEntry.addScoreEntry(user, score);
         return;
       }
     }
     // Else create a new DailyScoreEntry with the date and insert the user and score
     DailyScoreEntry newEntry = new DailyScoreEntry(date);
     newEntry.addScoreEntry(user, score);
     scoreboard.add(newEntry);     
  }
  
  public List<User> getUsers() {
    return users;
  }

  public int getRoomID() {
    return roomID;
  }

  public List<DailyScoreEntry> getScoreboard() {
    return scoreboard;
  }
    
}
