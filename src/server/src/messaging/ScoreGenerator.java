package messaging;

import java.util.Calendar;
import java.util.List;

import org.json.simple.JSONArray;

import storage.Room;
import storage.ScoreEntry;

public class ScoreGenerator {
    private Calendar today = Calendar.getInstance();
    
    public void addScoreEntry(Room room, JSONArray history, String userName){
      List<String> users = room.getUsers();
      List<ScoreEntry> scoreboard = room.getScoreboard();
      int score = calculateScore(history, room.getSettings().getUnproductiveSites());
      
      ScoreEntry oldEntry = findEntry(scoreboard, userName);
      // if new entry is not in scoreboard, then there was no entries today.
      // add new entry for this user and add entry for all other users with score 0
      if (oldEntry == null) {
        scoreboard.add(new ScoreEntry(today, userName, score));
        for(String user : users) {
          if (!user.equals(userName)){
            scoreboard.add(new ScoreEntry(today, user, 0));
          }
        }
      }
      // update the old entry score
      else {
        int oldScore = oldEntry.getScore();
        score += oldScore;
        oldEntry.setScore(score);
      }
    }
    
    // Calculate a score scoring to history and unproductive sites
    private int calculateScore(JSONArray history, List<String> badSites) {
      int score = 0;
      
      for(int i = 0; i < history.size(); i++) {
        // if website entry is in bad sites, -1 score for each unit of time
        if (badSites.contains(((JSONArray)history.get(i)).get(0))){
          score -= (int)((JSONArray)history.get(i)).get(1);
        }
        // if website entry is not in bad sites, +1 score for each unit of time
        else {
          score += (int)((JSONArray)history.get(i)).get(1);
        }
      }
      return score;
    }
    
    private ScoreEntry findEntry(List<ScoreEntry> scoreboard, String userName) {
      
      for(ScoreEntry entry : scoreboard) {
        if (entry.getUserId().equals(userName) &&
            entry.getDate().get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
            entry.getDate().get(Calendar.MONTH) == today.get(Calendar.MONTH) &&
            entry.getDate().get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)
            ) {
          return entry;
        }
      }
      return null;
    }
}
