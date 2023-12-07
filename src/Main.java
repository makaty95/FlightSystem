import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        FlightDetails[] f = new FlightDetails[5];
<<<<<<< HEAD
        f[0] = new FlightDetails("101", "Cairo", "Qena", "01:06", "02:10" ,"90000");
        f[1] = new FlightDetails("102", "Cairo", "America", "05:30", "10:30" , "264232");
        f[2] = new FlightDetails("103", "Cairo", "Qena", "01:10", "03:30" , "250000");
        f[3] = new FlightDetails("104", "Cairo", "Alex", "01:00", "07:05" , "250");
        f[4] = new FlightDetails("105", "Cairo", "Qena", "01:07", "07:05","98525");
=======
        f[0] = new FlightDetails("101", "Cairo", "Qena", "01:06", "02:10" ,"9000");
        f[1] = new FlightDetails("102", "Cairo", "America", "05:30", "10:30", "26000");
        f[2] = new FlightDetails("103", "Cairo", "Qena", "01:10", "03:30", "25000");
        f[3] = new FlightDetails("104", "Cairo", "Alex", "01:00", "07:05", "15000");
        f[4] = new FlightDetails("105", "Cairo", "Qena", "01:07", "07:05","10000");
>>>>>>> c532873 (Atef)

        User user = new User();


        ArrayListData a = new ArrayListData();

        for(int i = 0 ; i < f.length; i ++ ) {
            a.addflightdetails(f[i]);
        }

<<<<<<< HEAD
=======
        // 104       |       Cairo        |       Alex       |       01:00    |     07:05    |    6 hours and  5 minutes   | 2023-12-10      |    seat[60]
>>>>>>> c532873 (Atef)
        Scanner in = new Scanner(System.in);
        System.out.println("=====================");
        System.out.println("Reserve Flight Now !!");
        System.out.println("=====================");
        user.enterData();
        boolean check = true;
        while(check)
        {
            user.searchFlight();
            user.selectflight();
            System.out.println("To Reserve another Flight press 1 otherwise press 2");
            while (true){
                int choice = in.nextInt();
                if (choice == 2)
                {
                    check = false;
                    break;
                }
                else if (choice != 1){
                    System.out.println("Wrong , try again!");
                }
                else {
                    break;
                }
            }
        }


        System.out.println("===\nEnd\n===");
    }




}
<<<<<<< HEAD

=======
>>>>>>> c532873 (Atef)
