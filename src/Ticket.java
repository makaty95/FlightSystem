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
}
