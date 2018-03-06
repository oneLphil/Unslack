package storage;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DailyScoreEntry {
  private Calendar date;
  private Map<User, Integer> scores = new HashMap<User, Integer>();
  
  public DailyScoreEntry(Calendar date2){
    this.date = date2;
  }
  
  public void addScoreEntry(User user, int score) {
    scores.put(user, score);
  }

  public Calendar getDate() {
    return date;
  }

  public Map<User, Integer> getScores() {
    return scores;
  }
  
  
}
