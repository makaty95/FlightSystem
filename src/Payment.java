import java.util.*;

public class Payment {

    private static  int counterID = 0;
    private  int paymentID;
    private int paymentAmount;
    private String paymentMethod;
    public String paymentStatus;
    Scanner input = new Scanner(System.in);


    public Payment() {

        paymentID = counterID;
        paymentMethod = null;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    private void displayPaymentMethod() {
        System.out.println("===========================");
        System.out.println("Available payment methods");
        System.out.println("===========================");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. Digital Wallets");
    }

    public void setPaymentMethod() {
        this.displayPaymentMethod();
        System.out.println("----------------------------------------------");
        System.out.print("Please enter the number of payment method: ");
        int choice = input.nextInt();
        if (choice == 1) {
            paymentMethod = "Credit Card";
        } else if (choice == 2) {
            paymentMethod = "Debit Card";
        } else if (choice == 3) {
            paymentMethod = "Digital Wallets";
        } else {
            System.out.println("Error !! , Try again");
            this.setPaymentMethod();
        }
    }

    private void paymentConfirmation() {

        System.out.println("------------------------------------------------------");
        System.out.println("To pay, press one, to cancel the process, press 2");
        int choice = input.nextInt();
        if (this.paymentMethod == null) {
            System.out.println("Please choose a payment method first");
            this.setPaymentMethod();
        }

        if (choice == 1) {
            this.paymentStatus = "true";
        } else if (choice == 2) {
            this.paymentStatus = "false";
        } else {
            System.out.println("Error !! , Try again");
            this.paymentConfirmation();
        }

    }

    public int calcPaymentAmount(int price, String sClass, String services) {
        int taxes = price, temp = price, fees = 600;
        if (sClass.equals("FirstClass")) {
            price = price + (int) (taxes * 0.3);

        } else if (sClass.equals("Business")) {
            price = price + (int) (taxes * 0.2);
        } else if (sClass.equals("economic")) {
            price = price + (int) (taxes * 0.1);
        }
        taxes = temp;
        if (services.equals("Wifi")) {
            price = (int) (price + (taxes * 0.05));

        } else if (services.equals("Meal")) {
            price = (int) (price + (taxes * 0.05));
        } else if (services.equals("Wifi & Meal")) {
            price = (int) (price + (taxes * 0.1));
        }

        System.out.println("Total Price: " + price);
        this.paymentConfirmation();
        return price + fees;
    }
}


