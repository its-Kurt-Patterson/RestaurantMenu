package com.restaurant;

import java.util.*;

public class MenuItem {

    //==========================================================================================
    //  Class Fields
    //==========================================================================================

    //the name of the menu item
    private String name;

    //the price of the menu item
    private Double price;

    //the description of the menu item
    private String description;

    //the category of the menu item, should be appetizer, main course, or dessert
    private String category;

    //the id of the menu item
    private Integer menuItemId;

    //the general value to add the next id to an added item
    private static Integer nextMenuItemId = 1;

    //the date that the item was added
    private final Date dateAdded;

    //set the required duration of a new item, does not change
    private static final int NEW_ITEM_DURATION_IN_DAYS = 7;

    //==========================================================================================
    //  Class Constructors
    //==========================================================================================

    //default constructor for the MenuItem Class given all data
    public MenuItem(String name, Double price, String description, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.dateAdded = new Date();
        this.menuItemId = nextMenuItemId;
        nextMenuItemId++;
    }

    //alternative constructor for the MenuItem given only the name, price, and category
    public MenuItem(String name, Double price, String category) {
        this(name, price, "", category);
    }

    //alternative constructor for the MenuItem given only the name and price
    public MenuItem(String name, Double price) {
        this(name, price, "", "main course");
    }

    //==========================================================================================
    //  Class Methods
    //==========================================================================================

    //check if an item should be displayed as a new item
    public Boolean isNewItem() {
        long rightNowInMs = new Date().getTime();
        long newItemDurationConvertedToMs = NEW_ITEM_DURATION_IN_DAYS *24*60*1000;
        return rightNowInMs - dateAdded.getTime() < newItemDurationConvertedToMs;
    }

    //convert item to string, and append "NEW" if isNewItem is truthy
    public String toString() {
        String itemString = this.name + " - $" + this.price + " (" + this.category +") ";
        if(isNewItem()) {
            itemString += " (NEW)";
        }
        return itemString;
    }

    //==========================================================================================
    //  Override Class Methods
    //==========================================================================================

    //override the equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(name, menuItem.name) &&
                Objects.equals(price, menuItem.price) &&
                Objects.equals(description, menuItem.description) &&
                Objects.equals(category, menuItem.category) &&
                Objects.equals(menuItemId, menuItem.menuItemId) &&
                Objects.equals(dateAdded, menuItem.dateAdded);
    }

    //override the hashcode method, always recommended with overriding the equals method
    @Override
    public int hashCode() {
        return Objects.hash(name, price, description, category, menuItemId, dateAdded);
    }
}
