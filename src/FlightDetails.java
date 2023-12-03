import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;
import java.io.*;
import java.time.format.*;

public class FlightDetails {
    public String flightNum, departureLocation, arrivalLocation;
    public String departure_time, arrival_time;
    public String FlightClass;
    public String date;

    /* public ArrayList<Seat> getSeatsAvailable() {
         return seatsAvailable;
     }

     public void setSeatsAvailable(ArrayList<Seat> seatsAvailable) {
         this.seatsAvailable = seatsAvailable;
     }

     public ArrayList<Seat> getTotalSeats() {
         return totalSeats;
     }

     public void setTotalSeats(ArrayList<Seat> totalSeats) {
         this.totalSeats = totalSeats;
     }

     ArrayList<Seat> seatsAvailable;
     ArrayList<Seat> totalSeats;
     */
    public FlightDetails(String flightNum, String departureLocation, String arrivalLocation, String departure_time, String arrival_time, String FlightClass)
    {
        this.flightNum = flightNum;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.FlightClass = FlightClass;
    }

    public FlightDetails() {
    }

    public String getFlightClass() {
        return FlightClass;
    }

    public void setFlightClass(String flightClass) {
        FlightClass = flightClass;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public String getDeparture_time() {
        return departure_time;
    }
}