package src.booking;

import src.flight.Flight;

// import java.time.LocalDateTime;

public class FlightBooking extends Booking {
  private Flight flight;

  FlightBooking(/*LocalDateTime fromDate, LocalDateTime toDate,*/ Flight flight) {
    // super(fromDate, toDate);
    this.flight = flight;
  }

  @Override
  public void print() {
    System.out.println("Booking:");
    System.out.println(this.getFromDate());
    System.out.println(this.getToDate());
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
