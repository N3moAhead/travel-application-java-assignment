package src;

import java.util.ArrayList;
import java.util.Arrays;
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

  public void flightCreator() {
    Display display = new Display();
    Form form = new Form();
    display.printHeading("Flight Creation");
    String flightNumber = form.getString("Type in a FlightNumber");
    this.createFlight(flightNumber);
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

  public Flight flightSearch() {
    Form form = new Form();
    Display display = new Display();
    Flight flight = null;
    display.printSubHeading("Flight-Search");
    while (flight == null) {
      int option = form.getRadioOption(
        "Would you like to search after a specific Flight?",
        new ArrayList<>(Arrays.asList("Yes", "No"))
      );
      if (option == 1) {
        String searchString = form.getString("Flight-Search");
        List<Flight> searchedFlights = this.getFlights(searchString);
        if (searchedFlights.isEmpty()) {
          System.out.println("No Flight could be found :/ please try again.");
          continue;
        }
        this.printFlights(searchedFlights);
      } else {
        this.printFlights();
      }
      int flightId = form.getInt("Type in the ID of the flight you would like to select");
      flight = this.getFlight(flightId);
    }
    return flight;
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