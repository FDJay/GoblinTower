package goblintower.mvc.view;
import java.util.Scanner;

public class Display{
    public static Scanner kbd = new Scanner(System.in);

    public void step(int h, int stepCount){
        System.out.println("----------------------------------");
        System.out.println("\n...TAKING A STEP...");
        kbd.nextLine(); 
        System.out.println("Current health points: " + h);
        System.out.println("Current steps taken: " + stepCount);
    }
    public int console(){
        System.out.println("----------------------------------");
        System.out.println("\nPlease choose a number option: ");
        System.out.println("1.Take a Step \n2.Visit Potion Shop \n3.Drink potion for Health Points");
        int option = kbd.nextInt();
        return option;
    }
    public boolean playing(){
        System.out.println("----------------------------------");
        System.out.println("\nThe Goblin beat you & you ran out of health points. \nWould you like to keep playing? (yes or no)");
        String str = kbd.nextLine();

        if(str.equalsIgnoreCase("yes"))
            return true;
        else 
            return false;
    }
    public void exit(int level, int slain){
        System.out.println("----------------------------------");
        System.out.println("\nThank you for playing!");
        System.out.println("You reached up to level " + level + "\nYou beat " + slain + " goblins.");
    }
    public void drinking(int hHealth){
        System.out.println("----------------------------------");
        System.out.println("\n...DRINKING POTION... \nUpdated health: " + hHealth);
    }
    public void invalid(){
        System.out.println("----------------------------------");
        System.out.println("\nNot Valid, Try Again");
    }
}