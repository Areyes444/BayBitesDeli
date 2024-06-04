# BayBitesDeli

###Project Summary
I made this Bay Bites Deli App for a cashier at the store. They are able to save the orders they get from Customers and have a receipt for every transaction saved by date and time. 

UML for each Package From the UserInterface, Models, and for the Transactions
![userInterface(Deli Workshop)](https://github.com/Areyes444/BayBitesDeli/assets/166452594/8b94f84e-c646-49a4-93fa-935da1c5e073)

![Models(Deli Workshop)](https://github.com/Areyes444/BayBitesDeli/assets/166452594/3ee4badd-cafb-4d96-ba42-d9c84b9bd654)

![files(Deli Workshop)](https://github.com/Areyes444/BayBitesDeli/assets/166452594/e02e9507-77d2-4ede-9f17-a3ca9c6fabc8)

##Home Screen

1)New Order

When the Cashier enters "1" they are able to start adding the customer's order

0) Exit the Application

When the Cashier enters "0" they are able to Exit the Application

![Home Screen(Deli WorkShop)](https://github.com/Areyes444/BayBitesDeli/assets/166452594/d88f9443-c92f-49f6-9f07-8e275ef571d7)

##Start New Order

The Cashier is able to choose from 4 options: 1)Add Sandwich, 2)Add Drink, 3)Add Chips, and 4)CheckOut

![Starting a new Order(Deli WorkShop)](https://github.com/Areyes444/BayBitesDeli/assets/166452594/de8b97c2-8a9d-44a1-bc07-1feb16506ba8)

##Customize A Sandwich

The Cashier is able to input the customers choice from different Sandwhich sizes.

![Customize Sandwich(Deli WorkShop)](https://github.com/Areyes444/BayBitesDeli/assets/166452594/d61376f2-54b0-4c5e-bd8d-7e2990d7178b)

The Cashier is able to input the choice of bread the customer would like. 

![Choose Bread(Deli WorkShop)](https://github.com/Areyes444/BayBitesDeli/assets/166452594/13ec6a12-2055-4694-843b-785ea88cc938)

The Cashier is able to input the Type Meat the customer would like and if they will like Extra meat.

![Choose Meat+ExtraMeat(Deli WorkShop)](https://github.com/Areyes444/BayBitesDeli/assets/166452594/aca7ce5a-6281-4d2f-a204-282786bfc62a)

The Cashier is able to then input what Type of cheese the customer they would like and if they would like extra Cheese

![Choose Cheese(Deli WorkShop)](https://github.com/Areyes444/BayBitesDeli/assets/166452594/317aed48-9ee2-4f13-afd1-e785b5911144)

The Cashier is able to to then input the customers Toppings of choice 

![Choose Toppings(Deli WorkShop)](https://github.com/Areyes444/BayBitesDeli/assets/166452594/340ddad1-bfdf-4a4b-801c-82801f177488)

The Cashier is able then to add sauces and any sides if the customer will like. Once the Cashier inputs all the customers choices and displays the sandwiches total price. It will give the option as well the customer would like to order another Sandwich and repeat that same order. 


![Choose sauces+sides(Deli WorkkShop)](https://github.com/Areyes444/BayBitesDeli/assets/166452594/27d35cf1-3457-429a-99ca-d1af3e305169)

##Add a Drink

The Cashier is able to add a drink for the Customer if they would like one. They are able to put the choice of Flavor, the drink size. Once those choices are made the Total Price will be displayed. The Cashier will be prompted a choice wether the customer will like anothe drink and will repeat those steps if needed. 

![Add A Drink(Deli WorkShop)](https://github.com/Areyes444/BayBitesDeli/assets/166452594/06dd05a7-57f2-494a-9284-4e1cdf84e2eb)

##Add Chips

The Cashier is able to add the Customer chips of their choice if they would like. The cashier will be prompted the choice to add extra chips into the order if the customer will like more chips. 

![Add Chips(Deli WorkShop)](https://github.com/Areyes444/BayBitesDeli/assets/166452594/6855a36e-0f95-4162-a74b-2b8ae398333a)

##CheckOut 

Once all the order has been input the cashier is able to checkout and confirm the order

![CheckOut(DeliWorkShop)](https://github.com/Areyes444/BayBitesDeli/assets/166452594/2a4e5de5-a209-4e2b-9027-7d98e9e394b8)

##Transaction File

I created a TransactionFileManager that is able to save each order to a file that is saved once the order has been checked out and confirmed. The code below shows how I was able to create each file and how it displays as a receipt. 

```java
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
        String fileName = "files/" + timeStampString + ".txt";

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
```



![Receipt saved(Deli WorkShop)](https://github.com/Areyes444/BayBitesDeli/assets/166452594/c65b7fe8-c51c-4c5d-8b9a-a6aa5f999285)
