package src.flight;

public class Flight {
  private int id;
  private String flightNumber;

  public Flight(
      int id,
      String flightNumber
  ) {
    this.id = id;
    this.flightNumber = flightNumber;
  }

  public void print() {
    System.out.println("ID: " + this.id + " Flight: " + this.flightNumber);
  }

  public String getSearchString() {
    return this.flightNumber + String.valueOf(this.id);
  }
}
