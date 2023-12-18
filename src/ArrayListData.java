import java.util.ArrayList;
import java.util.List;

public class ArrayListData {
    // basic declaration of Arraylist
    private static final List<FlightDetails> Listdata = new ArrayList<>();

    public static List<FlightDetails> flightDetails() {
        return Listdata;
    }

    public void addflightdetails(FlightDetails flight) {
        Listdata.add(flight);
    }

    public void ShowFlightDetails() {
        for (FlightDetails details : Listdata) {
            System.out.println("      " + details.flightNum + "       | " + "      " +
                    details.departureAirport.getAirportLocation() + "        | " + "      " + details.arrivalAirport.getAirportLocation() + "       | " +
                    "      " + details.departure_time + "    | " + "    " + details.arrival_time + "    | " + "   ");
        }
    }
}