package RunProgram;

import java.util.Scanner;

public class Menu {
    private static Scanner In = new Scanner(System.in); // for all inputs in the menu
    public Menu(){

    }
    public static void showMenu(){
        System.out.println("1. search for flights");
        // more to add later...
    }
    public static int getMenuPrompt(){
        int choice = In.nextInt();
        return choice;
    }

}
