import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;
import java.io.*;
import java.time.format.*;

public class FlightDetails {
    public String flightNum;

    ArrayList<String> NonValidSeatsBusiness = new ArrayList <String>();

    ArrayList<String> NonValidSeatsEconomic = new ArrayList <String>() ;
    ArrayList<String> NonValidSeatsFirstClass = new ArrayList <String>();


    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String departureLocation;
    public String arrivalLocation;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String price,duration;
    public String departure_time, arrival_time;

    //not a clean code don't touch it please
    int calcDuration()
    {
        char s=getArrival_time().charAt(0);
        char d=getArrival_time().charAt(1);
        String hour1= String.valueOf(s+d);
        int a=Integer.parseInt(hour1);//الكبير

        char q=getDeparture_time().charAt(0);
        char w=getDeparture_time().charAt(1);
        String hour2= String.valueOf(q+w);
        int b=Integer.parseInt(hour2);//الصغنن

        char z=getArrival_time().charAt(3);
        char x=getArrival_time().charAt(4);
        String minute1= String.valueOf(z+x);
        int c=Integer.parseInt(minute1);//كبير دقايق

        char t=getDeparture_time().charAt(3);
        char y=getDeparture_time().charAt(4);
        String minute2= String.valueOf(t+y);//صغنن دقيق

        int n=Integer.parseInt(minute2);
        c+=(a*60);
        n+=(b*60);
        return c-n;
    }
    public FlightDetails(String flightNum, String departureLocation, String arrivalLocation, String departure_time, String arrival_time,String price)
    {
        this.flightNum = flightNum;
        this.price=price;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        ///////////////////////////////////
        //========================
        // ONLY TO TEST BY ASHRAF
        //========================
        NonValidSeatsBusiness.add("01");
        NonValidSeatsBusiness.add("02");
        NonValidSeatsBusiness.add("03");
        NonValidSeatsBusiness.add("04");
        NonValidSeatsBusiness.add("10");
        ///////////////////////////////////

    }
    public String getFlightNum() {
        return flightNum;
    }
    public FlightDetails() {
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

    public void displayFlightInfo(){
        System.out.println("Flight Number : "+flightNum  + "\n" +
                "Departure Airport : " + departureLocation + "\n" +
                "Arrival Airport : " + arrivalLocation +"\n" +
                "Departure Time : " + departure_time + "\n" +
                "Arrival Time : " + arrival_time + "\n" +
                "Flight Price : " + getPrice()+" pounds\n" +
                "Duration of the flight about: "+ calcDuration()/60+" hours and "+ calcDuration()%60+" minutes");
    }
}

// flight     p      num od seat    num of tickets