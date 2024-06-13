package src.hotel;

public class Hotel {
  private String name;
  private int id;

  public Hotel(int id, String name) {
    this.name = name;
    this.id = id;
  }

  public void print() {
    System.out.println("ID: " + this.id + " HotelName: " + this.name);
  }

  public String getSearchString() {
    return this.name + String.valueOf(this.id);
  }
}
