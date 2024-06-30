package src.booking;

import java.time.LocalDateTime;
import src.util.DateTimeUtils;

public class Booking {
  private LocalDateTime fromDate; // Variable to store the start date and time of the booking
  private LocalDateTime toDate; // Variable to store the end date and time of the booking
  final int id; // Unique identifier for the booking

  Booking(int id, LocalDateTime fromDate, LocalDateTime toDate) {
    this.fromDate = fromDate;
    this.toDate = toDate;
    this.id = id;
  }

  /** SETTER */

  /** Setter method to set the start date and time */
  public void setFromDate(LocalDateTime fromDate) {
    this.fromDate = fromDate;
  }

  /** Setter method to set the end date and time */
  public void setToDate(LocalDateTime toDate) {
    this.toDate = toDate;
  }

  /** GETTER */

  /** Get the formatted start date as a string */
  public String getFromDateString() {
    return DateTimeUtils.formatDateTime(this.fromDate);
  }

  /** Get the formatted end date as a string */
  public String getToDateString() {
    return DateTimeUtils.formatDateTime(this.toDate);
  }

  /** Getter method to retrieve the start date and time */
  public LocalDateTime getFromDate() {
    return fromDate;
  }

  /** Getter method to retrieve the end date and time */
  public LocalDateTime getToDate() {
    return toDate;
  }

  /**
   * Method to get the search string for the booking.
   * (currently returns an empty string)
   * This function is to be defined in subclasses.
   */
  public String getSearchString() {
    return "";
  }

  /** DISPLAY */

  /** Method to print basic booking information */
  public void print() {
    System.out.println("Basic Booking");
  }
}
