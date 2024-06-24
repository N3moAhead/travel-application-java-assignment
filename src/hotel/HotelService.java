package src.hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.util.CSVReader;
import src.util.Display;
import src.util.Form;

public class HotelService {
  private HashMap<String, Hotel> hotels = new HashMap<>();
  private int id = 0;
  private Form form = new Form();

  public HotelService() {
    List<String[]> records = CSVReader.getRecordsFromFile("./data/hotels.csv");
    for (String[] item : records) {
      this.createHotel(item[0], Integer.valueOf(item[1]) , item[2]);
    }
  }

  /** SETTER FUNCTIONS */

  public void createHotel(String hotelName, int stars, String country) {
    this.id += 1;
    Hotel newHotel = new Hotel(this.id, hotelName, stars, country);
    hotels.put(String.valueOf(id), newHotel);
  }

  /** GETTER FUNCTIONS */

  public List<Hotel> getFilteredHotels(String searchString) {
    ArrayList<Hotel> filteredHotels = new ArrayList<>();
    for (Map.Entry<String, Hotel> hotelEntry : this.hotels.entrySet()) {
      Hotel currentHotel = hotelEntry.getValue();
      if (currentHotel.getSearchString().contains(searchString)) {
        filteredHotels.add(currentHotel);
      }
    }
    return filteredHotels;
  }

  public Hotel getHotel(int id) {
    String key = String.valueOf(id);
    if (hotels.containsKey(key)) {
      return this.hotels.get(key);
    }
    System.out.println("There is no hotel with the ID: " + key);
    return null;
  }

  /** USER MASKS */

  public Hotel hotelSelection() {
    Hotel hotel = null;
    while (hotel == null) {
      int hotelId = this.form.getInt("Type in the ID of the hotel you would like to select");
      hotel = this.getHotel(hotelId);
    }
    return hotel;
  }

  public void hotelSearch() {
    Display.printSubHeading("Hotel-Search");
    int option = this.form.getRadioOption(
        "Would you like to search after a specific Hotel?",
        new ArrayList<>(Arrays.asList("Yes", "No")));
    if (option == 1) {
      String searchString = this.form.getString("Hotel-Search");
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
   * 
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
