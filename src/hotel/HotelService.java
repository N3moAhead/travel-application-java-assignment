package src.hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.util.Display;
import src.util.Form;

public class HotelService {
  private HashMap<String, Hotel> hotels = new HashMap<>();
  private int id = 0;
  private Form form = new Form();
  private Display display = new Display();

  /** SETTER FUNCTIONS */

  public void createHotel(String hotelName) {
    this.id += 1;
    Hotel newHotel = new Hotel(this.id, hotelName);
    hotels.put(String.valueOf(id), newHotel);
  }

  public void hotelCreator() {
    this.display.printHeading("Hotel Creation");
    String hotelName = this.form.getString("Type in a hotelname");
    this.createHotel(hotelName);
  }

  /** GETTER FUNCTIONS */

  public List<Hotel> getHotels(String searchString) {
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
    this.display.printSubHeading("Hotel-Search");
    int option = this.form.getRadioOption(
        "Would you like to search after a specific Hotel?",
        new ArrayList<>(Arrays.asList("Yes", "No")));
    if (option == 1) {
      String searchString = this.form.getString("Hotel-Search");
      List<Hotel> searchedHotels = this.getHotels(searchString);
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

  /** DISPLAY FUNCTIONS */

  /**
   * Prints all stored hotels to the terminal
   */
  void printHotels() {
    for (Map.Entry<String, Hotel> hotelEntry : this.hotels.entrySet()) {
      hotelEntry.getValue().print();
    }
  }

  /**
   * Prints a list of given hotels to the terminal
   * 
   * @param hotels
   */
  void printHotels(List<Hotel> hotels) {
    for (Hotel hotel : hotels) {
      hotel.print();
    }
  }
}
