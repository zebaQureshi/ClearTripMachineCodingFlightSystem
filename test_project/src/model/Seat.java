package model;

import enums.SeatStatus;
import enums.SeatType;

public  class Seat {

    String  id;
    SeatType type;
    Double price;
    SeatStatus status;


    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Seat(String id,Double price,SeatStatus status) {
        this.id = id;

        this.price=price;
        this.status = status;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }
}
