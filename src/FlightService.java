package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightService {
  private HashMap<String, Flight> flights = new HashMap<>();
  private int id = 0;

  /** CREATION FUNCTIONS */

  public void createFlight(String flightnumber) {
    this.id += 1;
    Flight newFlight = new Flight(this.id, flightnumber);
    flights.put(String.valueOf(this.id), newFlight);
  }

  /** GETTER FUNCTIONS */

  public List<Flight> getFlights(String searchString) {
    List<Flight> filteredFlights = new ArrayList<>();
    for (Map.Entry<String, Flight> flightEntry : this.flights.entrySet()) {
      Flight currentFlight = flightEntry.getValue();
      if (currentFlight.getSearchString().contains(searchString)) {
        filteredFlights.add(currentFlight);
      }
    }
    return filteredFlights;
  }

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
    for (Map.Entry<String, Flight> flighEntry : this.flights.entrySet()) {
      flighEntry.getValue().print();
    }
  }

  void printFlights(List<Flight> flights) {
    for (Flight flight : flights) {
      flight.print();
    }
  }
}