package storage;

import java.util.ArrayList;
import java.util.List;

public class Settings {
  
  private List<String> UnproductiveSites = new ArrayList<String>();
  
  public void addUnproductiveSites(String site) {
    if (!(UnproductiveSites.contains(site))) {
      UnproductiveSites.add(site);
    } else {
      throw new IllegalArgumentException();
    }
  }
  
  public void removeUnproductiveSites(String site) {
    if (UnproductiveSites.contains(site)) {
      UnproductiveSites.add(site);
    } else {
      throw new IllegalArgumentException();
    }
  }

  public List<String> getUnproductiveSites() {
    return UnproductiveSites;
  }
  
}
