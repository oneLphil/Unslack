package storage;

/*
 * The representation of a user in the system
 * 
 */
public class User {

  private int userID;
  
  public User(int userID) {
    this.userID = userID;
  }
  
  public int getID() {
    return userID;
  }
  
  @Override
  public boolean equals(Object other){
    return other instanceof User && this.userID == ((User)other).getID();
  }
  
  @Override
  public String toString(){
    return "UserID: " + userID;
  }
}
