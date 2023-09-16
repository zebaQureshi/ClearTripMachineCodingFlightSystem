package service;

import dao.FlightDao;
import dao.UserDao;
import enums.Destination;
import enums.FareType;
import enums.SeatStatus;
import model.Booking;
import model.Flight;
import model.Seat;
import model.User;

import java.util.*;

public class FlightService {

    private static FlightDao flightDao;
    Map<String,Flight> flights;
    private static FlightService flightService;
    private static UserService userService = UserService.getInstance();

    private FlightService()
    {}


    public static FlightService getInstance()
    {
        if(flightService ==null)
            flightService = new FlightService();

        return flightService;
    }


    public List<Flight> searchFlights(Destination from, Destination to, int departDate,
                                int paxCount) //pax count is seat count
    {
        List<Flight> flightResponseList = new ArrayList<>();
        for(Flight f: flights.values())
        {
            if(f.getDepartDate()==departDate && f.getFromDest().equals(from) &&
                    f.getToDest().equals(to) && f.getAvailableSeatCount()>=paxCount)
            {
                flightResponseList.add(f);
            }
        }

        //convert to the flightResposneDto coz that is expected in the output format
       return flightResponseList;
    }

    public void BookFlight(String userId, String flightNum, int DepartDate, FareType fareType,
                           List<String> seats)
    {
        int numofSeats =seats.size();
        Flight flight = flights.get(flightNum);
        Set<String> seatsSet= new HashSet<>();
        for(String t: seats)
             seatsSet.add(t);

       if( flight.getAvailableSeatCount() >0 && flight.getAvailableSeatCount()>=numofSeats)
       {
          List<Seat> s= flight.getAvailableSeats().get(fareType);
          if(s!=null && s.size()>0 && s.size()>=numofSeats)
          {
              //seats available
              double price = s.get(0).getPrice() * numofSeats;
              if(userService.isUserValidForBooking(userId,price))
              {
                User user = userService.getUserById(userId);
                user.setFunds(user.getFunds()-price);
                Booking booking = new Booking();
                //update the booking data
                  List<Booking> userBookings= user.getBooking();
                  if(userBookings==null)
                      userBookings=new ArrayList<>();
                  user.getBooking().add(booking);
                  // reduce available seat count
                  //update the seats data

                  int availableSeatsCount = flight.getAvailableSeatCount();
                  int remainingSeats = availableSeatsCount-numofSeats;
                  flight.setAvailableSeatCount(remainingSeats);
                  List<Seat> availableSeats1 = flight.getAvailableSeats().get(fareType);
                 for(Seat seat: availableSeats1)
                 {
                     if(seatsSet.contains(seat.getId()))
                     {
                         seat.setStatus(SeatStatus.BOOKED);
                         availableSeats1.remove(seat);
                         flightDao.updateBookedSeats(flight,seat,fareType);
                         flightDao.updateAvailableSeats(flight,seat,fareType);

                     }
                 }



              }
              else
              {
                  System.out.println("User doesn't have enough funds");
              }


          }
       }

       else
       {
           System.out.println("No seats available");

       }


    }


    public List<Booking> getUserBookings(String userId)
    {

        return userService.getUserBookings(userId);
    }

    public User addUser(String userId, String name, Double funds)
    {
      return  userService.addUser(userId,name,funds);
    }

    public Map<String, Flight> getFlights() {
        return flights;
    }

    public void setFlights(Map<String, Flight> flights) {
        this.flights = flights;
    }
}
