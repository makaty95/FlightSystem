package RunProgram;

import MainClasses.Passenger;

public class Main {
    public static void main(String[] args) {
        SearchFlight S = new SearchFlight();
        S.searchFlight();
        Passenger p = new Passenger();
        p.PassengerInfo();
    }


}