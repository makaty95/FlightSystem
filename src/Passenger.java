import javax.xml.namespace.QName;
import java.util.*;

public class Passenger {
    private String PassengerID;
    private String PassengerFirstName;
    private String PassengerLastName;
    private String PassengerPhone;
    private String PassengerEmail;
    ArrayList<Booking> bookings = new ArrayList<>();

    public  ArrayList<Booking> getBookings (){
        return bookings;
    }
    public Passenger()
    { }

    public void setPassengerID()
    {
        StringBuilder stringBuilder = new StringBuilder();

        // Generate the first 3 letters
        for (int i = 0; i < 3; i++)
        {
            char letter = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
            stringBuilder.append(letter);
        }

        // Generate the next 6 digits
        for (int i = 0; i < 6; i++)
        {
            int digit = (int) (Math.random() * 10);
            stringBuilder.append(digit);
        }
        this.PassengerID = stringBuilder.toString();
    }

    public void setPassengerName(String passengerFName, String passengerLName)
    {
        boolean valid = false;
        while (!valid)
        {
            System.out.println("Enter your First name");
            Scanner sc = new Scanner(System.in);
            this.PassengerFirstName = sc.nextLine();
            if (PassengerFirstName.matches("^[a-zA-Z]*$")&&this.PassengerFirstName.length()>0)
            {
                valid = true;
            }
            else
            {
                System.out.println("Please enter your correct name");
                passengerFName="";
            }
        }

        boolean valid1 = false;
        while (!valid1)
        {
            System.out.println("Enter your Last name");
            Scanner sc = new Scanner(System.in);
            this.PassengerLastName = sc.nextLine();
            if (passengerLName.matches("^[a-zA-Z]*$")&&this.PassengerLastName.length()>0)
            {
                valid1 = true;
            }
            else
            {
                System.out.println("Please enter your correct name");
                passengerLName="";
            }


        }
    }


    public void setPassengerPhone()
    {
        boolean valid = false;
        while (!valid)
        {
            System.out.println("Enter your phone number");
            Scanner sc = new Scanner(System.in);
            String phone = sc.nextLine();
            this.PassengerPhone=phone;
            if (this.PassengerPhone.matches("\\d{11}")&&this.PassengerPhone.length()>0)
            {
                valid = true;
                this.PassengerPhone = phone;
            }
            else
            {
                System.out.println("Please enter your correct number");
            }
        }
    }

    public void setPassengerEmail(String passengerEmail)
    {
        boolean valid = false;
        while (!valid)
        {
            System.out.println("Enter your Email");
            Scanner sc = new Scanner(System.in);
            this.PassengerEmail = sc.nextLine();
            if (this.PassengerEmail.contains("@") && this.PassengerEmail.contains(".com"))
            {
                valid = true;
            }
            else
            {
                System.out.println("Please enter your correct Email)");
            }
        }
    }

    public String getPassengerID() {
        return this.PassengerID;
    }


    public String getPassengerName() {
        return this.PassengerFirstName;
    }

    public String getPassengerEmail() {
        return this.PassengerEmail;
    }

    public String getPassengerPhone() {
        return PassengerPhone;
    }

    public void showPassengerInfo()
    {
        System.out.println ("Name: " + this.PassengerFirstName + " " + this.PassengerLastName
                + "\nPassenger ID: " + this.PassengerID
                + "\nEmail: " + this.PassengerEmail
                + "\nPhone: " + this.PassengerPhone);
    }


    public void addPassengerInfo()
    {
        String FirstName = "", LastName = "";
        setPassengerName(FirstName, LastName);
        setPassengerID();
        String Email = "";
        setPassengerEmail(Email);
        setPassengerPhone();
    }

    public void PassengerInfo()
    {
        addPassengerInfo();
        showPassengerInfo();
    }
    public void addFlight (Booking booking){
        bookings.add(booking);
    }
    public void getTotalBookings(){
        for (int i = 0; i < bookings.size(); i++){
            bookings.get(i).getFlight();
        }
    }
    public int getNumBookings(){
        return bookings.size();
    }
    public void getLastBooking(){
        bookings.get(bookings.size()-1).getFlight();
    }
}
