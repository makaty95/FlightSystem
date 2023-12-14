import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListAirport {

    private final ArrayList<AirPort> airportList;

    public ArrayListAirport() {
        airportList = new ArrayList<>();
    }

    public void addAirport(String name, String code) {
        AirPort airport = new AirPort();
        airport.setAirportName(name);
        airport.setAirportCode(code);
        airportList.add(airport);
    }

    public ArrayList<AirPort> getAirportList() {
        return airportList;
    }

    //Display airport
    public void displayAirports() {
        System.out.println("List of Airports:");
        for (AirPort airport : airportList) {
            System.out.println("Name: " + airport.getAirportName() +
                    ", Code: " + airport.getAirportCode());
        }
    }

    public String getAirportNameByCode(String code) {
        for (AirPort airport : airportList) {
            if (airport.getAirportCode().equals(code)) {
                return airport.getAirportName();
            }
        }
        return "Airport not found for code: " + code;
    }

}