package src;

import java.util.ArrayList;
import java.util.HashMap;

public class HotelService {
  private HashMap<String, Hotel> hotels = new HashMap<String, Hotel>();
  private int id = 0;

  /** CREATION FUNCTIONS */
  
  void createHotel(String hotelName) {
    this.id += 1;
    Hotel newHotel = new Hotel(this.id, hotelName);
    hotels.put(String.valueOf(id), newHotel);
  }

  /** GETTER FUNCTIONS */

  public ArrayList<Hotel> getHotels(String searchString) {
    ArrayList<Hotel> filteredHotels = new ArrayList<Hotel>();
    for (String i: this.hotels.keySet()) {
      Hotel currentHotel = hotels.get(i);
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


  /** DISPLAY FUNCTIONS */

  /**
   * Prints all stored hotels to the terminal
   */
  void printHotels() {
    for (String i : this.hotels.keySet()) {
      hotels.get(i).print();
    }
  }

  /**
   * Prints a list of given hotels to the terminal
   * @param hotels
   */
  void printHotels(ArrayList<Hotel> hotels) {
    for (Hotel hotel: hotels) {
      hotel.print();
    }
  }
}
