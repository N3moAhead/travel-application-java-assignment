package src.hotel;

public class Hotel {
  private int id;
  private String name;
  private String country;
  private int stars;

  public Hotel(int id, String name, int stars, String country) {
    this.name = name;
    this.id = id;
    this.stars = stars;
    this.country = country;
  }

  public void print() {
    System.out.println("ID: " + this.id + " name: " + this.name + " stars: " + this.stars + " country: " + this.country);
  }

  public String getSearchString() {
    return this.name + String.valueOf(this.id) + String.valueOf(this.stars) + this.country;
  }
}
