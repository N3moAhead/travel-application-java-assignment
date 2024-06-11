package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelService {
  private HashMap<String, Hotel> hotels = new HashMap<>();
  private int id = 0;

  /** CREATION FUNCTIONS */
  
  void createHotel(String hotelName) {
    this.id += 1;
    Hotel newHotel = new Hotel(this.id, hotelName);
    hotels.put(String.valueOf(id), newHotel);
  }

  /** GETTER FUNCTIONS */

  public List<Hotel> getHotels(String searchString) {
    ArrayList<Hotel> filteredHotels = new ArrayList<>();
    for (Map.Entry<String, Hotel> hotelEntry: this.hotels.entrySet()) {
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


  /** DISPLAY FUNCTIONS */

  /**
   * Prints all stored hotels to the terminal
   */
  void printHotels() {
    for (Map.Entry<String, Hotel> hotelEntry: this.hotels.entrySet()) {
      hotelEntry.getValue().print();
    }
  }

  /**
   * Prints a list of given hotels to the terminal
   * @param hotels
   */
  void printHotels(List<Hotel> hotels) {
    for (Hotel hotel: hotels) {
      hotel.print();
    }
  }
}
