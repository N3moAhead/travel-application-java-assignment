package src;

public class Main {
  public static void main(String[] args) {
    FlightService flightService = new FlightService();
    HotelService hotelService = new HotelService();
    BookingService bookingService = new BookingService(flightService, hotelService);
    hotelService.hotelCreator();
    hotelService.hotelCreator();
    flightService.flightCreator();
    flightService.flightCreator();
    bookingService.bookingCreator();
    bookingService.printBookings();
  }
}
