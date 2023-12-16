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
    static ArrayList<FlightDetails> flightDetailsArrayList = new ArrayList<>();
    FlightDetails flight = new FlightDetails();
    private String[] Point;

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
        int i = 1;
        try {
            for (FlightDetails flight : flightDetailsArrayList) {
                System.out.println("flight number [ " + (i++) + " ]");
                System.out.println("the departure location : " + flight.getDepartureLocation() +
                        "\nthe arrival location : " + flight.getArrivalLocation() +
                        "\nthe price = " + flight.getPrice() +
                        "\nthe departure time : " + flight.getDeparture_time() +
                        "\nthe arrival time : " + flight.getArrival_time() +
                        "\nthe departure  airport name : " + flight.departureAirport.getAirportName() +
                        "\nthe departure  airport location : " + flight.departureAirport.getAirportLocation() +
                        "\nthe departure airport code : " + flight.departureAirport.getAirportCode() +
                        "\nthe arrival  airport name : " + flight.arrivalAirport.getAirportName() +
                        "\nthe arrival  airport location : " + flight.arrivalAirport.getAirportLocation() +
                        "\nthe arrival airport code : " + flight.arrivalAirport.getAirportCode());
            }
        } catch (Exception e) {
            System.out.println("Exception with the 'flightDetailsArrayList' ArrayList in class Admin!");
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

    public void adminMenu(Admin admins) throws InterruptedException, IOException {
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

    public void endMenu(Admin admins) throws InterruptedException, IOException {
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
            } else {
                System.out.println("Invalid choice");
                admins.endMenu(admins);
            }
        } while (!decision);
    }

    static void fetchData() {
        try {
            BufferedReader flightsFile = new BufferedReader(new FileReader("Flights_Data.txt"));
            String[] line = new String[10];
            String num = new String();
            String Class;
            int i = 0;
            while ((line[i] = flightsFile.readLine()) != null) {
                i++;
                if (i == 10) {
                    num = flightsFile.readLine();
                    FlightDetails F = new FlightDetails();
                    boolean check = false;
                    while(true){
                        Class = num;
                        if (Class.equals("economic")){
                            while((num = flightsFile.readLine()) != null){
                                if (num.equals("business")){
                                    Class = "business";
                                    break;
                                }
                                F.NonValidSeatsEconomic.add(num);
                            }
                        }
                        else if(Class.equals("business")){
                            while((num = flightsFile.readLine()) != null){
                                if (num.equals("FirstClass")){
                                    Class = "FirstClass";
                                    break;
                                }
                                F.NonValidSeatsBusiness.add(num);
                            }
                        }
                        else if (Class.equals("FirstClass")){
                            while((num = flightsFile.readLine()) != null){
                                if (num.equals("end")){
                                    check = true;
                                    break;
                                }
                                F.NonValidSeatsFirstClass.add(num);
                            }
                        }
                        if (check == true){
                            break;
                        }
                    }
                    F.flightNum = line[0];
                    F.departureAirport.setAirportLocation(line[1]);
                    F.arrivalAirport.setAirportLocation(line[2]);
                    F.departure_time = line[3];
                    F.arrival_time = line[4];
                    F.setPrice(line[5]);
                    F.departureAirport.setAirportName(line[6]);
                    F.arrivalAirport.setAirportName(line[7]);
                    F.departureAirport.setAirportCode(line[8]);
                    F.arrivalAirport.setAirportCode(line[9]);
                    i = 0;
                    flightDetailsArrayList.add(F);
                }
            }
            flightsFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFlightDetailsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Flights_Data.txt"))) {
            for (FlightDetails flight : flightDetailsArrayList) {
                // Write each piece of information on a new line in the file
                writer.write(flight.getFlightNum() + "\n");
                writer.write(flight.getDepartureLocation() + "\n");
                writer.write(flight.getArrivalLocation() + "\n");
                writer.write(flight.getDeparture_time() + "\n");
                writer.write(flight.getArrival_time() + "\n");
                writer.write(flight.getPrice() + "\n");
                writer.write(flight.departureAirport.getAirportName() + "\n");
                writer.write(flight.arrivalAirport.getAirportName() + "\n");
                writer.write(flight.departureAirport.getAirportCode() + "\n");
                writer.write(flight.arrivalAirport.getAirportCode() + "\n");
                writer.write("economic" + "\n");
                for (String S : flight.NonValidSeatsEconomic){
                    writer.write(S + "\n");
                }
                writer.write("business" + "\n");
                for (String S : flight.NonValidSeatsBusiness){
                    writer.write(S + "\n");
                }
                writer.write("FirstClass" + "\n");
                for (String S : flight.NonValidSeatsFirstClass){
                    writer.write(S + "\n");
                }
                writer.write("end" + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
