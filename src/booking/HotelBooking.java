package src.booking;

import src.hotel.Hotel;


public class HotelBooking extends Booking {
  private Hotel hotel;

  HotelBooking(int id, Hotel hotel) {
    super(id);
    this.hotel = hotel;
  }

  @Override
  public void print() {
    System.out.print("ID: " + this.id);
    System.out.print("From date: " + this.getFromDate());
    System.out.println("To date: " + this.getToDate());
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
