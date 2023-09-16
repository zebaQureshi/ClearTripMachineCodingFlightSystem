package dto;

import enums.Destination;
import enums.FareType;
import model.Seat;
import java.util.*;

public class FlightResponseDto {

     String flightNumber;
     String airline;

    Destination from;
    Destination to;
    int departDate;
    Double departTime;
    Double price;
    FareType fareType;
    List<String> seats; //seat ids

}
