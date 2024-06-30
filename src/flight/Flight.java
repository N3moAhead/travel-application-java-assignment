package src.flight;

import java.time.LocalDateTime;

import src.util.DateTimeUtils;

public class Flight {
  private int id;
  private String flightNumber;
  // The location from where the plain will start
  private String from;
  // The destination for the plain
  private String to;
  private LocalDateTime departure;
  private LocalDateTime arrival;

  public Flight(
      int id,
      String flightNumber,
      String from,
      String to,
      LocalDateTime departure,
      LocalDateTime arrival
  ) {
    this.id = id;
    this.flightNumber = flightNumber;
    this.from = from;
    this.to = to;
    this.departure = departure;
    this.arrival = arrival;
  }

  public LocalDateTime getArrival() {
    return arrival;
  }

  public LocalDateTime getDeparture() {
    return departure;
  }

  /**
   * Print all of the current properties to the terminal.
   * All properties will be printed in a single line.
   */
  public void print() {
    System.out.println(
      "ID: " + this.id
      + " Flight: " + this.flightNumber
      + " From: " + this.from
      + " To: " + this.to
      + " Departure: " + DateTimeUtils.formatDateTime(this.departure)
      + " Arrival: " + DateTimeUtils.formatDateTime(this.arrival)
    );
  }

  /**
   * Create a string that holds all current properties of the flight.
   * @return The created search string.
   */
  public String getSearchString() {
    return (
      this.flightNumber
      + String.valueOf(this.id)
      + this.from
      + this.to
      + DateTimeUtils.formatDateTime(this.departure)
      + DateTimeUtils.formatDateTime(this.arrival)
    );
  }
}
