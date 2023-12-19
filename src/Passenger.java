import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.*;

public class Passenger {
    private String PassengerID;
    private String PassengerFirstName;
    private String PassengerLastName;
    private String PassengerPhone;
    private String PassengerEmail;
    ArrayList<Booking> bookings = new ArrayList<>();

    public Passenger() {
    }

    public void setPassengerID() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char letter = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
            stringBuilder.append(letter);
        }

        for (int i = 0; i < 6; i++) {
            int digit = (int) (Math.random() * 10);
            stringBuilder.append(digit);
        }
        this.PassengerID = stringBuilder.toString();
    }

    public void setOldPassengerID(String PassengerID) {
        this.PassengerID = PassengerID;
    }

    public void setPassengerName(String passengerFName, String passengerLName) {
        boolean valid = false;
        System.out.println("Please enter your information");
        System.out.println("==============================\n");
        while (!valid) {
            System.out.print("Enter your First name: ");
            Scanner sc = new Scanner(System.in);
            this.PassengerFirstName = sc.nextLine();
            if (PassengerFirstName.matches("^[a-zA-Z]*$") && this.PassengerFirstName.length() > 1) {
                valid = true;
            } else {
                System.out.println("Please enter your correct name");
                passengerFName = "";
            }
        }

        boolean valid1 = false;
        while (!valid1) {
            System.out.print("\nEnter your Last name: ");
            Scanner sc = new Scanner(System.in);
            this.PassengerLastName = sc.nextLine();
            if (PassengerLastName.matches("^[a-zA-Z]*$") && this.PassengerLastName.length() >1) {
                valid1 = true;
            } else {
                System.out.println("Please enter your correct name");
                PassengerLastName = "";
            }
        }
    }

    public void setOldPassengerName(String PassengerFirstName, String PassengerLastName) {
        this.PassengerFirstName = PassengerFirstName;
        this.PassengerLastName = PassengerLastName;
    }


    public void setPassengerPhone() {
        boolean valid = false;
        while (!valid) {
            System.out.print("\nEnter your phone number: ");
            Scanner sc = new Scanner(System.in);
            String phone = sc.nextLine();
            this.PassengerPhone = phone;
            if (this.PassengerPhone.matches("\\d{11}") && !this.PassengerPhone.isEmpty() && this.PassengerPhone.charAt(0) == '0') {
                valid = true;
                this.PassengerPhone = phone;
            } else {
                System.out.println("Please enter your correct number");
            }
        }
    }

    public void setOldPassengerPhone(String PassengerPhone) {
        this.PassengerPhone = PassengerPhone;
    }

    public void setPassengerEmail(String passengerEmail) {
        boolean valid = false;
        while (!valid) {
            System.out.print("\nEnter your Email: ");
            Scanner sc = new Scanner(System.in);
            this.PassengerEmail = sc.nextLine();
            if (this.PassengerEmail.contains("@") && this.PassengerEmail.contains("gmail") && this.PassengerEmail.contains(".com") && this.PassengerEmail.length() > 10) {
                valid = true;
            } else {
                System.out.println("Please enter your correct Email)");
            }
        }
    }

    public String getPassengerID() {
        return this.PassengerID;
    }

    public String getPassengerFirstName() {
        return PassengerFirstName;
    }


    public String getPassengerLastName() {
        return this.PassengerLastName;
    }

    public String getPassengerEmail() {
        return this.PassengerEmail;
    }

    public void setOldPassengerEmail(String PassengerEmail) {
        this.PassengerEmail = PassengerEmail;
    }

    public String getPassengerPhone() {
        return PassengerPhone;
    }

    public void showPassengerInfo() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Name: " + this.PassengerFirstName + " " + this.PassengerLastName
                + "\nPassenger ID: " + this.PassengerID
                + "\nEmail: " + this.PassengerEmail
                + "\nPhone: " + this.PassengerPhone);
        System.out.println("-----------------------------------------------------------------------------");
    }


    public void addPassengerInfo() throws IOException {
        String FirstName = "", LastName = "";
        setPassengerName(FirstName, LastName);
        String Email = "";
        setPassengerEmail(Email);
        setPassengerPhone();
        // Compare Data From file

        boolean check = true;
        for (Passenger p : Passengers_Reservations_Data.passengersList) {
            if (p.getPassengerEmail().equals(PassengerEmail) && p.getPassengerPhone().equals(PassengerPhone)) {
                check = false;
                setOldPassengerID(p.getPassengerID());
                Passengers_Reservations_Data.Old = true;
                this.bookings = p.bookings;
                System.out.println("\n=======================================");
                System.out.println("★ This Data Has Been Recorded Before ★");
                System.out.println("=======================================\n");

            }
        }
        if (check) {
            setPassengerID();
        }

    }

    public void PassengerInfo() throws IOException {
        addPassengerInfo();
        showPassengerInfo();
    }

    public void addFlight(Booking booking) {
        bookings.add(booking);
        Passengers_Reservations_Data.reservationsList.add(booking);
    }

    public void getTotalBookings() {
        if (getNumBookings() == 0) {
            System.out.println("==================");
            System.out.println("No Reservations!!");
            System.out.println("==================");
        } else {
            for (int i = 0; i < bookings.size(); i++) {
                int count = i + 1;
                System.out.println("================");
                System.out.println("Reservation [" + count + "]");
                System.out.println("================");
                try {
                    bookings.get(i).getReservations();
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Exception : " + ex);
                    System.exit(1);
                }

            }
        }

    }

    public int getNumBookings() {
        return bookings.size();
    }

    public void getLastBooking() {
        bookings.get(bookings.size() - 1).getReservations();
    }

}
