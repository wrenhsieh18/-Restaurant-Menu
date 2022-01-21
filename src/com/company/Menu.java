package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Scanner input = new Scanner(System.in);

    private final String restaurantName;
    private HashMap<String, ArrayList<MenuItem>> menuList = new HashMap<>();

    public Menu(String resName) {
        restaurantName = resName;
        setMenuList();
    }

    @Override
    public String toString() {
        String printOut = String.format("\n*****\n%s menu:\n", restaurantName);

        for (Map.Entry<String, ArrayList<MenuItem>> each : getMenuList().entrySet() ) {
            if (each.getValue().size() > 0) {
                printOut += each.getKey() + "\n";
                for (MenuItem eachItem : each.getValue()) {
                    printOut += eachItem;
                }
            }

        }
        return printOut + "*****\n";
    }

    public String findSpecificItem(String aTarget) {
        String printOut = "";

        for (Map.Entry<String, ArrayList<MenuItem>> each : getMenuList().entrySet() ) {
            if (each.getValue().contains(new MenuItem(aTarget))) {
                printOut += each.getKey() + "\n";
                for (MenuItem eachItem : each.getValue()) {
                    if (eachItem.getName().equals(aTarget)) {
                        printOut += eachItem;
                    }
                }
            }
        }
        return printOut;
    }

    public String findSpecificCategory(String aCategory) {
        String printOut = aCategory + "\n";
        for (MenuItem eachItem : menuList.get(aCategory)) {
            printOut += eachItem;
        }
        return printOut;
    }


    public void addItems() {
        Integer categoryChoosen;
        String categoryInput = "Other";
        do {
            System.out.println("Which category are you adding a new item to?\n1 - Appetizer\n2 - Main Course\n3 - Dessert\n4 - Drink");
            categoryChoosen = input.nextInt();
            input.nextLine();
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
        } while (categoryChoosen != 1 && categoryChoosen != 2 && categoryChoosen != 3 && categoryChoosen != 4 );


        System.out.print("Item name: ");
        String nameInput = input.nextLine();

        if (!menuList.get(categoryInput).contains(new MenuItem(nameInput))) {
            System.out.print("Price: ");
            Integer priceInput = input.nextInt();
            input.nextLine();

            System.out.print("Description: ");
            String inStockInput = input.nextLine();

            MenuItem newItem = new MenuItem(categoryInput, nameInput, priceInput, inStockInput);

            menuList.get(categoryInput).add(newItem);
            System.out.println("Item added!");
        } else {
            System.out.println("The item is already in the menu.");
        }
    }

    public void removeItem() {
        Integer categoryChoosen;
        String categoryInput = "Other";
        do {
            System.out.print("Which category you would like to remove an item from?");
            String prompt = "";
            if (menuList.get("Appetizer").size() > 0) {
                prompt += "\n1 - Appetizer";
            }
            if (menuList.get("Main Course").size() > 0) {
                prompt += "\n2 - Main Course";
            }
            if (menuList.get("Dessert").size() > 0) {
                prompt += "\n3 - Dessert";
            }
            if (menuList.get("Drink").size() > 0) {
                prompt += "\n4 - Drink";
            }
            System.out.println(prompt);

            categoryChoosen = input.nextInt();
            input.nextLine();
            if (categoryChoosen == 1 && menuList.get("Appetizer").size() > 0) {
                categoryInput = "Appetizer";
            } else if (categoryChoosen == 2 && menuList.get("Main Course").size() > 0){
                categoryInput = "Main Course";
            } else if (categoryChoosen == 3 && menuList.get("Dessert").size() > 0){
                categoryInput = "Dessert";
            } else if (categoryChoosen == 4 && menuList.get("Drink").size() > 0){
                categoryInput = "Drink";
            } else {
                System.out.println("You made an invalid action, or the category has no item.");
            }
        } while (categoryChoosen != 1 && categoryChoosen != 2 && categoryChoosen != 3 && categoryChoosen != 4 );

        System.out.println("Which item you would like to remove? ");
        for (MenuItem eachItem : menuList.get(categoryInput)) {
            System.out.print(eachItem + "\n");
        }
        String targetItemInput = input.nextLine();

        MenuItem targetItem = new MenuItem(targetItemInput);
        menuList.get(categoryInput).remove(targetItem);
    }

    private void setMenuList() {
        menuList.put("Appetizer", new ArrayList<MenuItem>());
        menuList.put("Main Course", new ArrayList<MenuItem>());
        menuList.put("Dessert", new ArrayList<MenuItem>());
        menuList.put("Drink", new ArrayList<MenuItem>());
        menuList.put("Other", new ArrayList<MenuItem>());
    }

    public String getResturantName() {return restaurantName; }

    public HashMap<String, ArrayList<MenuItem>> getMenuList() { return menuList; }
}
