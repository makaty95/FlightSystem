package Utilities;

import MainClasses.FlightDetails;

import java.time.LocalDate;
// test comment
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SearchFlight {
    // items to be searched for
    private String flightClass;
    private String departureLocation;
    private String arrivalLocation;
    private String departureDate;
    private ArrayList<FlightDetails> Flights; // virtual flights data to be searched.
    public ArrayList<FlightDetails> machingFlights;

    public SearchFlight(String departureLocation, String arrivalLocation){
        this.departureDate = "NONE";
        this.flightClass = "NONE";
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.setVirtualData(); // this will be replaced by fetching flights data from the files.
        machingFlights = searchFlights(); // auto filling
    }
    public SearchFlight(String departureLocation, String arrivalLocation, String departureTime){
            this(departureLocation, arrivalLocation);
            this.departureDate = departureTime;
    }
    public SearchFlight(String departureLocation, String arrivalLocation, String departureTime, String flightClass){
        this(departureLocation, arrivalLocation, departureTime);
        this.flightClass = flightClass;
    }

    protected void setVirtualData(){
        // filling flights with any data.
        Flights = new ArrayList<FlightDetails>(5);
        for (int i = 0; i < 5; i++){
            Flights.add(new FlightDetails());
        }
        Flights.set(0, new FlightDetails("101", "Cairo", "Qena", "01:20", "02:10", "First Class  / economy"));
        Flights.set(1,new FlightDetails("102", "Cairo", "America", "05:30", "10:30", "business / economy"));
        Flights.set(2,new FlightDetails("103", "Cairo", "Qena", "01:10", "03:30", "First class / business"));
        Flights.set(3,new FlightDetails("104", "Cairo", "Alex", "01:00", "07:05", "economy / business"));
        Flights.set(4,new FlightDetails("105", "Cairo", "Qena", "01:15", "07:05", "business / First Class"));

    }

    public void showMachingFlights(){
        System.out.println(" Flight number " + " | " + "departure Location" + " | " + "Arrival Location" + " | " + "Departure Time" + " | " + "Arrival Time" + " | " + "        Flight Class");
        // printing a list of maching flight.
        for(FlightDetails flight : machingFlights){
            // just Sout :)
            System.out.println("      " + flight.flightNum + "       | " + "      " +
                    flight.departureLocation + "        | " + "      " + flight.arrivalLocation + "       | " +
                    "      " + flight.departure_time + "    | " + "    " + flight.arrival_time + "    | " + "   " + flight.FlightClass);

        }
    }


    protected ArrayList<FlightDetails> searchFlights() {
        // searching for flights from the container: Flights


    collecting_maching_flights: { // this is like a comment block

        ArrayList<FlightDetails> matchingFlights = new ArrayList<FlightDetails>();
        boolean foundFlights = false; // flag
        int count = 0; // for array index
        for (int k = 0; k < Flights.size(); k++) {
            if (Flights.get(k).departureLocation.equals(this.departureLocation) &&
                    Flights.get(k).arrivalLocation.equals(this.arrivalLocation)) {
                matchingFlights.add(new FlightDetails());
                matchingFlights.set(count, Flights.get(k)); // adding flight to the maching flights
                count++;
                foundFlights = true;
            }
        }
        // sorting by time and class (by a comparator)

        return matchingFlights;
    }

}

}


        // For Entering Sysdate
//        Scanner In = new Scanner(System.in);
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");
//        LocalDate today = LocalDate.now();
//        int DepartureDay = 0;
//        LocalDate FinalDate = null;
//        int check1 = 0;
//        do {
//
//
//
//            LocalDate tomorrow = today.plusDays(1);
//            LocalDate After2day = today.plusDays(2);
//            LocalDate After3day = today.plusDays(3);
//            LocalDate After4day = today.plusDays(4);
//
//            System.out.print(1 + "--> ");
//            System.out.println(dtf.format(today));
//
//            System.out.print(2 + "--> ");
//            System.out.println(dtf.format(tomorrow));
//
//            System.out.print(3 + "--> ");
//            System.out.println(dtf.format(After2day));
//
//            System.out.print(4 + "--> ");
//            System.out.println(dtf.format(After3day));
//
//            System.out.print(5 + "--> ");
//            System.out.println(dtf.format(After4day));
//
//            System.out.println("Choose Day");
//            DepartureDay = In.nextInt();
//            if (DepartureDay > 5) {
//                System.out.println("Choose number form 1 to 5");
//
//            } else {
//                if (DepartureDay == 1)
//                    FinalDate = today;
//
//                else if (DepartureDay == 2)
//                    FinalDate = tomorrow;
//
//                else if (DepartureDay == 3)
//                    FinalDate = After2day;
//
//                else if (DepartureDay == 4)
//                    FinalDate = After3day;
//
//                else if (DepartureDay == 5)
//                    FinalDate = After4day;
//            }
//
//        } while (DepartureDay > 5);



//        if (!foundFlights) {
//            System.out.println("No flights found for the given airports.");
//            searchFlight();
//        if(foundFlights){

            // To Arrange the flight number Assending based on Departure Time

           // Arrays.sort(matchingFlights, 0, count, Comparator.comparing(FlightDetails::getDeparture_time));


//            System.out.println("Enter the Flight number: ");
//            In.nextLine();
//            String FlightNumEnter = In.nextLine();
//            System.out.println("Enter the Flight class: ");
//            String FlightClassEnter = In.nextLine();

//            for (int i = 0; i < Flights.size(); i++) {
//                if (Flights.get(i).flightNum.equals(FlightNumEnter)) {
//                    System.out.println(Flights.get(i).flightNum + " | "
//                            + Flights.get(i).departureLocation + " | " + Flights.get(i).arrivalLocation + " | "
//                            + dtf.format(FinalDate) + " | " + Flights.get(i).departure_time + " | " + Flights.get(i).arrival_time + " | " + FlightClassEnter);
//                }
//            }

        //}



