package src.booking;

import java.time.LocalDateTime;

import src.hotel.Hotel;
import src.util.DateTimeUtils;

public class HotelBooking extends Booking {
  private Hotel hotel;

  /**
   * Constructs a HotelBooking instance.
   *
   * @param id The ID of the booking
   * @param hotel The hotel associated with the booking
   * @param fromDate The start date of the booking
   * @param toDate The end date of the booking
   */
  HotelBooking(int id, Hotel hotel, LocalDateTime fromDate, LocalDateTime toDate) {
    super(id, fromDate, toDate);
    this.hotel = hotel;
  }

  /**
   * Prints the hotel booking details.
   * Overrides the print method in Booking class.
   */
  @Override
  public void print() {
    System.out.print("ID: " + this.id);
    System.out.print(" From date: " + this.getFromDateString());
    System.out.println(" To date: " + this.getToDateString());
    System.out.print("  - ");
    this.hotel.print();
  }

  /**
   * Returns a search string containing hotel and booking date information.
   * Overrides the getSearchString method in Booking class.
   *
   * @return A search string for the hotel booking
   */
  @Override
  public String getSearchString() {
    return this.hotel.getSearchString()
      + DateTimeUtils.formatDateTime(this.getFromDate())
      + DateTimeUtils.formatDateTime(this.getToDate());
  }
}
