import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        FlightDetails[] f = new FlightDetails[5];
        f[0] = new FlightDetails("101", "Cairo", "Qena", "01:06", "02:10" ,"90000");
        f[1] = new FlightDetails("102", "Cairo", "America", "05:30", "10:30" , "264232");
        f[2] = new FlightDetails("103", "Cairo", "Qena", "01:10", "03:30" , "250000");
        f[3] = new FlightDetails("104", "Cairo", "Alex", "01:00", "07:05" , "250");
        f[4] = new FlightDetails("105", "Cairo", "Qena", "01:07", "07:05","98525");

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
        while(check) // mesh lazem 3la fekra momken while(check) :)
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

