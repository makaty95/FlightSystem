package src.Flight1;

import java.util.*;
public class Payment {
    private static int counterID = 0;
    private int paymentID , paymentAmount;
    private String paymentMethod;
    private boolean paymentStatus;
    Scanner input = new Scanner(System.in);


    public Payment(){
        counterID++;
        paymentID = counterID;
        paymentMethod = null;
    }
    public int getPaymentID(){
        return paymentID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    private void displayPaymentMethod(){
        System.out.println("Available payment methods: ");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. Digital Wallets");
    }

    public void  setPaymentMethod (){
        this.displayPaymentMethod();
        System.out.print("Please enter the number of payment method: ");
        int choice = input.nextInt();
        if (choice == 1) {
            paymentMethod = "Credit Card";
        }
        else if (choice == 2) {
            paymentMethod = "Debit Card";
        }
        else if (choice == 3) {
            paymentMethod = "Digital Wallets";
        }
        else {
            System.out.println("Error !! , Try again");
            this.setPaymentMethod();
        }
    }

    private void paymentConfirmation(){

        System.out.println("To pay, press one, to cancel the process, press 2");
        int choice = input.nextInt();
        if (this.paymentMethod == null) {
            System.out.println("Please choose a payment method first");
            this.setPaymentMethod();
        }

        if (choice == 1){
            this.paymentStatus = true;
        }
        else if (choice == 2){
            this.paymentStatus = false;
        }
        else{
            System.out.println("Error !! , Try again");
            this.paymentConfirmation();
        }

    }
    public void calcPaymentAmount(){
//        Depend on Number of Tickets and Price of every ticket
        this.paymentConfirmation();
    }


}