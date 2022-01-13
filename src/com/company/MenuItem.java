package com.company;

import java.util.HashMap;

public class MenuItem {
    private String name;
    private Integer price;
    private String soldOut;

    public MenuItem(String aName, Integer aPrice, String aSoldOut) {
        name = aName;
        price = aPrice;
        soldOut = aSoldOut;
    }

    public void setName(String aName) {
        name = aName;
    }

    public void setPrice(Integer aPrice) {
        price =  aPrice;
    }

    public void setSoldOut(String aSoldOut) {
        soldOut = aSoldOut;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getSoldOut() {
        return soldOut;
    }
}

