package src;

import java.time.LocalDateTime;

public class Booking {
  private LocalDateTime fromDate;
  private LocalDateTime toDate;

  Booking(/*LocalDateTime fromDate, LocalDateTime toDate*/) {
    this.fromDate = LocalDateTime.now();
    this.toDate = LocalDateTime.now().plusMonths(1);
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
}
