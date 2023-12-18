import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;
import java.io.*;
import java.time.format.*;
import java.lang.String;
interface test
{
    public static boolean testInput(String input) {
        return false;
    }
}
class namesTester implements test{

    public static boolean testInput(String input) {
        for(int i=0;i<input.length();i++)
        { if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z' || input.charAt(i) >= 'A' &&input.charAt(i)<= 'Z')
            continue;
        else return false;
        }
        return input.length()>0;
    }
}
class numberTester implements test{
    public static boolean testInput(String input) {
        for(int i=0;i<input.length();i++)
        {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9')
                continue;
            else return false;
        }
        return input.length()>0;
    }
}
class lineTester implements test {
    public static boolean testInput(String input) {
        for(int i=0;i<input.length();i++)
        { if (input.charAt(i)==' '||input.charAt(i) >= 'a' && input.charAt(i) <= 'z' || input.charAt(i) >= 'A' &&input.charAt(i)<= 'Z')
            continue;
        else return false;
        }
        return input.length()>0;
    }
}
class codeTester implements test{
    public static boolean testInput(String input) {
        return input.length()==3&&input.charAt(0)>='A'&&input.charAt(0)<='Z'&&input.charAt(1)>='A'&&input.charAt(1)<='Z'&&input.charAt(2)>='A'&&input.charAt(2)<='Z';
    }
}
public class Admin {
    final String password = "Admin_123456";
    static ArrayList<FlightDetails> flightDetailsArrayList = new ArrayList<>();
    FlightDetails flight = new FlightDetails();
    private String[] Point;

    public void addFlight() {
        System.out.print("Enter the flight details\n");
        System.out.println("=========================\n");
        System.out.print("Enter flight departure location: ");
        boolean check=false;
        Scanner scanner = new Scanner(System.in);
        String airportDeparture=null;
        while(!check)
        {
            airportDeparture = scanner.nextLine();
            if(!namesTester.testInput(airportDeparture))
            {
                System.out.println("invalid value try again");
            }
            else check=true;
        }
//_______________________________________________________________________________________
        this.flight.departureAirport.setAirportLocation(airportDeparture);
        this.flight.setDepartureLocation(airportDeparture);
        System.out.print("\nEnter the data of departure airport");
        System.out.println("\n-----------------------------------------------");
        System.out.print("\nEnter the name of the airport: ");
        String airportDepartureName =null;
        boolean check5=false;
        while(!check5)
        {
            airportDepartureName= scanner.nextLine();
            if(!lineTester.testInput(airportDepartureName))
            {
                System.out.println("invalid value please try again");
            }
            else check5=true;
        }
        this.flight.departureAirport.setAirportName(airportDepartureName);
        System.out.print("\nEnter the departure airport code: ");
        String airportDepartureCode =null;
        boolean checker6=false;
        while(!checker6)
        {
            airportDepartureCode= scanner.nextLine();
            if(!codeTester.testInput(airportDepartureCode))
            {
                System.out.println("invalid value please try again");
            }
            else checker6=true;
        }
        this.flight.departureAirport.setAirportCode(airportDepartureCode);
        //_____________________________________________________________________________________
        // entering the data of arrival airport for the flight
        System.out.print("\nEnter flight arrival location: ");
        String airportArrival =null;
        boolean check1=false;
        while(!check1)
        {
            airportArrival = scanner.nextLine();
            if(!namesTester.testInput(airportArrival))
            {
                System.out.println("invalid value please try again");
            }
            else check1=true;
        }

        this.flight.arrivalAirport.setAirportLocation(airportArrival);
        this.flight.setArrivalLocation(airportArrival);


        //___________________________________________________________________________________


        System.out.print("\nEnter the data of arrival airport");
        System.out.println("\n-----------------------------------------------");
        System.out.print("\nEnter the name of the airport: ");
        String airportArrivalName = null;
        boolean check4=false;
        while(!check4)
        {
            airportArrivalName=scanner.nextLine();
            if(!lineTester.testInput(airportArrivalName))
            {
                System.out.println("invalid value please try again");
            }
            else check4=true;
        }

        this.flight.arrivalAirport.setAirportName(airportArrivalName);
        System.out.print("\nEnter the airport code: ");
        String airportArrivalCode =null;
        boolean checker7=false;
        while(!checker7)
        {
            airportArrivalCode= scanner.nextLine();

            if(!codeTester.testInput(airportArrivalCode))
            {
                System.out.println("invalid value please try again");
            }
            else checker7=true;
        }
        this.flight.arrivalAirport.setAirportCode(airportArrivalCode);

        //______________________________________________________________________________________________

        System.out.print("\nEnter the flight number: ");
        String flightNum =null;
        boolean check2=false;
        while(!check2)
        {
            flightNum=scanner.nextLine();
            if(!numberTester.testInput(flightNum))
            {
                System.out.println("invalid value please try again");
            }
            else check2=true;
        }
        this.flight.setFlightNum(flightNum);

        //________________________________________________________________________

        System.out.print("\nEnter the flight departure time: ");
        String departureTime = scanner.nextLine();
        this.flight.setDeparture_time(departureTime);
        System.out.print("\nEnter the flight arrival time: ");
        String arrivalTime = scanner.nextLine();
        this.flight.setArrival_time(arrivalTime);
        System.out.print("\nEnter the flight price: ");
        String price =null;
        boolean check3=false;
        while(!check3)
        {
            price=scanner.nextLine();
            if(!numberTester.testInput(price))
            {
                System.out.println("invalid value please try again");
            }
            else check3=true;
        }
        this.flight.setPrice(price);
        flightDetailsArrayList.add(flight);
    }

    public void showAllFlights() {
        if(flightDetailsArrayList.size()==0) {
            System.out.println("there is no flights added ");
            return;
        }
        int i = 1;
        for (FlightDetails flight : flightDetailsArrayList) {
            System.out.println("flight  [ " + i++ + " ]");
            System.out.println("the departure location : " + flight.getDepartureLocation() +
                    "\nflight number : "+ flight.getFlightNum()+
                    "\nthe arrival location : " + flight.getArrivalLocation() +
                    "\nthe price = " + flight.getPrice() +
                    "\nthe departure time : " + flight.getDeparture_time() +
                    "\nthe arrival time : " + flight.getArrival_time() +
                    "\nthe departure  airport name : " + flight.departureAirport.getAirportName() +
                    "\nthe departure  airport location : " + flight.departureAirport.getAirportLocation() +
                    "\nthe departure airport code : " + flight.departureAirport.getAirportCode() +
                    "\nthe arrival  airport name : " + flight.arrivalAirport.getAirportName() +
                    "\nthe arrival  airport location : " + flight.arrivalAirport.getAirportLocation() +
                    "\nthe arrival airport code : " + flight.arrivalAirport.getAirportCode() +
                    "\n______________________________________________________________________________________\n");
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
                    Class = num;
                    while(true){
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