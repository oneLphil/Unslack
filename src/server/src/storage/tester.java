package storage;

import java.io.File;
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
    
    serializer.serialize(room, new FileOutputStream(file));
  }

}
