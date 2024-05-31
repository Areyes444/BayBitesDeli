package com.pluralsight.UserInterface;

import com.pluralsight.Models.Chip;
import com.pluralsight.Models.Drink;
import com.pluralsight.Models.Sandwich;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order
{
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chip> chips;

    public Order(List<Sandwich> sandwiches, List<Drink> drinks, List<Chip> chips)
    {
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
    }

    public List<Sandwich> getSandwiches()
    {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches)
    {
        this.sandwiches = sandwiches;
    }

    public List<Drink> getDrinks()
    {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks)
    {
        this.drinks = drinks;
    }

    public List<Chip> getChips()
    {
        return chips;
    }

    public void setChips(List<Chip> chips)
    {
        this.chips = chips;
    }

    public void generateReceipt(Date orderTime, List<Sandwich> sandwiches, List<Drink> drinks, List<Chip> chips) {
        String deliShopName = "Bay Bites Deli Shop";
        double totalOrderPrice = 0.0;

        // creating the heading of the receipt
        System.out.println();
        System.out.println("---------- Your Order ----------");

        // Writing the title
        System.out.println("---------- Order Details ----------");

        // Saving the CSV file with time stamp information
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String timeStamp = dateFormat.format(orderTime);
        String directoryPath = "files/";
        String fileName = directoryPath + "order_" + timeStamp + ".txt";

        // Making sure the receipts are added in the file; if the file doesn't exist, we are creating one
        try {
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            // Writing the information of the shop and the time on the receipt
            writer.write("Deli Shop: " + deliShopName + "\n");
            writer.write("Order Time: " + orderTime.toString() + "\n");

            // Creating a list for the Item and the price for each
            writer.write("------------ Ordered Items ----------\n");

            // Writing sandwich info
            for (Sandwich sandwich : sandwiches) {
                double sandwichPrice = sandwich.calculateTotalPrice();
                writer.write("Sandwich: " + sandwich.getNameOfProduct() + "," + sandwichPrice + "\n");
                totalOrderPrice += sandwichPrice;
            }

            // Writing drink info
            for (Drink drink : drinks) {
                double drinkPrice = drink.calculateTotalPrice();
                writer.write("Drink: " + drink.getNameOfProduct() + "," + drinkPrice + "\n");
                totalOrderPrice += drinkPrice;
            }

            // Writing chip information
            for (Chip chip : chips) {
                double chipPrice = chip.calculateTotalPrice();
                writer.write("Chip: " + chip.getNameOfProduct() + "," + chipPrice + "\n");
                totalOrderPrice += chipPrice;
            }

            // Writing the total price in receipt
            writer.write("Total Order Price: " + totalOrderPrice + "\n");

            writer.close();

            // Message once it is saved
            System.out.println("Order has been saved");
        } catch (IOException e) {
            System.out.println("Error occurred while saving order.");
        }
    }

}
