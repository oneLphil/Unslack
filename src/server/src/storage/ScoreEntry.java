package storage;

import java.util.GregorianCalendar;

public class ScoreEntry {
  private GregorianCalendar date;
  private String userId;
  private int score;
  
  public ScoreEntry(GregorianCalendar date, String user, int score){
    this.date = date;
    this.userId = user;
    this.score = score;
  }

  public GregorianCalendar getDate() {
    return date;
  }

  public String getUserId() {
    return userId;
  }

  public int getScore() {
    return score;
  }
  
  @Override
  public boolean equals(Object other) {
    return other instanceof ScoreEntry && 
      this.date == ((ScoreEntry) other).date &&
      this.userId == ((ScoreEntry) other).userId &&
      this.score == ((ScoreEntry) other).score;
  }
  
  public String toString() {
    return "Date: " + date.get(1) + "-" + date.get(2) + "-" + date.get(3)
            + " User Id: " + userId + " Score: " + score;
  }
}
