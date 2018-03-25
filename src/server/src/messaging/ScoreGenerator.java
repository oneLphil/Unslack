package messaging;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;

import storage.Room;
import storage.ScoreEntry;

public class ScoreGenerator {
    private Calendar today = Calendar.getInstance();
    
    /*
     * Update the room with new entries provided a user's browsing history
     */
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
    
    /*
     * Get last day scores provided a scoreboard, users,
     * and how many days for scope
     */
    public JSONArray getScore(List<ScoreEntry> scoreboard, List<String> users, int days){
      Map<String, Integer> scoreMap = new HashMap<String, Integer>();
      Calendar pastDay = Calendar.getInstance();
      pastDay.add(Calendar.DAY_OF_MONTH, days);
      
      for (ScoreEntry entry : scoreboard) {
        // check if entry is after yesterday
        if (entry.getDate().after(pastDay)){
          // if user already in the map increment score
          if (scoreMap.containsKey(entry.getUserId())){
            int score = scoreMap.get(entry.getUserId());
            score += entry.getScore();
            scoreMap.put(entry.getUserId(), score);
          }
          // else put new score in map
          else {
            scoreMap.put(entry.getUserId(), entry.getScore());
          }
        }
      }
      
      // check if the map is empty, if it is add 0 scores for everyone
      if (scoreMap.isEmpty()){
        for (String user : users){
          scoreMap.put(user, 0);
        }
      }
      
      return sortMapToJSON(scoreMap);
    }
    
    
    
    /*
     * Given a map of user:score, return a json array sorted from highest
     * score to lowest
     */
    private JSONArray sortMapToJSON(Map<String, Integer> scoreMap){
      // Sort the list by value
      List<Entry<String, Integer>> ScoresList = new ArrayList<>(scoreMap.entrySet());
      ScoresList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
      
      JSONArray jsonScores = new JSONArray();
      
      
      // make a json array for every entry and append into jsonArray
      for (Entry entry: ScoresList){
        JSONArray currEntry = new JSONArray();
        currEntry.add(entry.getKey());
        currEntry.add(entry.getValue());
        jsonScores.add(currEntry);
      }
      return jsonScores;
    }
    
    /*
     *  Calculate a score scoring to history and unproductive sites
     */
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
    
    /*
     * Finds an entry in the room that has today's date, and same user name
     * Returns null if entry is not found 
     */
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
