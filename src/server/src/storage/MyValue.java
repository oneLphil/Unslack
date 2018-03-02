package storage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyValue {
  public String name;
  public int age;
  
  public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    User user1 = new User(1);
    User user2 = new User(2);
    User user3 = new User(3);
    Room room = new Room(5000);
    room.addUser(user1);
    room.addUser(user2);
    room.addUser(user3);
    room.addScoreEntry(new GregorianCalendar(2018, 3, 2), user1, 10);
    room.addScoreEntry(new GregorianCalendar(2018, 3, 2), user2, 20);
    room.addScoreEntry(new GregorianCalendar(2018, 3, 2), user3, 30);
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    mapper.setDateFormat(df);
    
    mapper.writeValue(System.out, room);
    

  }

}
