import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Admin.fetchData();
        Admin admins = new Admin();
        List<FlightDetails> data = ArrayListData.flightDetails();
        for (int i = 0; i < Admin.flightDetailsArrayList.size(); i++) {
            data.add(Admin.flightDetailsArrayList.get(i));
        }
        Passengers_Reservations_Data.fetchPassengerData();
        Passengers_Reservations_Data.fetchReservationsData();
        Scanner in = new Scanner(System.in);
        User user = new User();
        System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t✈✈✈✈  Welcome to FCIS Flight Reservation System  ✈✈✈✈");
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t------------------------------------------------------------------------\n");
        System.out.print("1 -> To login as Admin\n2 -> To login as Passenger\n3 -> Exit\n");
        boolean loopCheck = true;
        do {
            int choose = 0;
            try {
                choose = in.nextInt();
            } catch (Exception ex) {
                System.out.println("Invalid Input! , " + " Exception: " + ex);
                return;
            }
            Thread.sleep(1500);
            if (choose == 1) {
                int checks = 0;
                do {
                    System.out.print("Please enter Admin's password: ");
                    String pass = null;
                    pass = in.next();
                    if (pass.equals(admins.password)) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        adminMenu(admins);
                    } else {
                        System.out.println("Invalid Password .... Please try again");
                        checks = 1;
                    }
                } while (checks == 1);
            } else if (choose == 2) {
                userMenu(user);
            } else if (choose == 3) {
                exitFunction();
            } else {
                loopCheck = false;
                System.out.println("Wrong answer ..... Please enter only 1, 2 OR 3");
            }
        } while (!loopCheck);
    }


    public static void adminMenu(Admin admins) {
        int setCheck = 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t     Hello to our system");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t------------------------------\n");
            System.out.println("1 -> To add a flights\n2 -> To show flights\n3 -> To delete flights\n4 -> To update flights\n5 -> To exit");
            int checker = in.nextInt();

            if (checker == 1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t###### Add Flights ######");
                admins.addFlight();
                adminEndMenu(admins);
            } else if (checker == 2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t###### Show Flights ######");
                admins.showAllFlights();
                adminEndMenu(admins);
            } else if (checker == 3) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t###### Delete Flights ######");
                admins.deleteFlight();
                adminEndMenu(admins);

            }else if (checker == 4){
                System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t###### Update Flights ######");

                admins.updateFlight();
                   adminMenu(admins);
            }
            else if (checker == 5){
                exitFunction();
            }
            else {
                System.out.println("Invalid choice .... please try again");
                setCheck = 1;
            }
        } while (setCheck == 1);
    }


    public static void adminEndMenu(Admin admins) {
        System.out.println("-------------------------------------------------------------------------------------------------\n");
        System.out.println("Press 1 -> Back To Admin Menu\nPress 2 -> To Exit");
        Scanner in = new Scanner(System.in);
        boolean decision = true;
        do {
            int checkPoint = in.nextInt();
            if (checkPoint == 1) {
                adminMenu(admins);
            } else if (checkPoint == 2) {
                exitFunction();
            } else {
                System.out.println("Invalid choice .... please try again");
                decision = false;
            }
        } while (!decision);
    }


    public static void exitFunction() {
        Admin.saveFlightDetailsToFile();
        System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t✈✈✈✈  Thank you for using our application  ✈✈✈✈");
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t------------------------------------------------------------------------\n");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }


    public static void userMenu(User user) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("=====================");
        System.out.println("Reserve Flight Now !!");
        System.out.println("=====================\n");
        user.enterData();
        System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t✈✈✈✈  User Main Menu  ✈✈✈✈");
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t------------------------------------------------------------------------\n\n");
        boolean check = true;
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (check) {
            System.out.println("1. Reserve New Flight" + "\n" +
                    "2. View All Reservations" + "\n" +
                    "3. Cancel Reservations" + "\n" +
                    "4. Close");
            while (true) {
                int choice = in.nextInt();
                if (choice == 1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    user.searchFlight();
                    break;
                }
                if (choice == 2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    user.displayAllReservations();
                    break;

                } else if (choice == 3) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    user.displayAllReservations();
                    user.cancelFlight();
                    break;

                } else if (choice == 4) {
                    Passengers_Reservations_Data.saveReservationsData();
                    Passengers_Reservations_Data.savePassengersData();
                    Admin.saveFlightDetailsToFile();
                    exitFunction();
                } else {
                    System.out.println("Wrong , try again!");
                }
            }
        }
    }
}

