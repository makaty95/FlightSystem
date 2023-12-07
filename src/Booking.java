public class Booking {
    public Seat seatForBooking;
    public String serv;
    boolean bookingStatus;
<<<<<<< HEAD
     public FlightDetails flightInfo;
=======
    public FlightDetails flightInfo;
>>>>>>> c532873 (Atef)


    public  void addOneFlight(FlightDetails flightInfo){
        this.flightInfo = flightInfo;
    }
    public  void getFlight (){
        System.out.println("Flight number : "+flightInfo.flightNum  + "\n" +
                "Departure Airport : " + flightInfo.departureLocation + "\n" +
                "Arrival Airort : " + flightInfo.arrivalLocation +"\n" +
                "Departure time : " + flightInfo.departure_time + "\n" +
                "Arrival time : " + flightInfo.arrival_time + "\n" +
                "Flight price : " +flightInfo.getPrice()+" pounds\n" +
                "duration of the flight about: "+flightInfo.calcDuration()/60+" hours and "+flightInfo.calcDuration()%60+" minutes" + "\n"+
                "Seat Number: " + seatForBooking.getSeat_Num() + "\n"+
                "Seat Class: " + seatForBooking.getSeatClass() + "\n"+
                "Seat Services: " + serv);
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";

        if (bookingStatus == true){
            System.out.println("Booking Status: " + GREEN + "Accepted" + RESET + "\n-------------------------------------------");
        }
        else {
            System.out.println("Booking Status: " + RED + "Rejected" + RESET + "\n-------------------------------------------");
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> c532873 (Atef)
