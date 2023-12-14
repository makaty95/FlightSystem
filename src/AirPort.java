import java.util.Scanner;

public class AirPort {
    public String getAirportCode() {
        return airportCode;
    }

    Scanner In = new Scanner(System.in);

    public AirPort() {
        AirportName = "";
        this.airportCode = "";
        this.airportLocation = "";
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }


    public String getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }

    private String airportCode;

    public String getAirportName() {
        return AirportName;
    }

    public void setAirportName(String airportName) {
        AirportName = airportName;
    }

    private String AirportName;
    //  private String departureAirportName = getDepartureAirportLocation();
    private String airportLocation;
}