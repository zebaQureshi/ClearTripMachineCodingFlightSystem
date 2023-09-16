package dao;

import enums.FareType;
import model.Flight;
import model.Seat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlightDao {

    public Flight addFlight()
    {
        return null;
    }

    public void updateAvailableSeats(Flight flight,Seat seat,FareType fareType)
    {
        List<Seat> seats = flight.getAvailableSeats().get(fareType);
        for(Seat s: seats)
        {
            if(s.getId().equals(seat.getId()))
            {
                seats.remove(s);
            }
        }

    }

    public void updateBookedSeats(Flight flight,Seat seat,FareType fareType)
    {
        Map<FareType, List<Seat>> bookedSeats = flight.getBookedSeats();
        if(bookedSeats.containsKey(fareType))
        {
            bookedSeats.get(fareType).add(seat);

        }
        else {
            List<Seat> seats= new ArrayList<>();
            seats.add(seat);
            bookedSeats.put(fareType,seats);
        }
    }



}
