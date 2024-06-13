package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightService {
  private HashMap<String, Flight> flights = new HashMap<>();
  private int id = 0;
  private Form form = new Form();
  private Display display = new Display();

  /** SETTER FUNCTIONS */

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

  /** USER MASKS */

  public Flight flightSelection() {
    Flight flight = null;
    while (flight == null) {
      int flightId = this.form.getInt("Type in the ID of the flight you would like to select");
      flight = this.getFlight(flightId);
    }
    return flight;
  } 

  public void flightSearch() {
    display.printSubHeading("Flight-Search");
    int option = this.form.getRadioOption(
        "Would you like to search after a specific Flight?",
        new ArrayList<>(Arrays.asList("Yes", "No"))
    );
    if (option == 1) {
      String searchString = this.form.getString("Flight-Search");
      List<Flight> searchedFlights = this.getFlights(searchString);
      if (searchedFlights.isEmpty()) {
        System.out.println("No Flight could be found :/ here are all flights unfiltered instead.");
        this.printFlights();
      } else {
        this.printFlights(searchedFlights);
      }
    } else {
      this.printFlights();
    }
  }

  public void flightCreator() {
    this.display.printHeading("Flight Creation");
    String flightNumber = this.form.getString("Type in a FlightNumber");
    this.createFlight(flightNumber);
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