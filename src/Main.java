import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        FlightDetails[] f = new FlightDetails[5];
        f[0] = new FlightDetails("101", "Cairo", "Qena", "01:06", "02:10" ,"9000");
        f[1] = new FlightDetails("102", "Cairo", "America", "05:30", "10:30", "26000");
        f[2] = new FlightDetails("103", "Cairo", "Qena", "01:10", "03:30", "25000");
        f[3] = new FlightDetails("104", "Cairo", "Alex", "01:00", "07:05", "15000");
        f[4] = new FlightDetails("105", "Cairo", "Qena", "01:07", "07:05","10000");

        User user = new User();


        ArrayListData a = new ArrayListData();

        for(int i = 0 ; i < f.length; i ++ ) {
            a.addflightdetails(f[i]);
        }

        Scanner in = new Scanner(System.in);
        System.out.println("=====================");
        System.out.println("Reserve Flight Now !!");
        System.out.println("=====================");
        user.enterData();
        boolean check = true;
        user.searchFlight();

        while(check)
        {
            System.out.println( "1. Reserve Another Flight" + "\n" +
                                "2. View All Reservations" + "\n" +
                                "3. Cancel Reservations" + "\n" +
                                "4. Close");
            while (true){
                int choice = in.nextInt();
                if (choice == 1) {
                    user.searchFlight();
                    break;
                }
                if (choice == 2){
                    user.displayAllReservations();
                    break;

                }
                else if (choice == 3){
                    user.displayAllReservations();
                    user.cancelFlight();
                    break;

                }
                else if (choice == 4)
                {
                    check = false;
                    break;
                }

                else {
                    System.out.println("Wrong , try again!");
                }
            }
        }
        System.out.println("===\nEnd\n===");
    }
}
