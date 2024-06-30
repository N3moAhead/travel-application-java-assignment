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

/** Manages the creation and deletion of flights */
public class FlightService {
  private HashMap<String, Flight> flights = new HashMap<>();
  private int id = 0;
  private Form form = new Form();

  public FlightService() {
    // Load stored flights from a csv file
    List<String[]> records = CSVReader.getRecordsFromFile("./data/flights.csv");
    // Create flight objects from the loaded flights
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

  /**
   * Creates a new Flight Object
   * @param flightnumber The flightnumber of the flight
   * @param from The airport the flight is going to depart from
   * @param to The airport the flight is going to arrive at
   * @param departure The time of the departure of the plain
   * @param arrival The time of the arrival of the plain at the destination
   */
  public void createFlight(String flightnumber, String from, String to, LocalDateTime departure, LocalDateTime arrival) {
    this.id += 1;
    Flight newFlight = new Flight(this.id, flightnumber, from, to, departure, arrival);
    flights.put(String.valueOf(this.id), newFlight);
  }

  /** GETTER FUNCTIONS */

  /**
   * Gets a list of flights that contain a given string inside one
   * of there properties
   * @param searchString A string the function should look for in the flight properties
   * @return A list of flight objects
   */
  public List<Flight> getFilteredFlights(String searchString) {
    List<Flight> filteredFlights = new ArrayList<>();
    // Iterate over each flight objet
    for (Map.Entry<String, Flight> flightEntry : this.flights.entrySet()) {
      Flight currentFlight = flightEntry.getValue();
      // Check if the properties of the current flight match the search string
      if (currentFlight.getSearchString().contains(searchString)) {
        filteredFlights.add(currentFlight);
      }
    }
    return filteredFlights;
  }

  /**
   * Getter function to get a flight by its id
   * @param id The id of the flight
   * @return A flight object or null
   */
  public Flight getFlight(int id) {
    String key = String.valueOf(id);
    if (this.flights.containsKey(key)) {
      return this.flights.get(key);
    }
    System.out.println("There is no flight with the ID: " + key);
    return null;
  }

  /** USER MASKS */

  /**
   * A mask that will ask the user for an id of a flight
   * @return A flight object
   */
  public Flight flightSelection() {
    Flight flight = null;
    while (flight == null) {
      int flightId = this.form.getInt("Type in the ID of the flight you would like to select");
      flight = this.getFlight(flightId);
    }
    return flight;
  }
  
  /**
   * A mask that allows a user to search after specific flights
   */
  public void flightSearch() {
    Display.printSubHeading("Flight-Search");
    int option = this.form.getRadioOption(
      "Would you like to search after a specific Flight?",
      new ArrayList<>(Arrays.asList("Yes", "No"))
      );
      // Check if the user would like to filter all the flights
    if (option == 1) {
      String searchString = this.form.getString("Search");
      List<Flight> searchedFlights = this.getFilteredFlights(searchString);
      // If no flight could be found just print all flights
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

  /**
   * A mask that allows a user to create a new flight object
   */
  public void flightCreator() {
    Display.printHeading("Flight Creation");
    // Collect all the needed variables from the user
    System.out.println("Complete this form:");
    String flightNumber = this.form.getString("Flightnumber");
    String from = this.form.getString("From Airport");
    String to = this.form.getString("To Airport");
    LocalDateTime departure = this.form.getDate("Departure");
    LocalDateTime arrival = this.form.getDate("Arrival");
    // Create a new flight object
    this.createFlight(flightNumber, from, to, departure, arrival);
  }

  /** DISPLAY FUNCTIONS */

  /**
   * Prints all stored flights to the terminal
   */
  void printFlights() {
    System.out.println("\nFlights:");
    for (Map.Entry<String, Flight> flighEntry : this.flights.entrySet()) {
      System.out.print("- ");
      flighEntry.getValue().print();
    }
  }

  /**
   * Prints a list of given flights to the terminal
   * @param flights a list of flight objects
   */
  void printFlights(List<Flight> flights) {
    System.out.println("\nFlights:");
    for (Flight flight : flights) {
      System.out.print("- ");
      flight.print();
    }
  }
}