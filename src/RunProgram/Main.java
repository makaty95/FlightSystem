package RunProgram;

import MainClasses.*;
import Utilities.*;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Menu.showMenu(); // main menu
        if(Menu.getMenuPrompt() == 1){ // asks user for input
            // user chose to search flights
            System.out.println("Enter Departure Airport");
            String departureLocationEnter = in.nextLine();
            System.out.println("Enter Arrival Airport");
            String arrivalLocationEnter = in.nextLine();

            SearchFlight Search = new SearchFlight(departureLocationEnter, arrivalLocationEnter);
            ArrayList<FlightDetails> fetchedFlights = Search.searchFlights(); // list of maching flights
        }



    }


}