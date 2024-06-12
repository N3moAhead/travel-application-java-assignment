package src;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    HotelService hotelService = new HotelService();
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
    display.printHeading("Main Menu");
    Form form = new Form();
    int option = form.getRadioOption("Wähle eine neue Menü Variante",
        new ArrayList<>(Arrays.asList("Book Flights", "Book Hotel", "View Bookings", "Lachen")));
    System.out.println(option);
  }
}
