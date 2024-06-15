package src.booking;

import java.time.LocalDateTime;

import src.flight.Flight;
import src.util.DateTimeUtils;

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
  public String getSearchString() {
    return this.flight.getSearchString()
        + DateTimeUtils.formatDateTime(this.getFromDate())
        + DateTimeUtils.formatDateTime(this.getToDate());
  }
}
