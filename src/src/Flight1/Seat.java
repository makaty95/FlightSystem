package src.Flight1;

import java.util.*;
public  class Seat {
    private int SeatNum;
    private String SeatClass;
    public int getSeat_Num() {
        return SeatNum;
    }
    public void setSeatNum(int seatNum) {
        this.SeatNum = SeatNum;
    }
    public String getSeatClass() {
        return SeatClass;
    }
    public void setSeatClass(String seatClass) {
        this.SeatClass = SeatClass;
    }
    public String getAvailabilityStatus() {
        return AvailabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.AvailabilityStatus = AvailabilityStatus;
    }
    private String AvailabilityStatus;
    public Seat(int seatNum, String seat_Class) {
        this.SeatNum = SeatNum;
        this.SeatClass = SeatClass;
    }
}
