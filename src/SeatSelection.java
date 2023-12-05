import java.util.ArrayList;
import java.util.Scanner;

public abstract class SeatSelection {
    int capacity;
    String seatsClass;
    int width;
    int height;
    int seatNumber;
    Scanner input = new Scanner(System.in);
    Seat[][] seats;

    public void bookSeat(){
        boolean check = true;
        System.out.println("\nPlease select a seat number :");
        do {
            seatNumber = input.nextInt();
            int i, j;
            i = (int) Math.floor((seatNumber - 1) / width);
            j = (seatNumber - 1) % width;
            if (seats[i][j].isAvilable()) {
                seats[i][j].setAvilable(false);
                System.out.println("\n \t nummber :" + i +"  " + j);
            } else {
                System.out.println("This seat is booked, Please Choose another seat :");
                check = false;
            }
        }while(check == false);

        System.out.println("You have booked seat number : " + seatNumber);
    }



    public static int selectClass(EconomicSeats economic, BusinessSeats business, FirstClassSeats firstClass) {
        System.out.println("Please enter seat class\n1 -> Economic\n2 -> Business\n3 -> First Class");
        Scanner input = new Scanner(System.in);

        int choice = input.nextInt();
        if (choice == 1) {
            economic.drawSeats();
        } else if (choice == 2) {
            business.drawSeats();
        } else if (choice == 3) {
            firstClass.drawSeats();
        }
        return choice;
    }

    public void drawSeats() { // draws the flight seats in 4 x width
        width = capacity / 4;
        height = 4;
        seats = new Seat[height][width];
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
    }

}

class BusinessSeats extends SeatSelection {

    public BusinessSeats(int capacity, String _seatsClass) {
        this.capacity = capacity;
        this.seatsClass = _seatsClass;
    }

}


class FirstClassSeats extends SeatSelection {

    public FirstClassSeats(int capacity, String _seatsClass) {
        this.capacity = capacity;
        this.seatsClass = _seatsClass;
    }

}





