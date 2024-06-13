package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingService {
  private HashMap<String, Booking> bookings = new HashMap<>();
  private int id = 0;
  private FlightService flightService;
  private HotelService hotelService;

  BookingService(FlightService flightService, HotelService hotelService) {
    this.flightService = flightService;
    this.hotelService = hotelService;
  }

  /** CREATION FUNCTIONS */

  public void createBooking(Flight flight) {
    this.id += 1;
    FlightBooking flightBooking = new FlightBooking(flight);
    this.bookings.put(String.valueOf(id), flightBooking);
  }

  public void createBooking(Hotel hotel) {
    this.id += 1;
    HotelBooking hotelBooking = new HotelBooking(hotel);
    this.bookings.put(String.valueOf(id), hotelBooking);
  }

  public void bookingCreator() {
    Form form = new Form();
    new Display().printHeading("Booking Creation");
    int option = form.getRadioOption(
      "Do you want to book a flight or a hotel?",
      new ArrayList<>(Arrays.asList("Flight", "Hotel"))
    );
    if (option == 1) {
      Flight bookFlight = this.flightService.flightSearch();
      this.createBooking(bookFlight);
    } else {
      Hotel bookHotel = this.hotelService.hotelSearch();
      this.createBooking(bookHotel);
    }
  }

  public void removeBooking(int id) {
    this.bookings.remove(String.valueOf(id));
  }

  /** DISPLAY FUNCTIONS */

  public void printBookings() {
    for (Map.Entry<String, Booking> bookingEntry : this.bookings.entrySet()) {
      bookingEntry.getValue().print();
    }
  }

  public void printBookings(List<Booking> bookings) {
    for (Booking booking : bookings) {
      booking.print();
    }
  }
}
