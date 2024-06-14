package src.booking;

import java.time.LocalDateTime;

import src.flight.Flight;

public class FlightBooking extends Booking {
  private Flight flight;

  FlightBooking(int id, Flight flight, LocalDateTime fromDate, LocalDateTime toDate) {
    super(id, fromDate, toDate);
    this.flight = flight;
  }

  @Override
  public void print() {
    System.out.print("ID: " + this.id);
    System.out.print(" From date: " + this.getFromDateString());
    System.out.println(" To date: " + this.getToDateString());
    System.out.print("  - ");
    this.flight.print();
  }

  @Override
  /**
   * TODO Add the ability to search for the booking date!
   */
  public String getSearchString() {
    return this.flight.getSearchString();
  }
}
