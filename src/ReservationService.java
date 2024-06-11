package src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationService {
  private HashMap<String, Reservation> reservations = new HashMap<>();
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
    for (Map.Entry<String, Reservation> reservationEntry : this.reservations.entrySet()) {
      reservationEntry.getValue().print();
    }
  }

  public void printReservations(List<Reservation> reservations) {
    for (Reservation reservation : reservations) {
      reservation.print();
    }
  }
}
