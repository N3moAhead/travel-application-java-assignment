package src.booking;

import java.time.LocalDateTime;

import src.flight.Flight;
import src.util.DateTimeUtils;

public class FlightBooking extends Booking {
  private Flight flight;

  /**
   * Constructs a FlightBooking instance.
   *
   * @param id The ID of the booking
   * @param flight The flight associated with the booking
   * @param fromDate The start date of the booking
   * @param toDate The end date of the booking
   */
  FlightBooking(int id, Flight flight, LocalDateTime fromDate, LocalDateTime toDate) {
    super(id, fromDate, toDate);
    this.flight = flight;
  }

  /**
   * Prints the flight booking details.
   * Overrides the print method in Booking class.
   */
  @Override
  public void print() {
    System.out.print("ID: " + this.id);
    System.out.print(" From date: " + this.getFromDateString());
    System.out.println(" To date: " + this.getToDateString());
    System.out.print("  - ");
    this.flight.print();
  }

  /**
   * Returns a search string containing flight and booking date information.
   * Overrides the getSearchString method in Booking class.
   *
   * @return A search string for the flight booking
   */
  @Override
  public String getSearchString() {
    return this.flight.getSearchString()
        + DateTimeUtils.formatDateTime(this.getFromDate())
        + DateTimeUtils.formatDateTime(this.getToDate());
  }
}
