public class Booking {
    public Seat seatForBooking;
    Ticket ticket= new Ticket();
    public String serv;
    int bookingID = 1000;
    boolean bookingStatus;
    public FlightDetails flightInfo;
    private static int nextBookingID = 1000;

    public Booking() {
        this.bookingID = nextBookingID++;
    }

    // Getter for bookingID
    public int getBookingID() {
        return bookingID;
    }

    // Cancel the booking and decrement nextBookingID
    public void cancelBooking() {
        nextBookingID--;
        System.out.println("Booking ID " + bookingID + " has been canceled.");
    }

    public  void addOneFlight(FlightDetails flightInfo){
        this.flightInfo = flightInfo;
    }
    public  void getReservations (){
        flightInfo.displayFlightInfo();
        System.out.println(
                "Seat Number: " + seatForBooking.getSeat_Num() + "\n"+
                        "Seat Class: " + seatForBooking.getSeatClass() + "\n"+
                        "Seat Services: " + serv+
                        "\nBooking ID: " + bookingID);
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";

        if (bookingStatus == true){
            System.out.println("Booking Status: " + GREEN + "Accepted" + RESET + "\n-------------------------------------------");
            this.setTicketData();
            ticket.showData();
        }
        else {

            System.out.println("Booking Status: " + RED + "Rejected" + RESET + "\n-------------------------------------------");
        }
    }
    void setTicketData()
    {
        ticket.setTicketFare(flightInfo.price);
        ticket.setTicketStatus(bookingStatus);
        ticket.setTicketNumber();
        ticket.setSeatClass(seatForBooking.getSeatClass());
        ticket.setSeatNum(seatForBooking.getSeat_Num());
    }
}
