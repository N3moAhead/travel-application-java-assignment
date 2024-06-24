package src.hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.util.CSVReader;
import src.util.Display;
import src.util.Form;

/**
 * The Hotel management class
 */
public class HotelService {
  private HashMap<String, Hotel> hotels = new HashMap<>();
  private int id = 0;
  private Form form = new Form();

  public HotelService() {
    // Load stored hotels from a csv file
    List<String[]> records = CSVReader.getRecordsFromFile("./data/hotels.csv");
    // Create hotel objects from the records of the csv file
    for (String[] item : records) {
      this.createHotel(item[0], Integer.valueOf(item[1]) , item[2]);
    }
  }

  /** SETTER FUNCTIONS */

  /**
   * Create a new hotel and add it to the stored hotels
   * @param hotelName the name of the hotel
   * @param stars the amount of stars that the hotel inherits
   * @param country the country the hotel is located at
   */
  public void createHotel(String hotelName, int stars, String country) {
    this.id += 1;
    Hotel newHotel = new Hotel(this.id, hotelName, stars, country);
    hotels.put(String.valueOf(id), newHotel);
  }

  /** GETTER FUNCTIONS */

  /**
   * Get a list of Hotel that will be
   * filtered by the given search string.
   * @param searchString The string used for the search
   * @return A List of Hotel objects that inherit a property that matches the search string
   */
  public List<Hotel> getFilteredHotels(String searchString) {
    ArrayList<Hotel> filteredHotels = new ArrayList<>();
    // Iterate over each hotel entry in the hashmap
    for (Map.Entry<String, Hotel> hotelEntry : this.hotels.entrySet()) {
      Hotel currentHotel = hotelEntry.getValue();
      // Check if the current Hotel object inherits the searchString as a property
      if (currentHotel.getSearchString().contains(searchString)) {
        filteredHotels.add(currentHotel);
      }
    }
    return filteredHotels;
  }

  /**
   * Get a single Hotel Object by ID
   * @param id the ID of the desired Object
   * @return The Hotel Object with the given ID
   */
  public Hotel getHotel(int id) {
    String key = String.valueOf(id);
    if (hotels.containsKey(key)) {
      return this.hotels.get(key);
    }
    System.out.println("There is no hotel with the ID: " + key);
    return null;
  }

  /** USER MASKS */

  /**
   * Allows the user to enter an ID of a Hotel that shall
   * be selected.The function returns a Hotel Object after the
   * user as entered a valid ID.
   * @return a Hotel Object
   */
  public Hotel hotelSelection() {
    Hotel hotel = null;
    while (hotel == null) {
      int hotelId = this.form.getInt("Type in the ID of the hotel you would like to select");
      hotel = this.getHotel(hotelId);
    }
    return hotel;
  }

  /**
   * Allows a user to search through the stored hotels.
   */
  public void hotelSearch() {
    Display.printSubHeading("Hotel-Search");
    int option = this.form.getRadioOption(
      "Would you like to search after a specific Hotel?",
      new ArrayList<>(Arrays.asList("Yes", "No"))
    );
    // Check if the user wants to enter a search string
    if (option == 1) {
      // get the search string from the user
      String searchString = this.form.getString("Hotel-Search");
      // get a list of hotels that inherit the entered search string
      List<Hotel> searchedHotels = this.getFilteredHotels(searchString);
      if (searchedHotels.isEmpty()) {
        System.out.println("No Hotel could be found :/ here are all hotels unfiltered instead.");
        this.printHotels();
      } else {
        this.printHotels(searchedHotels);
      }
    } else {
      this.printHotels();
    }
  }

  /**
   * Allows the user to create a new Hotel entry
   */
  public void hotelCreator() {
    Display.printHeading("Hotel Creation");
    System.out.println("Complete this form:");
    String hotelName = this.form.getString("Hotelname");
    int stars = this.form.getInt("Stars of the hotel");
    String country = this.form.getString("Location");
    this.createHotel(hotelName, stars, country);
  }

  /** DISPLAY FUNCTIONS */

  /**
   * Prints all stored hotels to the terminal
   */
  void printHotels() {
    System.out.println("\nHotels:");
    for (Map.Entry<String, Hotel> hotelEntry : this.hotels.entrySet()) {
      System.out.print("- ");
      hotelEntry.getValue().print();
    }
  }

  /**
   * Prints a list of given hotels to the terminal
   * @param hotels
   */
  void printHotels(List<Hotel> hotels) {
    System.out.println("\nHotels:");
    for (Hotel hotel : hotels) {
      System.out.print("- ");
      hotel.print();
    }
  }
}
