package com.company;

import java.util.ArrayList;

public class Menu {
    private String resturantName;
    private String meal; //breakfast, lunch, dinner
    private String update;
    private ArrayList<MenuItem> menuList = new ArrayList<>();

    public Menu(String resName, String aMeal, String aUpdate) {
        resturantName = resName;
        meal = aMeal;
        update = aUpdate;
    }

    public Menu(String resName, String aMeal, String aUpdate, ArrayList<MenuItem> aMenuList) {
        this(resName, aMeal, aUpdate);
        menuList = aMenuList;
    }

    public void setMeal(String aMeal) { meal = aMeal; }

    public void setUpdate(String aUpdate) { update = aUpdate; }

    public void addItems(MenuItem aItem) {
        if (!menuList.contains(aItem.getName())) {
            menuList.add(aItem);
            System.out.println("Item added!");
        } else {
            System.out.println("The item is already in the menu.");
        }

    }

    public String getResturantName() {return resturantName; }

    public String getMeal() { return meal; }

    public String getUpdate() { return update; }

    public ArrayList<MenuItem> getItems() { return menuList; }
}
