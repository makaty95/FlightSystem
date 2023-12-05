package src.Flight1;
import java.util.ArrayList;

public abstract class SeatSelection {
    int capacity;
    String seatsClass;
    ArrayList<Seat> flightSeats;

    public void drawSeats() { // draws the flight seats in 4 x width
        int width = capacity / 4;
        int height = 4;
        Seat seats[][] = new Seat[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                seats[i][j] = new Seat(i * (width) + j + 1, seatsClass);
                seats[i][j].setAvilable(true);

            }
        }


        System.out.println("Aircraft Seat Display:");
        for (int i = 0; i < width; i++) {
            System.out.print("=====");
        }
        System.out.println();


        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("| ");

                if (seats[i][j].isAvilable()) {
                    String formattedNumber = String.format("%02d", seats[i][j].getSeat_Num());
                    System.out.print(formattedNumber + " ");

                } else {
                    System.out.print("X "); // Occupied seat
                }

            }
            System.out.print("|\n");
            if (i == 1) {
                for (int ii = 0; ii < width; ii++) {
                    System.out.print("-----");
                }
                System.out.print("\n\n");
                for (int ii = 0; ii < width; ii++) {
                    System.out.print("-----");
                }
                System.out.println();

            }

        }
        for (int i = 0; i < width; i++) {
            System.out.print("=====");
        }

    }


}
class EconomicSeats extends SeatSelection {

    public EconomicSeats(int capacity, String _seatsClass) {
       this.capacity = capacity;
        this.seatsClass = _seatsClass;
       this.flightSeats = new ArrayList<>(capacity);
    }

}

class BusinessSeats extends SeatSelection {

    public BusinessSeats(int capacity, String _seatsClass) {
        this.capacity = capacity;
        this.seatsClass = _seatsClass;
        this.flightSeats = new ArrayList<>(capacity);
    }

}


class FirstClassSeats extends SeatSelection {

    public FirstClassSeats(int capacity, String _seatsClass) {
        this.capacity = capacity;
        this.seatsClass = _seatsClass;
        this.flightSeats = new ArrayList<>(capacity);
    }

}





