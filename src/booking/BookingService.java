package src.booking;

import java.time.LocalDateTime;
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
  // Stores all bookings with their IDs as keys
  private HashMap<String, Booking> bookings = new HashMap<>();
  private int id = 0; // ID counter for new bookings
  private FlightService flightService; // Service for handling flights
  private HotelService hotelService; // Service for handling hotels
  private Form form = new Form(); // Form utility for user input

  /**
   * Constructor initializes flight and hotel services.
   *
   * @param flightService Service for handling flights
   * @param hotelService Service for handling hotels
   */
  public BookingService(FlightService flightService, HotelService hotelService) {
    this.flightService = flightService;
    this.hotelService = hotelService;
  }

  /** SETTER FUNCTIONS */

  /**
   * Creates a booking for a flight and stores it in the bookings map.
   *
   * @param flight The flight to be booked
   */
  public void createBooking(Flight flight) {
    this.id += 1;
    FlightBooking flightBooking = new FlightBooking(this.id, flight, flight.getDeparture(), flight.getArrival());
    this.bookings.put(String.valueOf(id), flightBooking);
  }

  /**
   * Creates a booking for a hotel and stores it in the bookings map.
   *
   * @param hotel The hotel to be booked
   * @param fromDate The start date of the booking
   * @param toDate The end date of the booking
   */
  public void createBooking(Hotel hotel, LocalDateTime fromDate, LocalDateTime toDate) {
    this.id += 1;
    HotelBooking hotelBooking = new HotelBooking(this.id, hotel, fromDate, toDate);
    this.bookings.put(String.valueOf(id), hotelBooking);
  }

  /**
   * Removes a booking by its ID if it exists.
   *
   * @param id The ID of the booking to be removed
   */
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

  /**
   * Retrieves a booking by its ID if it exists.
   *
   * @param id The ID of the booking to be retrieved
   * @return The booking if found, otherwise null
   */
  public Booking getBooking(int id) {
    String key = String.valueOf(id);
    if (bookings.containsKey(key)) {
      return this.bookings.get(key);
    }
    System.out.println("There is no flight with the ID: " + key);
    return null;
  }

  /**
   * Returns a list of bookings that match a search string.
   *
   * @param searchString The string to search for in bookings
   * @return A list of bookings that match the search string
   */
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

  /**
   * A user mask that allows the user to select a
   * booking by ID and returns the selected ID.
   *
   * @return The selected booking ID
   */
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

  /**
   * A user mask that allows the user to search for bookings.
   */
  public void bookingSearch() {
    Display.printSubHeading("Booking-Search");
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

  /**
   * A user mask that allows a user the creation
   * of either a flight or hotel booking.
   */
  public void bookingCreator() {
    Display.printHeading("Booking Creation");
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
      System.out.println("\nComplete the form:");
      LocalDateTime fromDate = this.form.getDate("From");
      LocalDateTime toDate = this.form.getDate("To");
      this.createBooking(bookHotel, fromDate, toDate);
    }
  }

  /**
   * A user mask that alows a user the removal of
   * a booking by first optionally filtering bookings.
   */
  public void bookingRemover() {
    if (this.bookings.isEmpty()) {
      System.out.println("Create a Booking first to use this function:)");
      return;
    }
    Display.printHeading("Booking Removal");
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

  /**
   * Prints all bookings.
   */
  public void printBookings() {
    System.out.println("\nBookings:");
    for (Map.Entry<String, Booking> bookingEntry : this.bookings.entrySet()) {
      System.out.print("- ");
      bookingEntry.getValue().print();
    }
  }

  /**
   * Prints a list of specific bookings.
   *
   * @param bookings The list of bookings to be printed
   */
  public void printBookings(List<Booking> bookings) {
    System.out.println("\nBookings:");
    for (Booking booking : bookings) {
      System.out.print("- ");
      booking.print();
    }
  }
}
