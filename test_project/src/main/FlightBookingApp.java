package main;

import enums.Destination;
import enums.FareType;
import enums.SeatStatus;
import model.Booking;
import model.Flight;
import model.Seat;
import model.User;
import service.FlightService;
import java.util.*;

public class FlightBookingApp {
    public static FlightService flightService = FlightService.getInstance();

    public static void main(String args[])
    {
        //run
        //adding the user
        User user = flightService.addUser("u1","user1",10000.0);
        System.out.println(user.getUserId() +" "+user.getUserName() + " "+user.getFunds());


        //search flight case
        Flight flight = new Flight();
        flight.setFlightNum("f123");
        flight.setAvailableSeatCount(3);
        flight.setInitialSeats(new HashMap<>());
        flight.setFromDest(Destination.DEL);
        flight.setToDest(Destination.BLR);
        flight.setDepartDate(1);
        flight.setAirlineName("6E");
        flight.setDepartTime(10.00);
        flight.setArrivalTime(11.0);
        flight.setActiveBookings(new ArrayList<>());
        flight.setInitialSeats(new HashMap<>());

      //  Seat s1 = new Seat("1b","1000.0", SeatStatus.AVAILABLE);

        // public Seat(String id, SeatType type,Double price,SeatStatus status) {
        //

        List<Flight> f1 = new ArrayList<>();
        f1.add(flight);
      //  flight.getInitialSeats().put(FareType.F1,f1);
       // flight.setInitialSeats(FareType.F1,new ArrayList<>().add(flight));


        flightService.setFlights(new HashMap<>());
        flightService.getFlights().put("f123",flight);
                //  Map<Integer,Flight> flights;

       List<Flight> flights =  flightService.searchFlights(Destination.DEL,
               Destination.BLR,3,2);
//  public List<Flight> searchFlights(Destination from, Destination to, int departDate,
//                                int paxCount)

        if(flights.size()>0)
        {
            System.out.println("search results:");
              for(Flight f: flights)
                  System.out.println(f);
        }
        else
            System.out.println("No flights available");

        //book flight
        // public void BookFlight(String userId, String flightNum, int DepartDate, FareType fareType,
        //                           List<String> seats)





        //get userbookings
       List<Booking> userBookings=  flightService.getUserBookings("u1");

        if(userBookings==null || userBookings.size()==0)
             System.out.println("No bookings");
        else
        {
            for(Booking b:userBookings)
                System.out.println(b);
        }


    }

}
