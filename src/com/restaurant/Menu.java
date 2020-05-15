package com.restaurant;

import java.util.*;

public class Menu {

    //==========================================================================================
    //  Class Fields
    //==========================================================================================

    //initialize the nextMenuItem for organization
    private static Integer nextMenuId = 1;

    //declare an ArrayList to hold the menuItems
    private final ArrayList<MenuItem> items;

    //declare a field to hold the value of when the menu was last updated
    private Date lastUpdated;

    //declare a field to hold the menuId
    private int menuId;

    //==========================================================================================
    //  Class Constructors
    //==========================================================================================

    // default constructor for the Menu Class
    public Menu() {
        items = new ArrayList<>();
        lastUpdated = new Date();
        menuId = nextMenuId;
        nextMenuId++;
    }

    //==========================================================================================
    //  Class Methods
    //==========================================================================================

    //add an item to the menu
    public void addItem(MenuItem item) {
        items.add(item);
    }

    //remove an item from the menu
    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    //return all the items on the menu
    public ArrayList<MenuItem> getItems() {
        return items;
    }

    //return the date of the last time that the menu was updated
    public Date getLastUpdated() {
        return lastUpdated;
    }

    //convert the menu data into a string for the user
    public String toString() {
        String menuStr = "==== Menu ====\n";
        for (MenuItem item : items) {
            menuStr += item+"\n";
        }
        return menuStr;
    }

    //==========================================================================================
    //  Override Class Methods
    //==========================================================================================

    //override the equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return menuId == menu.menuId &&
                Objects.equals(items, menu.items) &&
                Objects.equals(lastUpdated, menu.lastUpdated);
    }

    //override the hashcode method, always recommended with overriding the equals method
    @Override
    public int hashCode() {
        return Objects.hash(items, lastUpdated, menuId);
    }
}
