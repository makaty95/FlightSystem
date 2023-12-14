import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        FlightDetails[] f = new FlightDetails[5];
        f[0] = new FlightDetails("101", "Cairo", "Qena", "Cairo International Airport" , "Luxor (LXR) Airport" , "AAA101" , "CCC103","01:06", "02:10", "9000");
        f[1] = new FlightDetails("102", "Cairo", "Alex","Cairo International Airport" , "Borg El Arab Airport" , "AAA101" , "CCC103", "05:30", "10:30", "26000");
        f[2] = new FlightDetails("103", "Cairo", "Qena","Cairo International Airport" , "Luxor (LXR) Airport" , "AAA101" , "CCC103", "01:10", "03:30", "25000");
        f[3] = new FlightDetails("104", "Cairo", "Alex","Cairo International Airport" , "Borg El Arab Airport" , "AAA101" , "CCC103", "01:00", "07:05", "15000");
        f[4] = new FlightDetails("105", "Cairo", "Qena","Cairo International Airport" , "Luxor (LXR) Airport" , "AAA101" , "CCC103", "01:07", "07:05", "10000");
        User user = new User();
        ArrayListData a = new ArrayListData();

        for (int i = 0; i < f.length; i++) {
            a.addflightdetails(f[i]);
        }
        Admin admins = new Admin();

        int choose;
        System.out.println("\n\n\t\t\t\t\t\t\t\t✈✈✈✈  Welcome to FCIS Flight Reservation System  ✈✈✈✈");
        System.out.print("\t\t\t\t\t\t-----------------------------------------------------------------------\n");
        System.out.print("1 -> To login as Admin\n2 -> To login as Passenger\n");
        choose = in.nextInt();
        boolean loopCheck = true;
        do {
          if (choose == 1) {
                int checks = 0;
                do {
                    System.out.print("Please enter Admin's password: ");

                    String pass =null ;
                    pass=in.next();
                    int setCheck = 0;
                    if (pass.equals(admins.password)) {

                        do {
                            System.out.println("\t\t\t\t\t\t\t\tHello to our system");
                            System.out.println("\t\t\t\t\t\t\t--------------------------");
                            System.out.println("1 -> To add a flights\n2 -> To show flights\n3 -> To delete flights");
                            int checker = in.nextInt();

                            if (checker == 1) {
                                System.out.println("\t\t\t\t###### Add Flights ######");
                                admins.addFlight();
                                System.out.println("1- return to your main menu\n2-exit");
                                int exitChoice=in.nextInt();
                            } else if (checker == 2) {
                                System.out.println("\t\t\t\t###### Show Flights ######");
                                admins.showAllFlights();
                            } else if (checker == 3) {
                                System.out.println("\t\t\t\t###### Delete Flights ######");
                                admins.deleteFlight();
                            } else {
                                System.out.println("Invalid choice .... please try again");
                                setCheck = 1;
                            }
                        } while (setCheck == 1);
                    }
                    else {
                        System.out.println("Invalid Password .... Please try again");
                        checks = 1;
                    }
                } while (checks == 1);
            }
            if (choose == 2) {
                System.out.println("=====================");
                System.out.println("Reserve Flight Now !!");
                System.out.println("=====================");
                user.enterData();
                boolean check = true;
                user.searchFlight();
                while (check) {
                    System.out.println("1. Reserve Another Flight" + "\n" +
                            "2. View All Reservations" + "\n" +
                            "3. Cancel Reservations" + "\n" +
                            "4. Close");
                    while (true) {
                        int choice = in.nextInt();
                        if (choice == 1) {
                            user.searchFlight();
                            break;
                        }
                        if (choice == 2) {
                            user.displayAllReservations();
                            break;

                        } else if (choice == 3) {
                            user.displayAllReservations();
                            user.cancelFlight();
                            break;

                        } else if (choice == 4) {
                            check = false;
                            break;
                        } else {
                            System.out.println("Wrong , try again!");
                        }
                    }
                }
                System.out.println("===\nEnd\n===");
            } else {
                System.out.println("Wrong answer ..... Please enter ony 1 OR 2");
                loopCheck = false;
            }
        } while (!loopCheck);
    }
}
