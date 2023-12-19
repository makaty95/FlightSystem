import java.util.ArrayList;
import java.util.Scanner;

public abstract class SeatSelection {
    int capacity;
    String seatsClass;
    private int width;
    private int height;
    int seatNumber;
    Scanner input = new Scanner(System.in);
    Seat[][] seats;

    public SeatSelection(int _height, int _width) {
        height = _height;
        width = _width;
        seats = new Seat[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                seats[i][j] = new Seat(i * (width) + j + 1, seatsClass);
                seats[i][j].setAvilable(true);
            }
        }
    }

    boolean valid(int i, int j) { /// trivial
        return (i < height && j < width);
    }

    public Seat bookSeat() {
        boolean check = true;
        int a, b;
        System.out.println("\nPlease select a seat number :");
        do {
            check = true;
            seatNumber = input.nextInt();


            a = (int) Math.floor((double) (seatNumber - 1) / width);
            b = (seatNumber - 1) % width;
            if (!valid(a, b)) {
                System.out.println("choose a valid range number: ");
                check = false;
                continue;
            }

            if (seats[a][b].isAvilable()) {
                seats[a][b].setAvilable(false);
            } else {
                System.out.println("This seat is booked, Please Choose another seat :");
                check = false;
            }

        } while (!check);

        System.out.println("You have booked your seat! with number : " + seatNumber);
        Seat seatForBooking = new Seat(seatNumber, seatsClass);
        return seatForBooking;
    }


    public static int selectClass(EconomicSeats economic, BusinessSeats business, FirstClassSeats firstClass, ArrayList<String> NSE, ArrayList<String> NSF, ArrayList<String> NSB) {
        System.out.println("Please enter seat class\n1 -> Economic\n2 -> Business\n3 -> First Class");
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            choice = input.nextInt();
            if (choice == 1) {
                economic.drawSeats(NSE);
                return choice;
            } else if (choice == 2) {
                business.drawSeats(NSB);
                return choice;

            } else if (choice == 3) {
                firstClass.drawSeats(NSF);
                return choice;

            } else {
                System.out.println("Error !!, Try Again");
            }
        }
    }

    public void drawSeats(ArrayList<String> NS) { // draws the flight seats in 4 x width


        System.out.println("Aircraft Seat Display:");
        for (int i = 0; i < width; i++) {
            System.out.print("==[]=");

        }
        System.out.println("=");


        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("| ");
                String formattedNumber = String.format("%02d", seats[i][j].getSeat_Num());
                boolean check = true;
                for (String S : NS) {
                    if (formattedNumber.equals(S)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    System.out.print(formattedNumber + " ");
                } else {
                    seats[i][j].setAvilable(false);
                    String RED = "\u001B[31m";
                    String RESET = "\u001B[0m";
                    System.out.print(RED + "X  " + RESET); // Occupied seat
                }

            }
            System.out.print("|\n");
            if (i == 1) {
                for (int ii = 0; ii < width; ii++) {
                    System.out.print("-----");
                }
                System.out.println("-");
                System.out.print("\n\n");
                for (int ii = 0; ii < width; ii++) {
                    System.out.print("-----");
                }
                System.out.println("-");

            }

        }
        for (int i = 0; i < width; i++) {
            System.out.print("==[]=");
        }
        System.out.println("=\n");

    }
}

class EconomicSeats extends SeatSelection {

    public EconomicSeats(int capacity, String _seatsClass) {
        super(4, capacity / 4);
        this.capacity = capacity;
        this.seatsClass = _seatsClass;
    }
}

class BusinessSeats extends SeatSelection {

    public BusinessSeats(int capacity, String _seatsClass) {
        super(4, capacity / 4);
        this.capacity = capacity;
        this.seatsClass = _seatsClass;
    }
}


class FirstClassSeats extends SeatSelection {

    public FirstClassSeats(int capacity, String _seatsClass) {
        super(4, capacity / 4);
        this.capacity = capacity;
        this.seatsClass = _seatsClass;
    }
}




