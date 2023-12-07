import java.util.List;
import java.util.Scanner;

public class Ticket {
    private int ticketNumber;
    private float ticketFare;

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public float getTicketFare() {
        return ticketFare;
    }

    public void setTicketFare(float ticketFare) {
        this.ticketFare = ticketFare;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    private String ticketStatus;

//    public static class SelectFlight {
//
//
//        }        public void selectflight() {
//        List<FlightDetails> data = ArrayListData.flightDetails();
//        // User select the Flight number
//        Scanner In = new Scanner(System.in);
//        System.out.println("Choose Flight number");
//        String flightnumenter = In.nextLine();
//
//
//        // User choose Flight Class
//
//    }

}