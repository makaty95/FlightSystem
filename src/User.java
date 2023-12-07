import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class User {

    ArrayListData a = new ArrayListData();
    Passenger p = new Passenger();

    public void searchFlight() {

        Scanner In = new Scanner(System.in);
        // User Search for Departure Airport
        List<FlightDetails> data = ArrayListData.flightDetails();
        List<FlightDetails> matchingFlights = new ArrayList<>();
        LocalDate finalDate=null;
        System.out.println("---------------------------------------------------------");

        System.out.println("Enter Departure Airport");
        String departureLocationEnter = In.nextLine();

        // User Search for Arrival Airport
        System.out.println("Enter Arrival Airport");
        String arrivalLocationEnter = In.nextLine();


        // Search by Departure airport and arrival airport in the Arraylist
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

            if (departureDay > 5 || departureDay < 1) {
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
        } while (departureDay > 5 || departureDay < 1);

        return finalDate;
    }


    static final String flightnumenter=null;


    public void selectflight() {
        List<FlightDetails> data = ArrayListData.flightDetails();
        Booking booking = new Booking();
        FlightDetails flightInfo = new FlightDetails();

        // User select the Flight number
        Scanner In = new Scanner(System.in);
        boolean c = false;
        while  (true){
            System.out.println("Choose Flight number");
            String flightnumenter = In.nextLine();
            for (FlightDetails f : data){
                if (f.flightNum.equals(flightnumenter)){
                    flightInfo = f;
                    booking.addOneFlight(flightInfo);
                    c = true;
                    break;
                }
            }
            if (c == true){
                break;
            }
            else{
                System.out.println("Error !!, Try Again");
            }

        }
        String flightclassEnter =null;
        // Display available additional services
        System.out.println("Available Additional Services:");
        System.out.println("1. WiFi");
        System.out.println("2. Meal");
        System.out.println("3. both");
        System.out.println("4. Nothings");
        String adservice = null;

        System.out.print("Enter the number corresponding to the additional service: ");

        while (true){
            int serviceChoice = In.nextInt();

            if (serviceChoice == 1)
            {
                adservice = "Wifi";
                booking.serv = "Wifi";
                break;
            }

            else if (serviceChoice == 2)
            {
                adservice = "Meal";
                booking.serv = "Meal";
                break;
            }
            else if (serviceChoice == 3)
            {
                adservice = "Wifi & Meal";
                booking.serv = "Wifi & Meal";
                break;
            }
            else if (serviceChoice == 4)
            {
                adservice = "Nothings";
                booking.serv = "Nothings";
                break;
            }
            else
                System.out.println("Error !!, Try Again");
        }
                flightInfo.displayFlightInfo();
                System.out.println(
                        "Additional Services : " + adservice  +"\n"+
                        "-------------------------------------------");



        booking.seatForBooking = userSeatSelection(booking.flightInfo.NonValidSeatsEconomic , booking.flightInfo.NonValidSeatsFirstClass  , booking.flightInfo.NonValidSeatsBusiness);
        p.addFlight(booking);
        booking.bookingStatus = userPayment(booking);
        displayCurrentFlights();
    }


    public void enterData() {
        p.PassengerInfo();
    }
    public void displayCurrentFlights(){
        p.getLastBooking();
    }
    public void displayAllReservations(){
        p.getTotalBookings();
    }
    public Seat userSeatSelection(ArrayList<String> NSE  , ArrayList<String> NSF  , ArrayList<String> NSB  ){
        EconomicSeats economic = new EconomicSeats(80, "Economy");
        BusinessSeats business = new BusinessSeats(40, "Business");
        FirstClassSeats firstClass = new FirstClassSeats(20, "FistClass");
        int choice = SeatSelection.selectClass(economic,business,firstClass , NSE , NSF , NSB  ) ;
        Seat seat = null;
//        We need Handle Wrong Choices -> greater than 3 (4 , 5 , ...)
        String formattedNumber;
        if (choice == 1){
            seat = economic.bookSeat();
            formattedNumber = String.format("%02d", seat.getSeat_Num());
            NSE.add(formattedNumber);
        }
        else if (choice == 2){
            seat = business.bookSeat();
            formattedNumber = String.format("%02d", seat.getSeat_Num());
            NSB.add(formattedNumber);
        }
        else if (choice == 3){
            seat = firstClass.bookSeat();
            formattedNumber = String.format("%02d", seat.getSeat_Num());
            NSF.add(formattedNumber);
        }

        return seat;
    }

    public boolean  userPayment (Booking booking){
        Payment pay = new Payment();
        pay.setPaymentMethod();
        String sClass = null  , services = null ;
        int Price = 0;
        sClass = booking.seatForBooking.getSeatClass();
        services = booking.serv;
        Price = Price + Integer.parseInt(booking.flightInfo.price);
        Price = pay.calcPaymentAmount(Price , sClass , services);
        booking.flightInfo.setPrice(String.valueOf(Price)) ;
        return pay.paymentStatus;

    }
    void cancelFlight() {
        System.out.println("Please enter the reservation number you want to cancel");
        int choice;
        while (true) {
            Scanner In = new Scanner(System.in);
            choice = In.nextInt();
            choice--;
            if (choice >= 0 && choice < p.getNumBookings()) {
                int seatNum = p.bookings.get(choice).seatForBooking.getSeat_Num();
                String formattedNumber = String.format("%02d", seatNum);
                String seatClass = p.bookings.get(choice).seatForBooking.getSeatClass();
                if (seatClass == "Economy") {
                    int size = p.bookings.get(choice).flightInfo.NonValidSeatsEconomic.size();
                    for (int i = 0; i < size; i++) {
                        String S = p.bookings.get(choice).flightInfo.NonValidSeatsEconomic.get(i);
                        if (formattedNumber.equals(S)) {
                            p.bookings.get(choice).flightInfo.NonValidSeatsEconomic.remove(i);
                        }
                    }
                    break;
                } else if (seatClass == "Business") {
                    int size = p.bookings.get(choice).flightInfo.NonValidSeatsBusiness.size();
                    for (int i = 0; i < size; i++) {
                        String S = p.bookings.get(choice).flightInfo.NonValidSeatsBusiness.get(i);
                        if (formattedNumber.equals(S)) {
                            p.bookings.get(choice).flightInfo.NonValidSeatsBusiness.remove(i);
                        }
                    }
                    break;
                } else {
                    int size = p.bookings.get(choice).flightInfo.NonValidSeatsFirstClass.size();
                    for (int i = 0; i < size; i++) {
                        String S = p.bookings.get(choice).flightInfo.NonValidSeatsFirstClass.get(i);
                        if (formattedNumber.equals(S)) {
                            p.bookings.get(choice).flightInfo.NonValidSeatsFirstClass.remove(i);
                        }
                    }
                    break;
                }
            } else {
                System.out.println("Error !!,Try Again");
            }

        }
        p.bookings.remove(choice);
    }
}