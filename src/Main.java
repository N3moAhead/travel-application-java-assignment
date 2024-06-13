package src;

import java.util.ArrayList;
import java.util.Arrays;

import src.booking.BookingService;
import src.flight.FlightService;
import src.hotel.HotelService;
import src.util.Display;
import src.util.Form;

public class Main {
  public static void main(String[] args) {
    FlightService flightService = new FlightService();
    HotelService hotelService = new HotelService();
    BookingService bookingService = new BookingService(flightService, hotelService);
    Form form = new Form();
    Display display = new Display();

    hotelService.hotelCreator();
    hotelService.hotelCreator();
    flightService.flightCreator();
    flightService.flightCreator();

    boolean isRunning = true;
    while (isRunning) {
      display.printHeading("Main Menu");
      int option = form.getRadioOption(
          "Choose a option",
          new ArrayList<>(Arrays.asList("Search Flights", "Search Hotels", "Create Booking", "End Program"))
        );
      switch (option) {
        case 1:
          flightService.flightSearch();
          break;
        case 2:
          hotelService.hotelSearch();
          break;
        case 3:
          bookingService.bookingCreator();
          break;
        case 4:
          isRunning = false;
          break;
        default:
          System.out.println("This option has not been implemented yet :/");
          break;
      }
    }
  }
}
