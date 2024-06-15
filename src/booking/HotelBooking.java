package src.booking;

import java.time.LocalDateTime;

import src.hotel.Hotel;
import src.util.DateTimeUtils;


public class HotelBooking extends Booking {
  private Hotel hotel;

  HotelBooking(int id, Hotel hotel, LocalDateTime fromDate, LocalDateTime toDate) {
    super(id, fromDate, toDate);
    this.hotel = hotel;
  }

  @Override
  public void print() {
    System.out.print("ID: " + this.id);
    System.out.print(" From date: " + this.getFromDateString());
    System.out.println(" To date: " + this.getToDateString());
    System.out.print("  - ");
    this.hotel.print();
  }

  @Override
  public String getSearchString() {
    return this.hotel.getSearchString() + DateTimeUtils.formatDateTime(this.getFromDate()) + DateTimeUtils.formatDateTime(this.getToDate());
  }
}
