package src;

// import java.time.LocalDateTime;

public class HotelReservation extends Reservation {
  private Hotel hotel;

  HotelReservation(/*LocalDateTime fromDate, LocalDateTime toDate,*/ Hotel hotel) {
    // super(fromDate, toDate);
    this.hotel = hotel;
  }

  public void print() {
    System.out.println("Reservation:");
    System.out.println(this.getFromDate());
    System.out.println(this.getToDate());
    hotel.print();
  }
}
