package com.pluralsight.TransactionManager;

import com.pluralsight.Models.Chip;
import com.pluralsight.Models.Drink;
import com.pluralsight.Models.Sandwich;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TransactionsFileManager
{
    public static void generateReceipt(Date orderTimeStamp, List<Sandwich> sandwiches, List<Drink> drinks, List<Chip> chips)
    {
        String deliShopName = "Bay Bites Deli Shop";

        // Saving the CSV file with time stamp information
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String timeStampString = dateFormat.format(orderTimeStamp);
        String fileName = "files" + timeStampString + ".txt";

        try {
            // Create the directory if it doesn't exist
            File directory = new File("files");
            if (!directory.exists()) {
                directory.mkdirs();
            }


            try {

                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

                // creating the heading of the receipt
                writer.write("---------- YOUR ORDER ---------\n");
                writer.write("Deli Shop: " + deliShopName + "\n");
                writer.write("Order Time: " + timeStampString + "\n");
                writer.write("---------- Order Summary ----------\n");

                //grabbing the information from the sandwiches
                List<Sandwich> sandwichList = sandwiches;
                double sandwichTotal = 0.0;
                for (Sandwich sandwich : sandwichList) {
                    double sandwichPrice = sandwich.calculateTotalPrice();
                    writer.write("Sandwich: "  + sandwichPrice + "\n");
                    sandwichTotal += sandwichPrice;
                }
                //getting drink information
                List<Drink> drinkList = drinks;
                double drinkTotal = 0.0;
                for (Drink drink : drinkList) {
                    double drinkPrice = drink.calculateTotalPrice();
                    writer.write("Drink: "  + drinkPrice + "\n");
                    drinkTotal += drinkPrice;
                }

                //getting chip information
                List<Chip> chipList = chips;
                double chipTotal = 0.0;
                for (Chip chip : chipList) {
                    double chipPrice = chip.calculateTotalPrice();
                    writer.write("Chip: " + chipPrice + "\n");
                    chipTotal += chipPrice;
                }

                writer.write("Total Sandwich Price: " + sandwichTotal + "\n");
                writer.write("Total Drink Price: " + drinkTotal + "\n");
                writer.write("Total Chip price: " + chipTotal + "\n");

                writer.close();
                System.out.println("Order receipt saved." + fileName);

            } catch (IOException e) {
                System.out.println("Error. let's try again.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }}