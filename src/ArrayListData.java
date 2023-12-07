import java.util.ArrayList;
import java.util.List;

public class ArrayListData
{
    // basic declaration of Arraylist
    private static List<FlightDetails>  Listdata = new ArrayList<>();

    public static List<FlightDetails> flightDetails() {
        return Listdata;
    }


    public void addflightdetails(FlightDetails flight){
        Listdata.add(flight);
    }

<<<<<<< HEAD
   public void ShowFlightDetails(){
=======
    public void ShowFlightDetails(){
>>>>>>> c532873 (Atef)
        for (FlightDetails details : Listdata){

            System.out.println("      " + details.flightNum + "       | " + "      " +
                    details.departureLocation + "        | " + "      " + details.arrivalLocation + "       | " +
                    "      " + details.departure_time + "    | " + "    " + details.arrival_time + "    | " + "   " );
        }
    }
 /* public void ShowFlightDetails(){
      for (FlightDetails details : Listdata){

          System.out.println( "        " + "      " + details.departureLocation + "        | "+ "      " + details.arrivalLocation + "       | "  + details.FlightClass1 + "  |  " + details.FlightClass2);
      }
  }*/
<<<<<<< HEAD
}
=======
}
>>>>>>> c532873 (Atef)
