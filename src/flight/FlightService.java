package src.flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.util.CSVReader;
import src.util.DateTimeUtils;
import src.util.Display;
import src.util.Form;

public class FlightService {
  private HashMap<String, Flight> flights = new HashMap<>();
  private int id = 0;
  private Form form = new Form();

  public FlightService() {
    List<String[]> records = CSVReader.getRecordsFromFile("./data/flights.csv");
    for (String[] item : records) {
      this.createFlight(
        item[0],
        item[1],
        item[2],
        DateTimeUtils.getDateTimeFromString(item[3]),
        DateTimeUtils.getDateTimeFromString(item[4])
      );
    }
  }

  /** SETTER FUNCTIONS */

  public void createFlight(String flightnumber, String from, String to, LocalDateTime departure, LocalDateTime arrival) {
    this.id += 1;
    Flight newFlight = new Flight(this.id, flightnumber, from, to, departure, arrival);
    flights.put(String.valueOf(this.id), newFlight);
  }

  /** GETTER FUNCTIONS */

  public List<Flight> getFilteredFlights(String searchString) {
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
    if (this.flights.containsKey(key)) {
      return this.flights.get(key);
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
    Display.printSubHeading("Flight-Search");
    int option = this.form.getRadioOption(
        "Would you like to search after a specific Flight?",
        new ArrayList<>(Arrays.asList("Yes", "No"))
    );
    if (option == 1) {
      String searchString = this.form.getString("Flight-Search");
      List<Flight> searchedFlights = this.getFilteredFlights(searchString);
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
    Display.printHeading("Flight Creation");
    System.out.println("Complete this form:");
    String flightNumber = this.form.getString("Flightnumber");
    String from = this.form.getString("From Airport");
    String to = this.form.getString("To Airport");
    LocalDateTime departure = this.form.getDate("Departure");
    LocalDateTime arrival = this.form.getDate("Arrival");
    this.createFlight(flightNumber, from, to, departure, arrival);
  }

  /** DISPLAY FUNCTIONS */

  void printFlights() {
    System.out.println("\nFlights:");
    for (Map.Entry<String, Flight> flighEntry : this.flights.entrySet()) {
      System.out.print("- ");
      flighEntry.getValue().print();
    }
  }

  void printFlights(List<Flight> flights) {
    System.out.println("\nFlights:");
    for (Flight flight : flights) {
      System.out.print("- ");
      flight.print();
    }
  }
}