import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;
import java.io.*;
import java.time.format.*;

public class Admin {
    final String password = "Admin_123456";
    ArrayList<FlightDetails> flightDetailsArrayList = new ArrayList<>();
    FlightDetails flight = new FlightDetails();
    private java.lang.String[] Point;

    public void addFlight() {
        System.out.print("Enter the flight details");
        System.out.println("=========================\n");
        System.out.print("Enter flight departure location: ");
        Scanner scanner = new Scanner(System.in);
        String airportDeparture = scanner.nextLine();
        this.flight.departureAirport.setAirportLocation(airportDeparture);
        this.flight.setDepartureLocation(airportDeparture);
        System.out.print("\nEnter the data of departure airport");
        System.out.println("\n-----------------------------------------------");
        System.out.print("\nEnter the name of the airport: ");
        String airportDepartureName = scanner.nextLine();
        this.flight.departureAirport.setAirportName(airportDepartureName);
        System.out.print("\nEnter the airport code: ");
        //advanced search and match with airport code in the arraylist;
        String airportDepartureCode = scanner.nextLine();
        this.flight.departureAirport.setAirportCode(airportDepartureCode);
        // entering the data of arrival airport for the flight
        System.out.print("\nEnter flight arrival location: ");
        String airportArrival = scanner.nextLine();
        this.flight.arrivalAirport.setAirportLocation(airportArrival);
        this.flight.setArrivalLocation(airportArrival);
        System.out.print("\nEnter the data of arrival airport");
        System.out.println("\n-----------------------------------------------");
        System.out.print("\nEnter the name of the airport: ");
        String airportArrivalName = scanner.nextLine();
        this.flight.arrivalAirport.setAirportName(airportArrivalName);
        System.out.print("\nEnter the airport code: ");
        //advanced search and match with airport code in the arraylist;
        String airportArrivalCode = scanner.nextLine();
        this.flight.arrivalAirport.setAirportCode(airportArrivalCode);
        System.out.print("\nEnter the flight number: ");
        String flightNum = scanner.nextLine();
        this.flight.setFlightNum(flightNum);
        System.out.print("\nEnter the flight departure time: ");
        String departureTime = scanner.nextLine();
        this.flight.setDeparture_time(departureTime);
        System.out.print("\nEnter the flight arrival time: ");
        String arrivalTime = scanner.nextLine();
        this.flight.setArrival_time(arrivalTime);
        System.out.print("\nEnter the flight price: ");
        String price = scanner.nextLine();
        this.flight.setPrice(price);
        flightDetailsArrayList.add(flight);
    }

    public void showAllFlights() {
        for (int i = 0; i < flightDetailsArrayList.size(); i++) {
            System.out.println("flight number [ " + i + 1 + " ]");
            System.out.println("the departure location : " + flightDetailsArrayList.get(i).getDepartureLocation() +
                    "\nthe arrival location : " + flightDetailsArrayList.get(i).getArrivalLocation() +
                    "\nthe price = " + flightDetailsArrayList.get(i).getPrice() +
                    "\nthe departure time : " + flightDetailsArrayList.get(i).getDeparture_time() +
                    "\nthe arrival time : " + flightDetailsArrayList.get(i).getArrival_time() +
                    "\nthe departure  airport name : " + flightDetailsArrayList.get(i).departureAirport.getAirportName() +
                    "\nthe departure  airport location : " + flightDetailsArrayList.get(i).departureAirport.getAirportLocation() +
                    "\nthe departure airport code : " + flightDetailsArrayList.get(i).departureAirport.getAirportCode() +
                    "\nthe arrival  airport name : " + flightDetailsArrayList.get(i).arrivalAirport.getAirportName() +
                    "\nthe arrival  airport location : " + flightDetailsArrayList.get(i).arrivalAirport.getAirportLocation() +
                    "\nthe arrival airport code : " + flightDetailsArrayList.get(i).arrivalAirport.getAirportCode());

        }
    }

    public void deleteFlight() {
        if (flightDetailsArrayList.size() > 0) {
            showAllFlights();
            System.out.println("Enter the number of flight you want to delete: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            flightDetailsArrayList.remove(choice - 1);
        } else {
            System.out.println("There is no flights added");
        }
    }

    public void adminMenu(Admin admins) {
        int setCheck = 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t     Hello to our system");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t------------------------------\n");
            System.out.println("1 -> To add a flights\n2 -> To show flights\n3 -> To delete flights");
            int checker = in.nextInt();

            if (checker == 1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Main.clearConsole();
                System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t###### Add Flights ######");
                admins.addFlight();
                endMenu(admins);
            } else if (checker == 2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Main.clearConsole();
                System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t###### Show Flights ######");
                admins.showAllFlights();
                endMenu(admins);
            } else if (checker == 3) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Main.clearConsole();
                System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t###### Delete Flights ######");
                admins.deleteFlight();
                endMenu(admins);
            } else {
                System.out.println("Invalid choice .... please try again");
                setCheck = 1;
            }
        } while (setCheck == 1);
    }

    public void endMenu(Admin admins) {
        System.out.println("--------------------------------------------------------------------------------------------\n");
        System.out.println("Press 1 -> If you want to continue as Admin\nPress 2 -> If you want to back to main menu");
        Scanner in = new Scanner(System.in);
        boolean decision = true;
        do {
            int checkPoint = in.nextInt();
            if (checkPoint == 1) {
                admins.adminMenu(admins);
            } else if (checkPoint == 2) {
                Main.main(Point);
            } else if (checkPoint != 1 && checkPoint != 2) {
                System.out.println("Invalid choice");
                admins.endMenu(admins);
            }
        } while (!decision);
    }
}
