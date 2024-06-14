package src.booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.flight.Flight;
import src.flight.FlightService;
import src.hotel.Hotel;
import src.hotel.HotelService;
import src.util.Display;
import src.util.Form;

public class BookingService {
  private HashMap<String, Booking> bookings = new HashMap<>();
  private int id = 0;
  private FlightService flightService;
  private HotelService hotelService;
  private Display display = new Display();
  private Form form = new Form();

  public BookingService(FlightService flightService, HotelService hotelService) {
    this.flightService = flightService;
    this.hotelService = hotelService;
  }

  /** SETTER FUNCTIONS */

  public void createBooking(Flight flight) {
    this.id += 1;
    FlightBooking flightBooking = new FlightBooking(this.id, flight);
    this.bookings.put(String.valueOf(id), flightBooking);
  }

  public void createBooking(Hotel hotel) {
    this.id += 1;
    HotelBooking hotelBooking = new HotelBooking(this.id, hotel);
    this.bookings.put(String.valueOf(id), hotelBooking);
  }

  public void removeBooking(int id) {
    String key = String.valueOf(id);
    if (this.bookings.containsKey(key)) {
      this.bookings.remove(key);
      System.out.println("Booking with ID: " + key + " has been removed");
    } else {
      System.out.println("There is no Booking with the ID: " + key);
    }
  }

  /** GETTER FUNCTIONS */

  public Booking getBooking(int id) {
    String key = String.valueOf(id);
    if (bookings.containsKey(key)) {
      return this.bookings.get(key);
    }
    System.out.println("There is no flight with the ID: " + key);
    return null;
  }

  public List<Booking> getFilteredBookings(String searchString) {
    List<Booking> filteredBookings = new ArrayList<>();
    for (Map.Entry<String, Booking> bookingEntry : this.bookings.entrySet()) {
      Booking currentBooking = bookingEntry.getValue();
      if (currentBooking.getSearchString().contains(searchString)) {
        filteredBookings.add(currentBooking);
      }
    }
    return filteredBookings;
  }

  /** USER MASKS */

  public int bookingIdSelection() {
    int selectedId = -1;
    while (selectedId == -1) {
      int bookingId = this.form.getInt("Type in the ID of the booking you would like to select");
      if (this.bookings.containsKey(String.valueOf(bookingId))) {
        selectedId = bookingId;
      }
    }
    return selectedId;
  }

  public void bookingSearch() {
    display.printSubHeading("Booking-Search");
    int option = this.form.getRadioOption(
        "Would you like to search after a specific Booking?",
        new ArrayList<>(Arrays.asList("Yes", "No"))
    );
    if (option == 1) {
      String searchString = this.form.getString("Search");
      List<Booking> searchedBookings = this.getFilteredBookings(searchString);
      if (searchedBookings.isEmpty()) {
        System.out.println("No Booking could be found :/ here are all bookings unfiltered instead.");
        this.printBookings();
      } else {
        this.printBookings(searchedBookings);
      }
    } else {
      this.printBookings();
    }
  }

  public void bookingCreator() {
    this.display.printHeading("Booking Creation");
    int option = this.form.getRadioOption(
      "Do you want to book a flight or a hotel?",
      new ArrayList<>(Arrays.asList("Flight", "Hotel"))
    );
    if (option == 1) {
      this.flightService.flightSearch();
      Flight bookFlight = this.flightService.flightSelection();
      this.createBooking(bookFlight);
    } else {
      this.hotelService.hotelSearch();
      Hotel bookHotel = this.hotelService.hotelSelection();
      this.createBooking(bookHotel);
    }
  }

  public void bookingRemover() {
    if (this.bookings.isEmpty()) {
      System.out.println("Create a Booking first to use this function:)");
      return;
    }
    this.display.printHeading("Booking Removal");
    int option = this.form.getRadioOption(
      "Do you want to filter the bookings?",
      new ArrayList<>(Arrays.asList("Yes", "No"))
    );
    if (option == 1) {
      this.bookingSearch();
    } else {
      this.printBookings();
    }
    int bookingId = this.bookingIdSelection();
    this.removeBooking(bookingId);
  }

  /** DISPLAY FUNCTIONS */

  public void printBookings() {
    System.out.println("\nBookings:");
    for (Map.Entry<String, Booking> bookingEntry : this.bookings.entrySet()) {
      System.out.print("- ");
      bookingEntry.getValue().print();
    }
  }

  public void printBookings(List<Booking> bookings) {
    System.out.println("\nBookings:");
    for (Booking booking : bookings) {
      System.out.print("- ");
      booking.print();
    }
  }
}
