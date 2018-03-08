package storage;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/*
 * The representation of a room containing users
 * 
 */
public class Room {
  private int roomID;
  private Settings settings;
  private List<Integer> users = new ArrayList<Integer>();
  private List<ScoreEntry> scoreboard = new ArrayList<ScoreEntry>();
  
  public Room(int roomID) {
    this.roomID = roomID;
    this.settings = new Settings();
  }
  
  // Add a new user to the room if the room does not contain that user
  public void addUser(int userId) {
    if (!users.contains(userId)){
      users.add(userId);
    }
  }
  
  // Remove the user from the room
  public void removeUser(int userId) {
    if (users.contains(userId)) {
      users.remove(userId);
    }
  }
  // Add a new score entry
  public void addScoreEntry(GregorianCalendar date, int user, int score) {
    ScoreEntry entry = new ScoreEntry(date, user, score);
    if (scoreboard.contains(entry)) {
      throw new IllegalArgumentException();
    } else {
      scoreboard.add(entry);
    }
  }

  public void removeScoreEntry(GregorianCalendar date, int user, int score) {
    ScoreEntry entry = new ScoreEntry(date, user, score);
    if (!(scoreboard.contains(entry))) {
      throw new IllegalArgumentException();
    } else {
      scoreboard.remove(entry);
    }
  }
  
  public void addUnproductiveSite(String site) {
    settings.addUnproductiveSites(site);
  }
  
  public void removeUnproductiveSite(String site) {
    settings.removeUnproductiveSites(site);
  }
  
  public int getRoomID() {
    return roomID;
  }

  public List<Integer> getUsers() {
    return users;
  }

  public List<ScoreEntry> getScoreboard() {
    return scoreboard;
  }

  public Settings getSettings() {
    return settings;
  }

}
