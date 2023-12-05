public class AirPort {
    public int getAirportCode() {
        return airportCode;
    }
    public AirPort()
    {
        this.airportName="";
        this.airportCode=0;
        this.airportLocation="";
    }

    public void setAirportCode(int airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }

    private int airportCode;
    private String airportName;
    private String airportLocation;
}