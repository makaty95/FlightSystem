import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public  class DataClass {

    static ArrayList<FlightDetails> flights = new ArrayList<FlightDetails>();

    static void newFlightsByAdmin(){
        System.out.println("1. Add New Flights");
        System.out.println("2. View All Flights");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        while(true){
            if(choice == 1){
                System.out.println("Please enter the following information for the new flight");
                // Insert Data of Flight and Check if Data is Exist or No
                /*
                * Flight Num
                * Flight  ..
                * Flight ..
                * Flight ..
                * Flight ..
                */

                break;
            }
            else if (choice == 2){
                int Index = 1;
                for (FlightDetails F : flights){
                    System.out.println("==========");
                    System.out.println("Flight [" + Index + "]");
                    System.out.println("==========");
                    F.displayFlightInfo();
                    System.out.println("-----------------------------------------------------------");
                    Index++;
                }
                break;
            }
            else {
                System.out.println("Error!!, Try Again");
            }
        }
    }
    static void fetchData (){
        try{
            BufferedReader flightsFile = new BufferedReader(new FileReader("Flights_Data.txt"));
            String[] line = new String[8];
            int i = 0;
            while((line[i] = flightsFile.readLine()) != null){
                i++;
                if (i == 8){
                    FlightDetails F = new FlightDetails();
                    F.flightNum = line[0];
                    F.dpartureAirport.setAirportLocation(line[1]);
                    F.arrivalAirport.setAirportLocation(line[2]);
                    F.departure_time = line[3];
                    F.arrival_time = line[4];
                    F.setPrice(line[5]);
                    F.dpartureAirport.setAirportName(line[6]);
                    F.arrivalAirport.setAirportName(line[7]);
                    i = 0;
                    flights.add(F);
                }
            }
            flightsFile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


    static void saveData (){

    }
}

