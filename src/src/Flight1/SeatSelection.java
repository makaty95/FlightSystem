package src.Flight1;
import java.util.ArrayList;

public abstract class SeatSelection {
    int capacity;
    ArrayList<Seat> flightSeats;
    public abstract void drawSeats();

}
class EconomicSeats extends SeatSelection {

    public EconomicSeats(int capacity){
       this.capacity = capacity;
       this.flightSeats = new ArrayList<>(capacity);
    }
    public void drawSeats(){
        int width = capacity/4;
        int height = 4;
        int seats[][] = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                seats[i][j] = -1;
            }
        }


        System.out.println("Aircraft Seat Display:");

        for(int i = 0; i<width; i++){
            System.out.print("=====");
        }
        System.out.println();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("| ");
                if (seats[i][j] != -1) {
                    System.out.print("X "); // Occupied seat
                } else {
                    String FN = String.format("%02d", i*(width)+j+1);
                    System.out.print(FN+ " ");
                }

            }
            System.out.print("|\n");
            if(i == 1)
            {
                for(int ii = 0; ii<width; ii++){
                    System.out.print("-----");
                }
                System.out.print("\n\n");
                for(int ii = 0; ii<width; ii++){
                    System.out.print("-----");
                }
                System.out.println();

            }

        }
        for(int i = 0; i<width; i++){
            System.out.print("=====");
        }

    }
}

class BusinessSeats extends SeatSelection {

    public BusinessSeats(int capacity){
        this.capacity = capacity;
        this.flightSeats = new ArrayList<>(capacity);
    }
    public void drawSeats(){

    }
}


class FirstClassSeats extends SeatSelection {

    public FirstClassSeats(int capacity){
        this.capacity = capacity;
        this.flightSeats = new ArrayList<>(capacity);
    }
    public void drawSeats(){

    }
}




