package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.GregorianCalendar;

public class tester {

  public static void main(String[] args) throws IOException {
    Room room = new Room(1);
    room.addUnproductiveSite("www.youtube.com");
    room.addUnproductiveSite("www.reddit.com");
    room.addUser(0001);
    room.addUser(0002);
    room.addScoreEntry(new GregorianCalendar(2018, 3, 1), 0001, 100);
    room.addScoreEntry(new GregorianCalendar(2018, 3, 1), 0002, 80);
    
    RoomSerializerDeserializer serializer = new RoomSerializerDeserializer();
    File file = new File("file.txt");
    FileOutputStream s = new FileOutputStream(file);
    serializer.serialize(room, s);
    s.close();
    
    File file2 = new File("file.txt");
    Room room2 = serializer.deserialize(new FileInputStream(file2), 1);
    System.out.println("Room Id: " + room2.getRoomID() + "\n");
    System.out.println("Users: " + room2.getUsers() + "\n");
    System.out.println("Settings: " + room2.getSettings().getUnproductiveSites() + "\n");
    System.out.println("Entries " + room2.getScoreboard() + "\n");
  }

}
