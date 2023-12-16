import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Admin.fetchData();
        Admin admins = new Admin();

        List<FlightDetails> data = ArrayListData.flightDetails();
        for(int i = 0 ; i < Admin.flightDetailsArrayList.size() ; i++ ){
            data.add(Admin.flightDetailsArrayList.get(i));
        }
        Passengers_Reservations_Data.fetchPassengerData();
        Passengers_Reservations_Data.fetchReservationsData();
        Scanner in = new Scanner(System.in);


       /* FlightDetails[] f = new FlightDetails[5];
        f[0] = new FlightDetails("101", "Cairo", "Qena", "Cairo International Airport", "Luxor (LXR) Airport", "AAA101", "CCC103", "01:06", "02:10", "9000");
        f[1] = new FlightDetails("102", "Cairo", "Alex", "Cairo International Airport", "Borg El Arab Airport", "AAA101", "CCC103", "05:30", "10:30", "26000");
        f[2] = new FlightDetails("103", "Cairo", "Qena", "Cairo International Airport", "Luxor (LXR) Airport", "AAA101", "CCC103", "01:10", "03:30", "25000");
        f[3] = new FlightDetails("104", "Cairo", "Alex", "Cairo International Airport", "Borg El Arab Airport", "AAA101", "CCC103", "01:00", "07:05", "15000");
        f[4] = new FlightDetails("105", "Cairo", "Qena", "Cairo International Airport", "Luxor (LXR) Airport", "AAA101", "CCC103", "01:07", "07:05", "10000");
       */
        User user = new User();
        //ArrayListData a = new ArrayListData();

        /*for (int i = 0; i < f.length; i++) {
            a.addflightdetails(f[i]);
        }*/


        System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t✈✈✈✈  Welcome to FCIS Flight Reservation System  ✈✈✈✈");
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t------------------------------------------------------------------------\n");
        System.out.print("1 -> To login as Admin\n2 -> To login as Passenger\n3 -> Exit\n");
        boolean loopCheck = true;
        do {
            int choose = 9;
            try{
                choose = in.nextInt();
            }catch(Exception ex){

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
                        clearConsole();
                        admins.adminMenu(admins);

                    } else {
                        System.out.println("Invalid Password .... Please try again");
                        checks = 1;
                    }
                } while (checks == 1);
            }
            if (choose == 2) {
                System.out.println("=====================");
                System.out.println("Reserve Flight Now !!");
                System.out.println("=====================");
                ////////////////////////////////////////////////////////////////
                user.enterData(Passengers_Reservations_Data.passengersList);
                ////////////////////////////////////////////////////////////////

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
                            System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t✈✈✈✈  Thank you for using our application  ✈✈✈✈");
                            System.out.print("\t\t\t\t\t\t\t\t\t\t\t------------------------------------------------------------------------\n");
                            System.exit(0);
                        } else {
                            System.out.println("Wrong , try again!");
                        }
                    }
                }
            } else if (choose == 3) {
                Admin.saveFlightDetailsToFile();
                System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t✈✈✈✈  Thank you for using our application  ✈✈✈✈");
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t------------------------------------------------------------------------\n");
                System.exit(0);
            } else {
                loopCheck = false;
                System.out.println("Wrong answer ..... Please enter only 1, 2 OR 3");
            }
        } while (!loopCheck);
    }



    // Don't touch will be completed by METWALLYؤ
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {

                System.out.print("\u001b[2J\u001b[H");
                System.out.flush();
            }
        } catch (Exception e) {
            // Handle exceptions, if any
            e.printStackTrace();
        }
    }

}

