import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Ticket {
    private int ticketNumber;
    private String ticketFare;

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber() {
        String d = "";
        for (int i = 0; i < 6; i++) {
            d += (int) (Math.random() * 10);
        }
        this.ticketNumber = Integer.parseInt(d);
       // System.out.println("Ticket Number: " + this.ticketNumber);
    }


    public String getTicketFare() {
        return ticketFare;
    }

    public void setTicketFare(String ticketFare) {
        this.ticketFare = ticketFare;
    }

    public boolean getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(boolean ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    private boolean ticketStatus;

    public void showData()
    {
        System.out.println("################################################################################");
        System.out.println("##                                     Ticket                                 ##");
        System.out.println("##          ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠀⢠\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢾⡟⢻⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠾⢁⡏⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠾⠃⢀⠞⠀⣾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡾⠋⠀⢀⡞⠀⣸⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣠⢤⡼⠁⠀⠈⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠾⠋⠀⠀⢠⡞⠀⢠⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⠃⠀⠀⢀⣀⣹⣆⣠⣠⡶⠶⠶⠶⠶⠶⠶⠶⠶⠶⢶⣶⠿⢯⣤⡤⠶⢶⣾⡷⠶⠿⢭⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣼⣷⠶⠒⠚⠛⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡠⠀⠀⠸⣯⣭⣄⣀⡀⡀⠈⠙⠳⢶⣄⣀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⠀⠀⠀⠀⠀⣠⣤⠞⠋⠁⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣄⢀⣤⢰⣶⠿⡿⠀⢠⣤⡴⠛⠉⠈⠉⠉⠉⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⠀⠀⠀⣠⠞⠻⠿⠤⣄⣀⡀⠀⡀⠀⢀⡀⢀⣀⣀⣀⣤⣠⣶⣾⣿⠘⣿⠿⡿⠙⠻⠀⠋⣠⣷⠶⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⢀⣴⠾⠻⢦⣄⣀⣀⣀⣸⠷⣏⡉⢱⠿⠷⠿⠟⠿⠏⠙⠃⠉⣁⣈⣀⣌⣶⣄⣠⣶⡶⠚⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⢠⡿⠃⠀⠀⠀⠀⠉⠉⠉⠁⠀⢿⣥⣾⠀⠁⠀⣀⣠⣤⠿⠖⠒⠛⠛⠉⠉⠁⠈⠉⠛⠲⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠸⢧⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⣰⡴⠚⠿⣥⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠢⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⠀⠉⠉⠙⠒⠒⠒⠒⠲⠶⠶⠶⠖⠒⠛⠛⠲⠶⢿⣯⣯⣝⣒⣂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠳⢦⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣏⢻⠉⠉⠉⠓⠒⢶⣤⣴⣶⣦⣤⣄⡀⠀⠀⠀⠀⠀⠈⠙⠶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣴⣧⣀⣤⠤⠖⠋⢸⣿⣝⣍⠙⠛⠓⠯⢿⣷⣶⣦⠤⢤⣤⣀⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠉⠀⠀⠀⠀⠀⠀⢸⣿⣽⣿⡇⠀⣠⣤⡼⠛⠀⠈⠉⠉⠛⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠿⠛⠋⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\t\t\t"
                +" ⠀                                                        ");
        System.out.println("##                                                                            ##");
        System.out.println("##                                                                            ##");
        System.out.println("##                                                                            ##");
        System.out.println("##                                                                            ##");

        System.out.println("Ticket Number : "+this.getTicketNumber());
            String RESET = "\u001B[0m";
            String GREEN = "\u001B[32m";
            System.out.println("Ticket State : " + GREEN + "Confirmed" + RESET);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate today = LocalDate.now();

            LocalDate finalDate = null;

            LocalDate After30day = today.plusDays(30);
            System.out.print( "Expire Date: ");
            System.out.println(dtf.format(After30day));


        System.out.println("Ticket Fare : "+this.getTicketFare());
        System.out.println("################################################################################");
    }
}