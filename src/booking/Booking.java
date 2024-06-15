package src.booking;

import java.time.LocalDateTime;

import src.util.DateTimeUtils;

public class Booking {
  private LocalDateTime fromDate;
  private LocalDateTime toDate;
  final int id;

  Booking(int id, LocalDateTime fromDate, LocalDateTime toDate) {
    this.fromDate = fromDate;
    this.toDate = toDate;
    this.id = id;
  }

  public String getFromDateString() {
    return DateTimeUtils.formatDateTime(this.fromDate);
  }

  public String getToDateString() {
    return DateTimeUtils.formatDateTime(this.toDate);
  }

  public LocalDateTime getFromDate() {
    return fromDate;
  }

  public LocalDateTime getToDate() {
    return toDate;
  }

  public void setFromDate(LocalDateTime fromDate) {
    this.fromDate = fromDate;
  }

  public void setToDate(LocalDateTime toDate) {
    this.toDate = toDate;
  }

  public void print() {
    System.out.println("Basic Booking");
  }

  public String getSearchString() {
    return "";
  }
}
