package model;
import enums.Destination;
import enums.FareType;

import java.util.*;
public class Flight {

    String flightNum;
    int totalSeatCount;
    int availableSeatCount;
    String airlineName;
    Destination fromDest;
    Destination toDest;
    int departDate;
    double departTime;
    double arrivalTime;
    Map<FareType,List<Seat>> initialSeats;
    Map<FareType,List<Seat>> availableSeats;
    Map<FareType,List<Seat>> bookedSeats;
    List<Booking> activeBookings;

    @Override
    public String toString() {
        return "Flight{" +
                "flightNum='" + flightNum + '\'' +
                ", totalSeatCount=" + totalSeatCount +
                ", availableSeatCount=" + availableSeatCount +
                ", airlineName='" + airlineName + '\'' +
                ", fromDest=" + fromDest +
                ", toDest=" + toDest +
                ", departDate=" + departDate +
                ", departTime=" + departTime +
                ", arrivalTime=" + arrivalTime +
                ", initialSeats=" + initialSeats +
                ", availableSeats=" + availableSeats +
                ", bookedSeats=" + bookedSeats +
                ", activeBookings=" + activeBookings +
                '}';
    }

    public Map<FareType, List<Seat>> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(Map<FareType, List<Seat>> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }


    public List<Booking> getActiveBookings() {
        return activeBookings;
    }

    public void setActiveBookings(List<Booking> activeBookings) {
        this.activeBookings = activeBookings;
    }



    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public int getTotalSeatCount() {
        return totalSeatCount;
    }

    public void setTotalSeatCount(int totalSeatCount) {
        this.totalSeatCount = totalSeatCount;
    }

    public int getAvailableSeatCount() {
        return availableSeatCount;
    }

    public void setAvailableSeatCount(int availableSeatCount) {
        this.availableSeatCount = availableSeatCount;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Destination getFromDest() {
        return fromDest;
    }

    public void setFromDest(Destination fromDest) {
        this.fromDest = fromDest;
    }

    public Destination getToDest() {
        return toDest;
    }

    public void setToDest(Destination toDest) {
        this.toDest = toDest;
    }

    public int getDepartDate() {
        return departDate;
    }

    public void setDepartDate(int departDate) {
        this.departDate = departDate;
    }

    public double getDepartTime() {
        return departTime;
    }

    public void setDepartTime(double departTime) {
        this.departTime = departTime;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Map<FareType, List<Seat>> getInitialSeats() {
        return initialSeats;
    }

    public void setInitialSeats(Map<FareType, List<Seat>> initialSeats) {
        this.initialSeats = initialSeats;
    }

    public Map<FareType, List<Seat>> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Map<FareType, List<Seat>> availableSeats) {
        this.availableSeats = availableSeats;
    }
}
