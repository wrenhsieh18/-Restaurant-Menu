package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);

        Menu fullMenu = new Menu("Wren's", "dinner", "011321");
        Integer addMore;

        do {
            System.out.print("Enter the item you would like to add: ");
            String nameInput = input.nextLine();

            System.out.print("Price: ");
            Integer priceInput = input.nextInt();
            input.nextLine();

            System.out.print("In stock: ");
            String inStockInput = input.nextLine();

            MenuItem newItem = new MenuItem(nameInput, priceInput, inStockInput);

            fullMenu.addItems(newItem);

            System.out.println("The menu now has: ");

            for (MenuItem each : fullMenu.getItems()) {
                System.out.println(each.getName() + "---------- $" + each.getPrice() + " (" + each.getSoldOut() + ")");
            }

            System.out.print("Would you like to add more item to the menu? (1 - Yes, 0 - No)? ");
            addMore = input.nextInt();
            input.nextLine();
        }
        while (addMore == 1);


        System.out.println("\n*****\n" + fullMenu.getResturantName() + "'s " + fullMenu.getMeal() + " menu updated on " + fullMenu.getUpdate());

        for (MenuItem each : fullMenu.getItems()) {
            System.out.println(each.getName() + "\t---------- $" + each.getPrice() + " (" + each.getSoldOut() + ")");
        }
        System.out.println("*****");











    }
}
