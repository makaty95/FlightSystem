import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DataClass.fetchData();
        /*******************************************/
        // Test
        // DataClass.newFlightsByAdmin();
        /*******************************************/
        User user = new User();
        Scanner in = new Scanner(System.in);
        System.out.println("=====================");
        System.out.println("Reserve Flight Now !!");
        System.out.println("=====================");
        user.enterData();
        boolean check = true;
        user.searchFlight(DataClass.flights);


        while(check)
        {
            System.out.println( "1. Reserve Another Flight" + "\n" +
                                "2. View All Reservations" + "\n" +
                                "3. Cancel Reservations" + "\n" +
                                "4. Close");
            while (true){
                int choice = in.nextInt();
                if (choice == 1) {
                    user.searchFlight(DataClass.flights);
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
