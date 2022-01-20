package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class MenuItem {
    private String name;
    private Integer price;
    private String description;
    private String category;

    private final static String datePattern = "HH:mm zzz MM-dd-yyyy";
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
    private String update = dateFormat.format(new Date());

    public MenuItem(String aName) {
        name = aName;
    }
    public MenuItem(String aCatogory, String aName, Integer aPrice, String aDescription) {
        this(aName);
        category = aCatogory;
        price = aPrice;
        description = aDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItem)) return false;
        MenuItem menuItem = (MenuItem) o;
        return getName().equals(menuItem.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return getName() + "\t----------\t$" + getPrice() + " ("+getDescription()+") (updated on " + getUpdate() + ")\n";
    }

    public void setName(String aName) {
        name = aName;
    }

    public void setPrice(Integer aPrice) {
        price =  aPrice;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }

    public void setCatogory(String aCatogory) { category = aCatogory; }

    public void setUpdate() { update = dateFormat.format(new Date());; }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCatogory() { return category; }

    public String getUpdate() { return update; }
}

