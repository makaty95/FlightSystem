public class Main {

    public static void main(String[] args) {


////        SearchFlight S = new SearchFlight();
////        S.searchFlight();
//        Passenger p = new Passenger();
//        p.PassengerInfo();
//
//        FlightDetails[] f = new FlightDetails[5];
//        f[0] = new FlightDetails("101", "Cairo", "Qena", "01:06", "02:10" ,"90000");
//        f[1] = new FlightDetails("102", "Cairo", "America", "05:30", "10:30" , "264232");
//        f[2] = new FlightDetails("103", "Cairo", "Qena", "01:10", "03:30" , "250000");
//        f[3] = new FlightDetails("104", "Cairo", "Alex", "01:00", "07:05" , "250");
//        f[4] = new FlightDetails("105", "Cairo", "Qena", "01:07", "07:05","98525");
//
//        ArrayListData a = new ArrayListData();
//        User.SearchFlight s = new User.SearchFlight();
//        for(int i = 0 ; i < f.length; i ++ ) {
//            a.addflightdetails(f[i]);
//
//        }
//
//        s.searchFlight();
//        User.SelectFlight select=new User.SelectFlight();
//        select.selectflight();


        EconomicSeats economic = new EconomicSeats(80, "Economy");
        BusinessSeats business = new BusinessSeats(40, "Business");
        FirstClassSeats firstClass = new FirstClassSeats(20, "FistClass");
        int choice = SeatSelection.selectClass(economic,business,firstClass);
        if (choice == 1){
            economic.bookSeat();
            economic.drawSeats();
        }
        if (choice == 2){
            business.bookSeat();
            business.drawSeats();
        }
        if (choice == 3){
            firstClass.bookSeat();
            firstClass.drawSeats();
        }



//        public class Main {
//            public static void main(String[] args) {
//                // ANSI escape code constants for text colors
//                String RESET = "\u001B[0m";
//                String RED = "\u001B[31m";
//                String GREEN = "\u001B[32m";
//                String YELLOW = "\u001B[33m";
//
//                // Print colored text to the console
//                System.out.println(GREEN + "This text is green." + RESET);
//                System.out.println(YELLOW + "This text is yellow." + RESET);
//                System.out.println(RED + "This text is red." + RESET);
//    }
//        }


    }
}
