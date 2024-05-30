package com.pluralsight.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionFileManager
{
    public static void saveTransaction(Sandwhich sandwhich, String cashiersName, boolean wantChips, boolean wantDrink)
    {
        String deliShopName = "Bay Bites Deli Shop";
        File directory = new File("file/receipts.csv");
        if(!directory.exists()){
            directory.mkdirs();
        }
        String fileName = generateFileName();
        File file = new File(directory, fileName);

        try(
                FileWriter fileWriter = new FileWriter(file);
            PrintWriter writer = new PrintWriter(fileWriter)
        )
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timeStamp = dateFormat.format(new Date());

            writer.printf("Deli Shop: %s | Cashier: %s | Time: %s\n", deliShopName, cashierName, timestamp);
            writer.println("Sandwich Details:");
            writer.printf("Name: %s\n", sandwich.getNameOfProduct());
            writer.printf("Size: %d inches\n", sandwich.getSandwichSize());
            writer.printf("Extra meats: %s\n", sandwich.isExtraMeats() ? "Yes" : "No");
            writer.printf("Extra cheese: %s\n", sandwich.isExtraCheese() ? "Yes" : "No");
            writer.printf("Toppings: %s\n", String.join(", ", sandwich.getToppings()));
            writer.printf("Sauces: %s\n", String.join(", ", sandwich.getSauces()));
            writer.printf("Sides: Chips: %s, Drink: %s\n", wantChips ? "Yes" : "No", wantDrink ? "Yes" : "No");
            writer.printf("Total Price: $%.2f\n\n", sandwich.calculateTotalPrice());

            System.out.println("Transaction details saved to file: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());

        }
    }
    private static String generateFileName()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
        return "order_" + timestamp + ".txt";
    }

}
