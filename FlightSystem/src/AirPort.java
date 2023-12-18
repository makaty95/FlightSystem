import java.util.Scanner;

public class AirPort {
    public int getAirportCode() {
        return airportCode;
    }

    Scanner In = new Scanner(System.in);
    public AirPort()
    {
        arrivalAirportName = "";
        departureAirportName = "";
        this.airportCode=0;
        this.airportLocation="";
    }

    public void setAirportCode(int airportCode) {
        this.airportCode = airportCode;
    }


    public String getDepartureAirportLocation() {
        return airportLocation;
    }

    public void setDepartureAirportLocation() {
        System.out.print("Enter Departure Airport: ");
        airportLocation = In.nextLine();
    }

    public String getArrivalAirportLocation() {
        return airportLocation;
    }

    public void setArrivalAirportLocation() {
        System.out.print("Enter Arrival Airport: ");
        airportLocation = In.nextLine();
    }

    private int airportCode;
    private String arrivalAirportName = getArrivalAirportLocation();
    private String departureAirportName = getDepartureAirportLocation();
    private String airportLocation;
}