package src;

import java.util.HashMap;
import java.util.ArrayList;

public class ReservationService {
  private HashMap<String, Reservation> reservations = new HashMap<String, Reservation>();
  private int id = 0;

  /** CREATION FUNCTIONS */

  public void createReservation(Flight flight) {
    this.id += 1;
    FlightReservation flightReservation = new FlightReservation(flight);
    this.reservations.put(String.valueOf(id), flightReservation);
  }

  public void createReservation(Hotel hotel) {
    this.id += 1;
    HotelReservation hotelReservation = new HotelReservation(hotel);
    this.reservations.put(String.valueOf(id), hotelReservation);
  }

  public void removeReservation(int id) {
    this.reservations.remove(String.valueOf(id));
  }

  /** DISPLAY FUNCTIONS */

  public void printReservations() {
    for (String i : this.reservations.keySet()) {
      this.reservations.get(i).print();
    }
  }

  public void printReservations(ArrayList<Reservation> reservations) {
    for (Reservation reservation : reservations) {
      reservation.print();
    }
  }
}
