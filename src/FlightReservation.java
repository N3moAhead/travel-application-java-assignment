package src;

// import java.time.LocalDateTime;

public class FlightReservation extends Reservation {
  private Flight flight;

  FlightReservation(/*LocalDateTime fromDate, LocalDateTime toDate,*/ Flight flight) {
    // super(fromDate, toDate);
    this.flight = flight;
  }

  public void print() {
    System.out.println("Reservation:");
    System.out.println(this.getFromDate());
    System.out.println(this.getToDate());
    this.flight.print();
  }
}
