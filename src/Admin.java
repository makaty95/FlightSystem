import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;
import java.io.*;
import java.time.format.*;

public class Admin {
 final String password="Admin_123456";
  ArrayList<FlightDetails>flightDetailsArrayList=new ArrayList<>();
  FlightDetails flight=new FlightDetails();
 public void addFlight()
 {
   System.out.println("Enter the flight details");
   System.out.println("enter flight departure location");
   Scanner scanner=new Scanner(System.in);
   String airportDeparture=scanner.nextLine();
   this.flight.departureAirport.setAirportLocation(airportDeparture);
   this.flight.setDepartureLocation(airportDeparture);
     System.out.println("enter the data of departure airport");
   System.out.println("enter the name of the airport");
   String airportDepartureName=scanner.nextLine();
  this.flight.departureAirport.setAirportName(airportDepartureName);
   System.out.println("enter the airport code");
   //advanced search and match with airport code in the arraylist;
   String airportDepartureCode=scanner.nextLine();
     this. flight.departureAirport.setAirportCode(airportDepartureCode);
   // entering the data of arrival airport for the flight
   System.out.println("enter flight arrival location");
   String airportArrival=scanner.nextLine();
     this.flight.arrivalAirport.setAirportLocation(airportArrival);
     this.flight.setArrivalLocation(airportArrival);
     System.out.println("enter the data of arrival airport");
   System.out.println("enter the name of the airport");
   String airportArrivalName=scanner.nextLine();
     this.flight.arrivalAirport.setAirportName(airportArrivalName);
   System.out.println("enter the airport code");
   //advanced search and match with airport code in the arraylist;
   String airportArrivalCode=scanner.nextLine();
     this.flight.arrivalAirport.setAirportCode(airportArrivalCode);
   System.out.println("enter the flight number");
   String flightNum=scanner.nextLine();
     this.flight.setFlightNum(flightNum);
   System.out.println("enter the flight departure time ");
   String departureTime=scanner.nextLine();
     this. flight.setDeparture_time(departureTime);
   System.out.println("enter the flight arrival time ");
   String arrivalTime=scanner.nextLine();
     this.flight.setArrival_time(arrivalTime);
   System.out.println("enter the flight price");
   String price= scanner.nextLine();
   this.flight.setPrice(price);
   flightDetailsArrayList.add(flight);
 }
 public void showAllFlights()
 {
   for(int i=0;i<flightDetailsArrayList.size();i++)
   {
     System.out.println("flight number [ "+i+1+" ]");
     System.out.println("the departure location : "+flightDetailsArrayList.get(i).getDepartureLocation()+
             "\nthe arrival location : "+flightDetailsArrayList.get(i).getArrivalLocation()+
             "\nthe price = "+flightDetailsArrayList.get(i).getPrice()+
             "\nthe departure time : "+flightDetailsArrayList.get(i).getDeparture_time()+
             "\nthe arrival time : "+flightDetailsArrayList.get(i).getArrival_time()+
             "\nthe departure  airport name : "+flightDetailsArrayList.get(i).departureAirport.getAirportName()+
             "\nthe departure  airport location : "+flightDetailsArrayList.get(i).departureAirport.getAirportLocation()+
             "\nthe departure airport code : "+flightDetailsArrayList.get(i).departureAirport.getAirportCode()+
             "\nthe arrival  airport name : "+flightDetailsArrayList.get(i).arrivalAirport.getAirportName()+
             "\nthe arrival  airport location : "+flightDetailsArrayList.get(i).arrivalAirport.getAirportLocation()+
             "\nthe arrival airport code : "+flightDetailsArrayList.get(i).arrivalAirport.getAirportCode() );

   }
 }
 public void deleteFlight()
 {
     if(flightDetailsArrayList.size()>0)
     { showAllFlights();
   System.out.println("enter the number of flight you want to delete ");
   Scanner scanner =new Scanner(System.in);
   int choice=scanner.nextInt();
   flightDetailsArrayList.remove(choice-1);}
     else {
         System.out.println("there is no flights added");
     }
 }
}
