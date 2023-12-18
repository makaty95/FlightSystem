public class Booking {
    public Seat seatForBooking;
    Ticket ticket = new Ticket();
    public String serv;
    private static int count = 0;
    String bookingID;
    String bookingStatus;
    public FlightDetails flightInfo;

    public String getServ() {
        return serv;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setSeatForBooking(Seat seatForBooking) {
        this.seatForBooking = seatForBooking;
    }

    public void setServ(String serv) {
        this.serv = serv;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setFlightInfo(FlightDetails flightInfo) {
        this.flightInfo = flightInfo;
    }

    public Booking(String bookingId) {
        count++;
        this.bookingID = bookingId + count;

    }

    public Booking() {

    }

    // Getter for bookingID
    public String getBookingID() {
        return bookingID;
    }

    // Cancel the booking and decrement nextBookingID
    public void cancelBooking() {

        System.out.println("Booking ID " + bookingID + " has been canceled.");
    }

    public void addOneFlight(FlightDetails flightInfo) {
        this.flightInfo = flightInfo;
    }

    public void getReservations() {
        flightInfo.displayFlightInfo();
        System.out.println(
                "Seat Number: " + seatForBooking.getSeat_Num() + "\n" +
                        "Seat Class: " + seatForBooking.getSeatClass() + "\n" +
                        "Seat Services: " + serv +
                        "\nBooking ID: " + bookingID);
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";

        if (bookingStatus.equals("true")) {
            System.out.println("Booking Status: " + GREEN + "Accepted" + RESET + "\n-------------------------------------------");
            this.setTicketData();
            ticket.showData();
        } else {

            System.out.println("Booking Status: " + RED + "Rejected" + RESET + "\n-------------------------------------------");
        }
    }

    void setTicketData() {
        ticket.setTicketFare(flightInfo.price);
        ticket.setTicketStatus(bookingStatus);
        ticket.setSeatClass(seatForBooking.getSeatClass());
        ticket.setSeatNum(seatForBooking.getSeat_Num());
        ticket.setDepartureAirportName(flightInfo.departureAirport.getAirportName());
        ticket.setArrivalAirportName(flightInfo.arrivalAirport.getAirportName());
        ticket.setTicketNumber();
    }
}
