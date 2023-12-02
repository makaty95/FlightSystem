import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        SearchFlight S = new SearchFlight();
        S.searchFlight();
        Passenger p = new Passenger();
        p.PassengerInfo();
    }


}