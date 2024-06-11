package src;

public class Main {
  public static void main(String[] args) {
    HotelService hotelService = new HotelService();
    hotelService.createHotel("Apart Mannheim");
    hotelService.createHotel("Maritim Mannheim");
    hotelService.createHotel("Hotel 22 Frankfurt");
    hotelService.printHotels();
    System.out.println("Filtered List: Mannheim");
    hotelService.printHotels(hotelService.getHotels("Mannheim"));

    FlightService flightService = new FlightService();
    flightService.createFlight("FRA223");
    flightService.createFlight("STR123");
    flightService.createFlight("PEN129");
    flightService.createFlight("TES213");
    flightService.printFlights();
    System.out.println("Filtered Flights: FRA");
    flightService.printFlights();

    BookingService bookingService = new BookingService();
    bookingService.createBooking(flightService.getFlight(1));
    bookingService.createBooking(flightService.getFlight(2));
    bookingService.createBooking(hotelService.getHotel(2));
    bookingService.printBookings();
  
    Display display = new Display();
    display.printHeading("Lachen Weinen Tanzen Welt");
    display.printHeading("Test");
    display.printHeading("Nein leider nicht");
    display.printHeading("Wissen eingrenzen");
  }
}
