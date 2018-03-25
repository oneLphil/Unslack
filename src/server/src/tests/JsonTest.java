package tests;

import org.json.simple.JSONArray;

public class JsonTest {

  public static void main(String[] args) {

    JSONArray arr = new JSONArray();
    JSONArray arr2 = new JSONArray();
    JSONArray arr3 = new JSONArray();
    arr2.add(1);
    arr3.add(2);
    arr.add(arr2);
    arr.add(arr3);
    System.out.println(arr);
        
  }
}
