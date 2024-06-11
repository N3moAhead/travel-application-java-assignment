package src;

import java.time.LocalDateTime;

public class Reservation {
  private LocalDateTime fromDate;
  private LocalDateTime toDate;

  Reservation(LocalDateTime fromDate, LocalDateTime toDate) {
    this.fromDate = fromDate;
    this.toDate = toDate;
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
}
