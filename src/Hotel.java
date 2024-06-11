package src;

public class Hotel {
  private String name;
  private int id;

  Hotel(int id, String name) {
    this.name = name;
    this.id = id;
  }

  void print() {
    System.out.println("ID: " + this.id + " HotelName: " + this.name);
  }

  String getSearchString() {
    return this.name + String.valueOf(this.id);
  }
}
