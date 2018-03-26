package storage;

import java.util.ArrayList;
import java.util.List;

/*
 * settings for a room in the system
 */
public class Settings {
  
  private List<String> UnproductiveSites = new ArrayList<String>();
  
  public Settings(){
    // TODO some kind of default settings will be initiated

  }
  
  // Add the given site to the UnproductiveSites list, if it already exists throw 
  // an exception.
  public void addUnproductiveSites(String site) throws IllegalArgumentException {
    if (!(UnproductiveSites.contains(site))) {
      UnproductiveSites.add(site);
    } else {
      throw new IllegalArgumentException();
    }
  }
  
  // Remove the given site from the UnproductiveSites list, if list does not 
  // contain that site throw an exception.
  public void removeUnproductiveSites(String site) throws IllegalArgumentException {
    if (UnproductiveSites.contains(site)) {
      UnproductiveSites.remove(site);
    } else {
      throw new IllegalArgumentException();
    }
  }

  // Return a list of strings, each string is an unproductive site.
  public List<String> getUnproductiveSites() {
    return UnproductiveSites;
  }
  
}
