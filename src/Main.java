public class Main {

    public static void main(String[] args) {

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
        /*SearchFlight S = new SearchFlight();
        S.searchFlight();
        Passenger p = new Passenger();
        p.PassengerInfo();

        FlightDetails[] f = new FlightDetails[5];

        f[0] = new FlightDetails("101", "Cairo", "Qena", "01:06", "02:10" , "first class" , "economy",);
        f[1] = new FlightDetails("102", "Cairo", "America", "05:30", "10:30" , "business","economy");
        f[2] = new FlightDetails("103", "Cairo", "Qena", "01:10", "03:30" ,  "first class" , "business");
        f[3] = new FlightDetails("104", "Cairo", "Alex", "01:00", "07:05" ,  "economy", "business");
        f[4] = new FlightDetails("105", "Cairo", "Qena", "01:07", "07:05","business","first class");

        f[0] = new FlightDetails("101", "Cairo", "Qena", "01:06", "02:10" ,"90000");
        f[1] = new FlightDetails("102", "Cairo", "America", "05:30", "10:30" , "264232");
        f[2] = new FlightDetails("103", "Cairo", "Qena", "01:10", "03:30" , "250000");
        f[3] = new FlightDetails("104", "Cairo", "Alex", "01:00", "07:05" , "250");
        f[4] = new FlightDetails("105", "Cairo", "Qena", "01:07", "07:05","98525");

        ArrayListData a = new ArrayListData();
        User.SearchFlight s = new User.SearchFlight();
        for(int i = 0 ; i < f.length; i ++ ) {
            a.addflightdetails(f[i]);

        }

       // a.ShowFlightDetails();

        s.searchFlight();
        User.SelectFlight select=new User.SelectFlight();
        select.selectflight();
        User.enteringData user=new User.enteringData();
        user.enterData();*/


    }
}
