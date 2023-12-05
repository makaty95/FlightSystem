import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class User {

    public static class SearchFlight {

        ArrayListData a = new ArrayListData();

        public void searchFlight() {

            Scanner In = new Scanner(System.in);
            // User Search for Departure Airport
            List<FlightDetails> data = ArrayListData.flightDetails();
            List<FlightDetails> matchingFlights = new ArrayList<>();
            LocalDate finalDate=null;

            System.out.println("Enter Departure Airport");
            String departureLocationEnter = In.nextLine();

            // User Search for Arrival Airport
            System.out.println("Enter Arrival Airport");
            String arrivalLocationEnter = In.nextLine();


            // Search by Departure airport and arrival airport in the Arraylist
            int count = 0;
            for (FlightDetails search : data) {
                if (search.departureLocation.equals(departureLocationEnter) && search.arrivalLocation.equals(arrivalLocationEnter)) {
                    matchingFlights.add(search);
                }
            }
            if(matchingFlights.size()==0)
            {
                System.out.println("sorry there is no flights matching with your requirements at the moment");
             System.exit(0);
            }
            else {
                // User choose Day and get the FinalDate
                 finalDate = Day();
            }
            // Sort the list based on departure time
            matchingFlights.sort(Comparator.comparing(FlightDetails::getDeparture_time));

            // Display the sorted result
            for (FlightDetails flight : matchingFlights) {
                System.out.println("      " + flight.flightNum + "       | " + "      " +
                        flight.departureLocation + "        | " + "      " + flight.arrivalLocation + "       | " +
                        "      " + flight.departure_time + "    | " + "    " + flight.arrival_time + "    | " +
                        "   " + flight.calcDuration()/60+" hours and  "+flight.calcDuration()%60+" minutes   | " + finalDate);
                //  `(*>﹏<*)′
            }
        }

        public LocalDate Day() {
            Scanner In = new Scanner(System.in);

            // User choose Day
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");
            LocalDate today = LocalDate.now();
            int departureDay = 0;
            LocalDate finalDate = null;

            do {
                LocalDate tomorrow = today.plusDays(1);
                LocalDate after2days = today.plusDays(2);
                LocalDate after3days = today.plusDays(3);
                LocalDate after4days = today.plusDays(4);

                System.out.print(1 + "--> ");
                System.out.println(dtf.format(today));

                System.out.print(2 + "--> ");
                System.out.println(dtf.format(tomorrow));

                System.out.print(3 + "--> ");
                System.out.println(dtf.format(after2days));

                System.out.print(4 + "--> ");
                System.out.println(dtf.format(after3days));

                System.out.print(5 + "--> ");
                System.out.println(dtf.format(after4days));

                System.out.println("Choose Day");
                departureDay = In.nextInt();

                if (departureDay > 5) {
                    System.out.println("Choose number from 1 to 5");
                } else {
                    if (departureDay == 1)
                        finalDate = today;
                    else if (departureDay == 2)
                        finalDate = tomorrow;
                    else if (departureDay == 3)
                        finalDate = after2days;
                    else if (departureDay == 4)
                        finalDate = after3days;
                    else if (departureDay == 5)
                        finalDate = after4days;
                }
            } while (departureDay > 5);

            return finalDate;
    }

    }
static final String flightnumenter=null;
    public static class SelectFlight {

        SearchFlight day = new SearchFlight();
        public void selectflight() {
            List<FlightDetails> data = ArrayListData.flightDetails();
            // User select the Flight number
            Scanner In = new Scanner(System.in);
            System.out.println("Choose Flight number");
            String flightnumenter = In.nextLine();



            // User choose Flight Class
            String flightclassEnter =null;

       /*    int check ;
            do {
                check = 0;
                System.out.println("Choose seat Class  (business , first class , economy)");
                flightclassEnter = In.nextLine().toLowerCase(); // Convert to lowercase to make it case-insensitive

              for (FlightDetails search : data) {
                    // Check if the entered string is one of the valid options
                    if (search.flightNum.equals(flightnumenter) ) {
                        if (search.FlightClass1.equals(flightclassEnter) || search.FlightClass2.equals(flightclassEnter)) {
                            check = -1;
                            break; // Exit the loop if a valid input is entered for this flight
                        } else {
                            System.out.println("\t\nError 404  ");
                            check = 1;
                        }
                    }
                }
            }while(check==1);*/
            for (FlightDetails search : data) {
                if (search.flightNum.equals(flightnumenter) ){
                    System.out.println("Flight number : "+search.flightNum  + "\n" +
                            "Departure Airport : " + search.departureLocation + "\n" +
                            "Arrival Airort : " + search.arrivalLocation +"\n" +
                            "Departure time : " + search.departure_time + "\n" +
                            "Arrival time : " + search.arrival_time + "\n" +
                            "Flight price : " +search.getPrice()+" pounds\n " +
                            "duration of the flight about: "+search.calcDuration()/60+" hours and "+search.calcDuration()%60+" minutes");

                }
         }



        }
}
    public static class enteringData
    {
        public void enterData()
        {
            List<FlightDetails> data = ArrayListData.flightDetails();
            FlightDetails flightData=null;
            for(FlightDetails search : data) {
                if (search.flightNum.equals(flightnumenter) ) {
                    flightData.setArrivalLocation(search.getArrivalLocation());
                    flightData.setDepartureLocation(search.getDepartureLocation());
                    flightData.setFlightNum(search.getFlightNum());
                   flightData.setPrice(search.getPrice());
                   flightData.duration=(search.duration);
                }
            }
            System.out.println("Enter your data");
            Passenger passenger=new Passenger();
            passenger.setPassengerName("","");
            passenger.setPassengerPhone();
            passenger.setPassengerID();
            passenger.setPassengerEmail("");
            //System.out.println("special requirements \n1-special meal \n2-special and medical assistance\n3-baby care\n4-wheelchair service\n5-travelling with pets\n6-thanks");
          //  Scanner input=new Scanner(System.in);
           // int number= input.nextInt();
            //passenger.setService(service);
            System.out.println("your data is ");
            passenger.showPassengerInfo();
        }
    }
}

