public class Booking {
    public Seat seatForBooking;
    public String serv;
    boolean bookingStatus;
    public FlightDetails flightInfo;


    public  void addOneFlight(FlightDetails flightInfo){
        this.flightInfo = flightInfo;
    }
    public  void getReservations (){
        flightInfo.displayFlightInfo();
        System.out.println(
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
}