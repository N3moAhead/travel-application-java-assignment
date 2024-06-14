package src.booking;

import java.time.LocalDateTime;

import src.hotel.Hotel;


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
  /**
   * TODO Add the ability to search for the booking date
   */
  public String getSearchString() {
    return this.hotel.getSearchString();
  }
}
