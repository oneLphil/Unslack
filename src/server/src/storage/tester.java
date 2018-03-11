package storage;

import java.io.IOException;
import java.util.GregorianCalendar;

public class tester {

  public static void main(String[] args) throws IOException {
//    Room room = new Room(1);
//    room.addUnproductiveSite("www.youtube.com");
//    room.addUnproductiveSite("www.reddit.com");
//    room.addUser(0001);
//    room.addUser(0002);
//    room.addScoreEntry(new GregorianCalendar(2018, 3, 1), 0001, 100);
//    room.addScoreEntry(new GregorianCalendar(2018, 3, 1), 0002, 80);
//    
//    RoomSerializerDeserializer serializer = new RoomSerializerDeserializer();
//    File file = new File("file.txt");
//    FileOutputStream s = new FileOutputStream(file);
//    serializer.serialize(room, s);
//    s.close();
//    
//    File file2 = new File("file.txt");
//    Room room2 = serializer.deserialize(new FileInputStream(file2), 1);
//    System.out.println("Room Id: " + room2.getRoomID() + "\n");
//    System.out.println("Users: " + room2.getUsers() + "\n");
//    System.out.println("Settings: " + room2.getSettings().getUnproductiveSites() + "\n");
//    System.out.println("Entries " + room2.getScoreboard() + "\n");
    
//    StorageManager s = new StorageManager();
//    s.createRoom("Philip");
//    Room room = s.getRoom(1);
//    System.out.println(room.getRoomID());
//    System.out.println(room.getUsers());
//    room.addUnproductiveSite("www.youtube.com");
    String name = "philip";
    int hc = name.hashCode();
    System.out.println(hc);
    StorageManager s = new StorageManager();
    int roomId = s.createRoom(name);
    System.out.println("room id: " + roomId);
    Room room = s.getRoom(roomId);
    System.out.println("got room id: " + room.getRoomID());
    System.out.println("got room user: " + room.getUsers());
    System.out.println("got room sites " + room.getSettings().getUnproductiveSites());
    System.out.println("got room sites " + room.getScoreboard());
    room.addUnproductiveSite("youtube");
    System.out.println("got room sites " + room.getSettings().getUnproductiveSites());
    room.addScoreEntry(new GregorianCalendar(2018, 3, 1), name, 100);
    System.out.println("Sites size: " + room.getSettings().getUnproductiveSites().size());
    room.addUnproductiveSite("youtube.com");
    System.out.println("Sites size: " + room.getSettings().getUnproductiveSites().size());
    s.writeRoom(room);
    Room room2 = s.getRoom(roomId);
    System.out.println("got room2 id: " + room2.getRoomID());
    System.out.println("got room2 users: " + room2.getUsers());
    System.out.println("got room2 id: " + room2.getScoreboard());
    System.out.println("got room id: " + room2.getSettings().getUnproductiveSites());
    System.out.println("Sites size: " + room2.getSettings().getUnproductiveSites().size());
  }

}
