package src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingService {
  private HashMap<String, Booking> bookings = new HashMap<>();
  private int id = 0;

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
