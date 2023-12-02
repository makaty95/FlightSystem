package Utilities;

import java.util.Scanner;

public class Menu {
    private static Scanner In = new Scanner(System.in); // for all inputs in the menu
    public Menu(){

    }
    public static void showMenu(){
        System.out.println("[1].search for flights");
        // more to add later..if needed.
    }
    public static int getMenuPrompt(){
        System.out.print("Enter your choice: ");
        int choice = In.nextInt();
        return choice;
    }

}
