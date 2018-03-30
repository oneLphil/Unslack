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
  private String roomName;
  private Settings settings;
  private List<String> users = new ArrayList<String>();
  private List<ScoreEntry> scoreboard = new ArrayList<ScoreEntry>();
  
  public Room(int roomID, String roomName) {
    this.roomID = roomID; 
    this.roomName = roomName;
    this.settings = new Settings();
  }
  
  // Add a new user to the room if the room does not contain that user,
  // otherwise throw an exception.
  public void addUser(String userId) {
    if (!users.contains(userId)){
      users.add(userId);
    } else {
      throw new IllegalArgumentException();
    }
  }
  
  // Remove the user from the room, if user does not exist throw an exception
  public void removeUser(String userId) {
    if (users.contains(userId)) {
      users.remove(userId);
    } else {
      throw new IllegalArgumentException();
    }
  }
  
  // Return true iff the user UserId is in the room
  public boolean hasUser(String userId) {
	  return users.contains(userId);
  }
  
  // Add a new score entry, if it already exists throw an exception
  public void addScoreEntry(Calendar date, String user, int score) {
    ScoreEntry entry = new ScoreEntry(date, user, score);
    if (scoreboard.contains(entry)) {
      throw new IllegalArgumentException();
    } else {
      scoreboard.add(entry);
    }
  }

  // Removes a score entry if it exists, otherwise throw an exception
  public void removeScoreEntry(Calendar date, String user, int score) {
    ScoreEntry entry = new ScoreEntry(date, user, score);
    if (!(scoreboard.contains(entry))) {
      throw new IllegalArgumentException();
    } else {
      scoreboard.remove(entry);
    }
  }
  
  public void addUnproductiveSite(String site) throws IllegalArgumentException {
    settings.addUnproductiveSites(site);
  }
  
  public void removeUnproductiveSite(String site) throws IllegalArgumentException {
    settings.removeUnproductiveSites(site);
  }
  
  public int getRoomID() {
    return roomID;
  }

  public List<String> getUsers() {
    return users;
  }

  public List<ScoreEntry> getScoreboard() {
    return scoreboard;
  }

  public Settings getSettings() {
    return settings;
  }

  public String getRoomName() {
    return roomName;
  }

}
