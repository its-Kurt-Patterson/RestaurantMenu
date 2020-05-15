package com.restaurant;

public class Main {

    public static void main(String[] args) {
        //declare and initialize Menu
        Menu restaurantMenu = new Menu();

        //declare and initialize MenuItems
        MenuItem theGiantPizza = new MenuItem("The Giant Pizza", 29.99, "Our famous 22 lbs. pizza topped with the works!", "main course");
        MenuItem fishTaco = new MenuItem("Fish Taco", 3.95);
        MenuItem chocolateCake = new MenuItem("Chocolate Cake", 6.99, "dessert");

        //use Menu methods to add the initialized MenuItems to the Menu object
        restaurantMenu.addItem(theGiantPizza);
        restaurantMenu.addItem(fishTaco);
        restaurantMenu.addItem(chocolateCake);
        restaurantMenu.removeItem(chocolateCake);

        //print to the console the newly created menu
        System.out.println(restaurantMenu);
    }
}
