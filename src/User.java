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
        String departureLocationEnter;
        String arrivalLocationEnter;
        LocalDate finalDate = null;
        System.out.println("---------------------------------------------------------");
        boolean flag;
        do {
            flag = false;
            System.out.print("Enter Departure Airport: ");
            departureLocationEnter = In.nextLine();

            // User Search for Arrival Airport
            System.out.print("Enter Arrival Airport: ");
            arrivalLocationEnter = In.nextLine();


            // Search by Departure airport and arrival airport in the Arraylist
            for (FlightDetails search : data) {
                if (search.departureAirport.getAirportLocation().equals(departureLocationEnter) && search.arrivalAirport.getAirportLocation().equals(arrivalLocationEnter)) {
                    matchingFlights.add(search);
                }
            }
            if (matchingFlights.isEmpty()) {
                flag = true;
                System.out.println("sorry there is no flights matching with your requirements at the moment :(");
            }

        } while (flag);
        // User choose Day and get the FinalDate
        finalDate = Day();
        // Sort the list based on departure time
        matchingFlights.sort(Comparator.comparing(FlightDetails::getDeparture_time));

        // Display the sorted result
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Main.clearConsole();

        for (FlightDetails flight : matchingFlights) {
            System.out.println("      " + flight.flightNum + "       | " + "      " +
                    flight.departureAirport.getAirportLocation() + "        | " + "      " + flight.arrivalAirport.getAirportLocation() + "       | " +
                    "      " + flight.departure_time + "    | " + "    " + flight.arrival_time + "    | " +
                    "   " + flight.calcDuration() / 60 + " hours and  " + flight.calcDuration() % 60 + " minutes   | " + finalDate);
            //  `(*>﹏<*)′
        }
        selectFlight(departureLocationEnter, arrivalLocationEnter);
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

            System.out.print("Choose Day: ");
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


    static final String flightnumenter = null;


    public void selectFlight(String departureLocationEnter, String arrivalLocationEnter) {
        List<FlightDetails> data = ArrayListData.flightDetails();
        Booking booking = new Booking();
        FlightDetails flightInfo = new FlightDetails();

        // User select the Flight number
        Scanner In = new Scanner(System.in);
        boolean c = false;
        while (true) {
            System.out.print("Choose Flight number: ");
            String flightnumenter = In.nextLine();
            for (FlightDetails f : data) {
                if (f.flightNum.equals(flightnumenter) && f.departureAirport.getAirportLocation().equals(departureLocationEnter) && f.arrivalAirport.getAirportLocation().equals(arrivalLocationEnter)) {
                    flightInfo = f;
                    booking.addOneFlight(flightInfo);
                    c = true;
                    break;
                }
            }
            if (c) {
                break;
            } else {
                System.out.println("Error !!, Try Again");
            }

        }
        String flightclassEnter = null;
        // Display available additional services

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Main.clearConsole();

        System.out.println("==============================");
        System.out.println("Available Additional Services");
        System.out.println("==============================");
        System.out.println("1. WiFi");
        System.out.println("2. Meal");
        System.out.println("3. both");
        System.out.println("4. Nothings");
        String adservice = null;
        System.out.println("------------------------------------------------------------------\n");
        System.out.print("Enter the number corresponding to the additional service: ");

        while (true) {
            int serviceChoice = In.nextInt();

            if (serviceChoice == 1) {
                adservice = "Wifi";
                booking.serv = "Wifi";
                break;
            } else if (serviceChoice == 2) {
                adservice = "Meal";
                booking.serv = "Meal";
                break;
            } else if (serviceChoice == 3) {
                adservice = "Wifi & Meal";
                booking.serv = "Wifi & Meal";
                break;
            } else if (serviceChoice == 4) {
                adservice = "Nothings";
                booking.serv = "Nothings";
                break;
            } else
                System.out.println("Error !!, Try Again");
        }
        System.out.println("_________________________________________________________________________________________");
        booking.seatForBooking = userSeatSelection(booking.flightInfo.NonValidSeatsEconomic, booking.flightInfo.NonValidSeatsFirstClass, booking.flightInfo.NonValidSeatsBusiness);
        p.addFlight(booking);
        booking.bookingStatus = userPayment(booking);
        displayCurrentFlights();
    }


    public void enterData() {
        p.PassengerInfo();
    }

    public void displayCurrentFlights() {
        p.getLastBooking();
    }

    public void displayAllReservations() {
        p.getTotalBookings();
    }

    public Seat userSeatSelection(ArrayList<String> NSE, ArrayList<String> NSF, ArrayList<String> NSB) {
        EconomicSeats economic = new EconomicSeats(80, "Economy");
        BusinessSeats business = new BusinessSeats(40, "Business");
        FirstClassSeats firstClass = new FirstClassSeats(20, "FistClass");
        int choice = SeatSelection.selectClass(economic, business, firstClass, NSE, NSF, NSB);
        Seat seat = null;
//        We need Handle Wrong Choices -> greater than 3 (4 , 5 , ...)
        String formattedNumber;
        if (choice == 1) {
            seat = economic.bookSeat();
            formattedNumber = String.format("%02d", seat.getSeat_Num());
            NSE.add(formattedNumber);
        } else if (choice == 2) {
            seat = business.bookSeat();
            formattedNumber = String.format("%02d", seat.getSeat_Num());
            NSB.add(formattedNumber);
        } else if (choice == 3) {
            seat = firstClass.bookSeat();
            formattedNumber = String.format("%02d", seat.getSeat_Num());
            NSF.add(formattedNumber);
        }

        return seat;
    }

    public boolean userPayment(Booking booking) {
        Payment pay = new Payment();
        pay.setPaymentMethod();
        String sClass = null, services = null;
        int Price = 0;
        sClass = booking.seatForBooking.getSeatClass();
        services = booking.serv;
        Price = Price + Integer.parseInt(booking.flightInfo.price);
        Price = pay.calcPaymentAmount(Price, sClass, services);
        booking.flightInfo.setPrice(String.valueOf(Price));
        //***********************************************************************************
        if (!pay.paymentStatus) {
            cancelSeat();
        }
        //***********************************************************************************

        return pay.paymentStatus;
    }

    void cancelFlight() {
        System.out.print("Please enter the reservation number you want to cancel: ");
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

                            break;

                        }
                    }
                    break;
                } else if (seatClass == "Business") {
                    int size = p.bookings.get(choice).flightInfo.NonValidSeatsBusiness.size();
                    for (int i = 0; i < size; i++) {
                        String S = p.bookings.get(choice).flightInfo.NonValidSeatsBusiness.get(i);
                        if (formattedNumber.equals(S)) {
                            p.bookings.get(choice).flightInfo.NonValidSeatsBusiness.remove(i);
                            break;
                        }
                    }
                    break;
                } else {
                    int size = p.bookings.get(choice).flightInfo.NonValidSeatsFirstClass.size();
                    for (int i = 0; i < size; i++) {
                        String S = p.bookings.get(choice).flightInfo.NonValidSeatsFirstClass.get(i);
                        if (formattedNumber.equals(S)) {
                            p.bookings.get(choice).flightInfo.NonValidSeatsFirstClass.remove(i);
                            break;
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

    void cancelSeat() {
        int index = p.bookings.size() - 1;
        String seatClass = p.bookings.get(index).seatForBooking.getSeatClass();
        if (seatClass == "Economy") {
            int i = p.bookings.get(index).flightInfo.NonValidSeatsEconomic.size() - 1;
            p.bookings.get(index).flightInfo.NonValidSeatsEconomic.remove(i);
        } else if (seatClass == "Business") {
            int i = p.bookings.get(index).flightInfo.NonValidSeatsBusiness.size() - 1;
            p.bookings.get(index).flightInfo.NonValidSeatsBusiness.remove(i);
        } else {
            int i = p.bookings.get(index).flightInfo.NonValidSeatsFirstClass.size() - 1;
            p.bookings.get(index).flightInfo.NonValidSeatsFirstClass.remove(i);
        }
    }
}