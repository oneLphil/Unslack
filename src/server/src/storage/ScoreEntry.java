package storage;

import java.util.GregorianCalendar;

public class ScoreEntry {
  private GregorianCalendar date;
  private int userId;
  private int score;
  
  public ScoreEntry(GregorianCalendar date, int userId, int score){
    this.date = date;
    this.userId = userId;
    this.score = score;
  }

  public GregorianCalendar getDate() {
    return date;
  }

  public int getUserId() {
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
