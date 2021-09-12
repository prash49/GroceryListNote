package com.javamasterclassprogram;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice");
            System.out.println("Enter 0 to view choice list");
            choice = scanner.nextInt();
            // to clear the buffer
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\n Press");
        System.out.println("\t 0 - To print choice  options");
        System.out.println("\t 1 - To print list of grocery items");
        System.out.println("\t 2 - to add item to the list");
        System.out.println("\t 3 - to modify item in the list");
        System.out.println("\t 4 - to remove item from the list");
        System.out.println("\t 5 - to search the item in the list");
        System.out.println("\t 6 - to quit the application");
        System.out.println("\t 7 - to copy grocery arraylist to another arraylist ");
    }

    public static void addItem() {
        System.out.print("Please enter the grocery item");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Enter item number");
        int itemNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter replacement item");
        String newItem = scanner.nextLine();
        // -1 beacuse we starting counting from 1 not from zero but internally it was from 0 soo..
        groceryList.modifyGroceryItem(itemNumber - 1, newItem);
    }

    public static void removeItem() {
        System.out.print("Enter item number");
        int itemNumber = scanner.nextInt();
        scanner.nextLine();
        groceryList.removeGroceryItem(itemNumber);
    }

    public static void searchItem() {
        System.out.println("Enter search item");
        String searchItem = scanner.nextLine();
        if (groceryList.findItem(searchItem) != null) {
            System.out.println("fount the" + searchItem + " in the list");
        } else {
            System.out.println(searchItem + "  is not found");
        }
    }
    public static void processArrayList(){
        // crreating a new arraylist to store
        ArrayList<String> newList = new ArrayList<String>();
        // without using for loop (creating a getter method for GroceryList
        newList.addAll(groceryList.getGroceryList());
        //or
        ArrayList<String> newArrayList = new ArrayList<String>(groceryList.getGroceryList());
    }
}
