package src;

import java.util.ArrayList;

public class HotelService {
  private ArrayList<Hotel> hotels = new ArrayList<Hotel>();
  private int hotelId = 0;

  void createHotel(String hotelName) {
    this.hotelId += 1;
    Hotel newHotel = new Hotel(this.hotelId, hotelName);
    hotels.add(newHotel);
  }

  public ArrayList<Hotel> getHotels(String searchString) {
    ArrayList<Hotel> filteredHotels = new ArrayList<Hotel>();
    for (Hotel hotel: this.hotels) {
      if (hotel.getSearchString().contains(searchString)) {
        filteredHotels.add(hotel);
      }
    }
    return filteredHotels;
  }

  /**
   * Prints all stored hotels to the terminal
   */
  void printHotels() {
    for (Hotel hotel: this.hotels) {
      hotel.print();
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
