package src.booking;

import src.hotel.Hotel;

// import java.time.LocalDateTime;

public class HotelBooking extends Booking {
  private Hotel hotel;

  HotelBooking(/*LocalDateTime fromDate, LocalDateTime toDate,*/ Hotel hotel) {
    // super(fromDate, toDate);
    this.hotel = hotel;
  }

  @Override
  public void print() {
    System.out.println("Booking:");
    System.out.println(this.getFromDate());
    System.out.println(this.getToDate());
    hotel.print();
  }

  @Override
  /**
   * TODO Add the ability to search for the booking date
   */
  public String getSearchString() {
    return this.hotel.getSearchString();
  }
}
