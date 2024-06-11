package src;

// import java.time.LocalDateTime;

public class Flight {
  private int id;
  private String flightNumber;
  // private String fromAirport;
  // private String toAirport;
  // private LocalDateTime departure;
  // private LocalDateTime arrival;
  // private int delay;

  Flight(
      int id,
      String flightNumber
      // String fromAirport,
      // String toAirport,
      // LocalDateTime departure,
      // LocalDateTime arrival
  ) {
    this.id = id;
    this.flightNumber = flightNumber;
    // this.fromAirport = fromAirport;
    // this.toAirport = toAirport;
    // this.departure = departure;
    // this.arrival = arrival;
    // this.delay = 0;
  }

  void print() {
    System.out.println("ID: " + this.id + " Flight:\t" + this.flightNumber);
    // System.out.println("From: " + this.fromAirport + " To: " + this.toAirport);
    // System.out.println(this.departure);
    // System.out.println(this.arrival);
    // System.out.println(this.delay);
  }

  String getSearchString() {
    return this.flightNumber + String.valueOf(this.id);
  }
}
