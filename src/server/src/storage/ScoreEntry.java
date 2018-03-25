package storage;

import java.util.Calendar;


public class ScoreEntry {
  private Calendar date;
  private String userId;
  private int score;
  
  public ScoreEntry(Calendar date, String user, int score){
    this.date = date;
    this.userId = user;
    this.score = score;
  }

  public Calendar getDate() {
    return date;
  }

  public String getUserId() {
    return userId;
  }

  public int getScore() {
    return score;
  }
  
  public void setScore(int score) {
    this.score = score;
  }
  
  @Override
  public boolean equals(Object other) {
    return other instanceof ScoreEntry && 
      this.date.get(Calendar.YEAR) == ((ScoreEntry) other).date.get(Calendar.YEAR) &&
      this.date.get(Calendar.MONTH) == ((ScoreEntry) other).date.get(Calendar.MONTH) &&
      this.date.get(Calendar.DAY_OF_MONTH) == ((ScoreEntry) other).date.get(Calendar.DAY_OF_MONTH) &&
      this.userId == ((ScoreEntry) other).userId &&
      this.score == ((ScoreEntry) other).score;
  }
  
  public String toString() {
    return "Date: " + date.get(1) + "-" + date.get(2) + "-" + date.get(3)
            + " User Id: " + userId + " Score: " + score;
  }
}
