import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class SearchFlight {

    public void searchFlight() {
        FlightDetails[] f = new FlightDetails[5];
        f[0] = new FlightDetails("101", "Cairo", "Qena", "01:20", "02:10", "First Class  / economy");
        f[1] = new FlightDetails("102", "Cairo", "America", "05:30", "10:30", "business / economy");
        f[2] = new FlightDetails("103", "Cairo", "Qena", "01:10", "03:30", "First class / business");
        f[3] = new FlightDetails("104", "Cairo", "Alex", "01:00", "07:05", "economy / business");
        f[4] = new FlightDetails("105", "Cairo", "Qena", "01:15", "07:05", "business / First Class");


        Scanner In = new Scanner(System.in);
        System.out.println("Enter Departure Airport");
        String departureLocationEnter = In.nextLine();
        System.out.println("Enter Arrival Airport");
        String arrivalLocationEnter = In.nextLine();

        // For Entering Sysdate

        //System.out.println("Enter Deparure day (in form dd/MM) ");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");
        LocalDate today = LocalDate.now();
        int DepartureDay = 0;
        int check1 = 0;
        do {
            LocalDate tomorrow = today.plusDays(1);
            LocalDate After2day = today.plusDays(2);
            LocalDate After3day = today.plusDays(3);
            LocalDate After4day = today.plusDays(4);
            System.out.print(1 + "--> ");
            System.out.println(dtf.format(today));
            System.out.print(2 + "--> ");

            System.out.println(dtf.format(tomorrow));
            System.out.print(3 + "--> ");

            System.out.println(dtf.format(After2day));
            System.out.print(4 + "--> ");

            System.out.println(dtf.format(After3day));
            System.out.print(5 + "--> ");

            System.out.println(dtf.format(After4day));
            System.out.println("Choose Day");
            DepartureDay = In.nextInt();
            if (DepartureDay > 5) {
                System.out.println("Choose number form 1 to 5");

            } else {
                break;
            }
        } while (DepartureDay > 5);


        boolean foundFlights = false;
        FlightDetails[] matchingFlights = new FlightDetails[f.length];
        int count = 0;
        for (int k = 0; k < f.length; k++) {
            if (f[k].departureLocation.equals(departureLocationEnter) && f[k].arrivalLocation.equals(arrivalLocationEnter)) {
                matchingFlights[count] = f[k];
                count++;
                foundFlights = true;
            }
        }

        if (!foundFlights) {
            System.out.println("No flights found for the given airports.");
            searchFlight();
        } else {  // To Arrange the flight number Assending based on Departure Time
            Arrays.sort(matchingFlights, 0, count, Comparator.comparing(FlightDetails::getDeparture_time));
            System.out.println(" Flight number " + " | " + "departure Location" + " | " + "Arrival Location" + " | " + "Departure Time" + " | " + "Arrival Time" + " | " + "        Flight Class");

            for (int i = 0; i < count; i++) {

                // just Sout :)
                System.out.println("      " + matchingFlights[i].flightNum + "       | " + "      " +
                        matchingFlights[i].departureLocation + "        | " + "      " + matchingFlights[i].arrivalLocation + "       | " +
                        "      " + matchingFlights[i].departure_time + "    | " + "    " + matchingFlights[i].arrival_time + "    | " + "   " + matchingFlights[i].FlightClass);
            }
            System.out.println("Enter the Flight number: ");
            In.nextLine();
            String FlightNumEnter = In.nextLine();
            System.out.println("Enter the Flight class: ");
            String FlightClassEnter = In.nextLine();

            for (int i = 0; i < f.length; i++) {
                if (f[i].flightNum.equals(FlightNumEnter)) {
                    System.out.println(f[i].flightNum + " | "
                            + f[i].departureLocation + " | " + f[i].arrivalLocation + " | "
                            + DepartureDay + " | " + f[i].departure_time + " | " + f[i].arrival_time + " | " + FlightClassEnter);
                }
            }


        }
    }
}