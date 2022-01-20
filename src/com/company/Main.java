package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your restaurant's name: ");
        Menu fullMenu = new Menu(input.nextLine());
        Integer option = 1;

        do {
            if (option == 1) {
                fullMenu.addItems();
            } else if (option == 2) {
                fullMenu.removeItem();
            } else if (option == 3) {
                System.out.println("0 - Display full menu\n1 - Display specific category\n2 - Display specific item");
                Integer displayAction = input.nextInt();
                input.nextLine();
                if (displayAction != 1 && displayAction != 2) {
                    if (displayAction != 0) {
                        System.out.println("You entered an invalid number. Default to display full menu.");
                    }
                    System.out.println(fullMenu);
                } else if (displayAction == 1 ) {
                    System.out.println("\n1 - Appetizer\n2 - Main Course\n3 - Dessert\n4 - Drink");
                    Integer categoryChoosen = input.nextInt();
                    input.nextLine();
                    String categoryInput = "Other";
                    if (categoryChoosen == 1) {
                        categoryInput = "Appetizer";
                    } else if (categoryChoosen == 2){
                        categoryInput = "Main Course";
                    } else if (categoryChoosen == 3){
                        categoryInput = "Dessert";
                    } else if (categoryChoosen == 4){
                        categoryInput = "Drink";
                    } else {
                        System.out.println("You made an invalid action.");
                    }
                    System.out.println(fullMenu.findSpecificCategory(categoryInput));
                } else if (displayAction == 2 ) {
                    System.out.print("Please enter the item you would like to display: ");
                    System.out.println(fullMenu.findSpecificItem(input.nextLine()));
                }
            }



            System.out.println("Please take an action:\n0 - Quit\n1 - Add\n2 - Remove\n3 - Display");
            option = input.nextInt();
            input.nextLine();
        }
        while (option > 0 || option <= 3 );













    }
}
