package src;

import java.util.ArrayList;

public class FlightService {
  private ArrayList<Flight> flights = new ArrayList<Flight>();
  private int id = 0;

  public void createFlight(String flightnumber) {
    this.id += 1;
    Flight newFlight = new Flight(this.id, flightnumber);
    flights.add(newFlight);
  }

  public ArrayList<Flight> getFlights(String searchString) {
    ArrayList<Flight> filteredFlights = new ArrayList<Flight>();
    for (Flight flight: this.flights) {
      if (flight.getSearchString().contains(searchString)) {
        filteredFlights.add(flight);
      }
    }
    return filteredFlights;
  };

  void printFlights() {
    for (Flight flight : this.flights) {
      flight.print();
    }
  }

  void printFlights(ArrayList<Flight> flights) {
    for (Flight flight : flights) {
      flight.print();
    }
  }
}  