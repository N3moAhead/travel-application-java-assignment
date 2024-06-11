package src;

import java.util.ArrayList;
import java.util.HashMap;

public class FlightService {
  private HashMap<String, Flight> flights = new HashMap<String, Flight>();
  private int id = 0;

  /** CREATION FUNCTIONS */

  public void createFlight(String flightnumber) {
    this.id += 1;
    Flight newFlight = new Flight(this.id, flightnumber);
    flights.put(String.valueOf(this.id), newFlight);
  }

  /** GETTER FUNCTIONS */

  public ArrayList<Flight> getFlights(String searchString) {
    ArrayList<Flight> filteredFlights = new ArrayList<Flight>();
    for (String i: this.flights.keySet()) {
      Flight currentFlight = flights.get(i);
      if (currentFlight.getSearchString().contains(searchString)) {
        filteredFlights.add(currentFlight);
      }
    }
    return filteredFlights;
  };

  public Flight getFlight(int id) {
    String key = String.valueOf(id);
    if (flights.containsKey(key)) {
      return flights.get(key);
    }
    System.out.println("There is no flight with the ID: " + key);
    return null;
  }

  /** DISPLAY FUNCTIONS */

  void printFlights() {
    for (String i : this.flights.keySet()) {
      flights.get(i).print();
    }
  }

  void printFlights(ArrayList<Flight> flights) {
    for (Flight flight : flights) {
      flight.print();
    }
  }
}  