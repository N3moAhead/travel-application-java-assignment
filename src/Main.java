package src;

public class Main {
  public static void main(String[] args) {
    HotelService hotelService = new HotelService();
    hotelService.createHotel("Apart Mannheim");
    hotelService.createHotel("Maritim Mannheim");
    hotelService.createHotel("Hotel 22 Frankfurt");
    hotelService.printHotels();
    System.out.println("Filtered List: Mannheim");
    hotelService.printHotels(hotelService.getHotels("Mannheim"));

    FlightService flightService = new FlightService();
    flightService.createFlight("FRA223");
    flightService.createFlight("STR123");
    flightService.createFlight("PEN129");
    flightService.createFlight("TES213");
    flightService.printFlights();
    System.out.println("Filtered Flights: FRA");
    flightService.printFlights(flightService.getFlights("3"));
  }
}
