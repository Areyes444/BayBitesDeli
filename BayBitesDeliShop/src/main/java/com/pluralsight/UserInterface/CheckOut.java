package com.pluralsight.UserInterface;
import com.pluralsight.Models.Chip;
import com.pluralsight.Models.Drink;
import com.pluralsight.Models.Sandwich;

import java.util.*;

public class CheckOut
{
    private static Scanner userInput = new Scanner(System.in);

    public void run()
    {
        displayHomeScreen();
    }



    public void displayHomeScreen()
    {
        System.out.println("*".repeat(10) + "Bay Bites Deli Shop" + "*".repeat(10));
        String input;
        int choice = -1;
        while (choice !=0)
        {
            try{
                System.out.println();
                System.out.println("1) New Order");
                System.out.println("0) Exit the Application");
                System.out.print("Enter your choice: ");
                input = userInput.nextLine().strip();
                choice = Integer.parseInt(input);
                switch (choice)
                {
                    case 1:
                        startNewOrder();
                        break;
                    case 0:
                        System.out.println("GoodBye, exiting the Application");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input.Please enter a valid option.");
                }

            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid option.");

            }
        }
    }

    private void startNewOrder()
    {
        List<Sandwich> sandwiches = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        List<Chip> chips = new ArrayList<>();


        int choice = -1;
        while (choice !=0)
        {
            try{
                System.out.println("---------------Start New Order ---------------");
                System.out.println("1) Add Sandwich ");
                System.out.println("2) Add Drink ");
                System.out.println("3) Add Chips ");
                System.out.println("4) Checkout ");
                System.out.println();
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(userInput.nextLine().strip());

                switch (choice)
                {
                    case 1:
                        addSandwiches(sandwiches);
                        break;
                    case 2:
                         addDrink(drinks);
                        break;
                    case 3:
                        addChips(chips);
                        break;
                    case 4:
                        addcheckOut(sandwiches,drinks,chips);
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");

            }

        }

    }

    public void addSandwiches(List<Sandwich> sandwiches)
    {
        boolean addAnotherSandwich = true;


        while (addAnotherSandwich) {
            Sandwich sandwich = new Sandwich(0, new ArrayList<>(), new ArrayList<>(), false, new ArrayList<>(), false,
                    new ArrayList<>(), new ArrayList<>(), false, new ArrayList<>());
            System.out.println("--------------- Let's Customize Your Sandwich ---------------");


            System.out.println("Hello, please select what Sandwich size you would like: ");
            System.out.println("1) 4 inches");
            System.out.println("2) 8 inches");
            System.out.println("3) 12 inches");
            System.out.print("Enter your choice: ");
            int sizeChoice = CheckOut.userInput.nextInt();
            CheckOut.userInput.nextLine();

            if (sizeChoice < 1 || sizeChoice > 3) {
                System.out.println("Invalid choice. Please select a valid sandwich size.");
                continue;
            }

            int sandwichSize = (sizeChoice == 1) ? 4 : ((sizeChoice == 2) ? 8 : 12);
            sandwich.setSandwichSize(sandwichSize);

            //displaying bread choices
            System.out.println("Choose your bread:");
            List<String> breadTypes = sandwich.getBreadTypes();
            for (int i = 0; i < breadTypes.size(); i++) {
                System.out.println((i + 1) + ". " + breadTypes.get(i));
            }
            System.out.print("Enter the number for your choice: ");
            int breadChoice = userInput.nextInt();
            userInput.nextLine();  // Consume newline

            if (breadChoice < 1 || breadChoice > breadTypes.size()) {
                System.out.println("Invalid choice. Please select a valid bread type.");
                continue;
            }
            sandwich.addBreadType(breadTypes.get(breadChoice - 1));


            // displaying meat choices
            System.out.println("Choose your Meat/Tofu: ");
            List<String> meatTypes = sandwich.getMeatTypes();
            for (int i = 0; i < meatTypes.size(); i++) {
                System.out.println((i + 1) + ". " + meatTypes.get(i));
            }

            // Asking user for choice of meat
            System.out.print("Enter the number of your choice: ");
            String meatChoiceStr = CheckOut.userInput.nextLine();
            try {
                int meatChoice = Integer.parseInt(meatChoiceStr);
                if (meatChoice < 1 || meatChoice > meatTypes.size()) {
                    System.out.println("Invalid Choice. Please select a valid meat/tofu choice.");
                    continue;
                }

                String selectedMeat = meatTypes.get(meatChoice - 1);
                sandwich.addMeatType(selectedMeat);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }


            //Asking user for extrameat
            System.out.print("Would you like extra Meat/Tofu? (yes/no): ");
            String extraMeatChoice = CheckOut.userInput.nextLine().toLowerCase();
            sandwich.setExtraMeats(extraMeatChoice.equals("yes"));

            //Asking user what type of cheese they would like
            System.out.println("Choose your cheese:");
            for (int i = 0; i < sandwich.getCheeseTypes().size(); i++) {
                System.out.println((i + 1) + ". " + sandwich.getCheeseTypes().get(i));
            }
            System.out.print("Enter the number for your choice: ");
            int cheeseChoice = CheckOut.userInput.nextInt();
            CheckOut.userInput.nextLine();
            sandwich.addCheeseType(sandwich.getCheeseTypes().get(cheeseChoice - 1));

            //Asking user if they want extraCheese
            System.out.print("Do you want extra Cheese? (yes/no): ");
            String extraCheeseChoice = CheckOut.userInput.nextLine().toLowerCase();
            sandwich.setExtraCheese(extraCheeseChoice.equals("yes"));

            //Asking user what type of toppings they would like
            System.out.println("Choose your toppings: ");
            for (int i= 0; i < sandwich.getToppings().size(); i++){
                System.out.println((i + 1) + "." + sandwich.getToppings().get(i));
            }
            System.out.print("Enter the numbers for your choice (comma-separated): ");
            String[] toppingChoices = CheckOut.userInput.nextLine().split(",");
            for (String choice : toppingChoices) {
                int toppingChoice = Integer.parseInt(choice.trim());
                sandwich.addTopping(sandwich.getToppings().get(toppingChoice - 1));
            }

            //Asking user what kind of sauces they have
            System.out.println("Choose your sauces:");
            for (int i = 0; i < sandwich.getSauces().size(); i++) {
                System.out.println((i + 1) + ". " + sandwich.getSauces().get(i));
            }
            System.out.print("Enter the numbers for your choice of sauces please (comma-separated): ");
            String[] sauceChoices = CheckOut.userInput.nextLine().split(",");
            for (String choice : sauceChoices) {
                int sauceChoice = Integer.parseInt(choice.trim());
                sandwich.addSauce(sandwich.getSauces().get(sauceChoice - 1));
            }

            //Asking user if they want their sandwich toasted
            System.out.print("Do you want your Sandwich Toasted? (yes/no): ");
            String toastedChoice = CheckOut.userInput.nextLine().toLowerCase();
            sandwich.setToasted(toastedChoice.equals("yes"));

            //Asking user if they want any sides for free
            for (int i = 0; i < sandwich.getSides().size(); i++){
                System.out.println((i + 1) + "." + sandwich.getSides().get(i));
            }
            System.out.print("Enter the numbers for your side choices please (comma-separated): ");
            String[] sideChoices = CheckOut.userInput.nextLine().split(",");
            for (String choice : sideChoices) {
                int sideChoice = Integer.parseInt(choice.trim());
                sandwich.addSide(sandwich.getSides().get(sideChoice - 1));
            }

            //Add sandwich in a arrayList
            sandwiches.add(sandwich);

            //Asking user if they would like to add another sandwich

            System.out.print("Do you want to add another sandwich? (yes/no): ");
            String addAnotherChoice = CheckOut.userInput.nextLine().toLowerCase();
            while (!addAnotherChoice.equalsIgnoreCase("yes") && !addAnotherChoice.equalsIgnoreCase("no"))
            {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                addAnotherChoice = CheckOut.userInput.nextLine().toLowerCase();
            }
            addAnotherSandwich = addAnotherChoice.equals("yes");
        }
    }

    public void addDrink(List<Drink> drinks)
    {
        boolean addAnotherDrink = true;

        while (addAnotherDrink)
        {
            System.out.println("--------------- Add A Drink ---------------");
            Drink drink = new Drink("", "");


            //Displaying drink options

            System.out.println("Choose your drink: ");
            List<String> drinkFlavors = drink.getDrinkFlavors();
            for (int i = 0; i < drink.getDrinkFlavors().size(); i++)
            {
                System.out.println((i + 1) + "." + drink.getDrinkFlavors().get(i));
            }

            //Asking user for their choice
            System.out.print("Enter your choice: ");
            int flavorChoice = CheckOut.userInput.nextInt();
            CheckOut.userInput.nextLine();

            if(flavorChoice < 1 || flavorChoice > drinkFlavors.size())
            {
                System.out.println("Error. Please select a valid drink Flavor.");
                return;
            }
            String selectedFlavor = drinkFlavors.get(flavorChoice - 1);


            //Asking user for drink size
            System.out.println("Choose your drink size: ");
            int index = 1;
            for (String size: Drink.getDrinkPrices().keySet())
            {
                System.out.println(index + "." + size);
                index++;
            }
            System.out.print("Enter the size of your choice: ");
            int sizeChoice = Integer.parseInt(CheckOut.userInput.nextLine());

            if (sizeChoice < 1 || sizeChoice > Drink.getDrinkPrices().size()) {
                System.out.println("Invalid choice. Please select a valid drink size. ");
                return;
            }

            String size = null;

            for (String key : Drink.getDrinkPrices().keySet()) {
                if (index == sizeChoice) {
                    size = key;
                    break;
                }
                index++;
            }

            Drink newDrink = new Drink(selectedFlavor, size);
            drinks.add(newDrink);

            System.out.print("Do you want to add another drink? (yes/no): ");
            String addAnotherChoice = CheckOut.userInput.nextLine().toLowerCase();
            while (!addAnotherChoice.equalsIgnoreCase("yes") && !addAnotherChoice.equalsIgnoreCase("no")) {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                addAnotherChoice = CheckOut.userInput.nextLine().toLowerCase();
            }
            addAnotherDrink = addAnotherChoice.equals("yes");


        }



    }



    public void addChips(List<Chip> chips) {
        boolean addAnotherChip = true;

        while (addAnotherChip) {
            System.out.println("--------------- Add Chips ---------------");
            Chip chip = new Chip("");


            // Display chip options
            System.out.println("Choose your chip: ");
            List<String> chipFlavors = chip.getChipTypes();
            for (int i = 0; i < chipFlavors.size(); i++) {
                System.out.println((i + 1) + "." + chipFlavors.get(i));
            }

            // Asking user for their choice
            System.out.print("Enter your choice: ");
            int flavorChoice = CheckOut.userInput.nextInt();
            CheckOut.userInput.nextLine();

            if (flavorChoice < 1 || flavorChoice > chipFlavors.size()) {
                System.out.println("Error. Please select a valid chip flavor.");
                return;
            }
            String selectedFlavor = chipFlavors.get(flavorChoice - 1);

            // Adding the chip to the ArrayList
            Chip newchip = new Chip(selectedFlavor);
            chips.add(newchip);

            // Asking user if they would like to add another chip
            System.out.print("Do you want to add another chip? (yes/no): ");
            String addAnotherChoice = userInput.nextLine().toLowerCase();
            while (!addAnotherChoice.equalsIgnoreCase("yes") && !addAnotherChoice.equalsIgnoreCase("no")) {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                addAnotherChoice = userInput.nextLine().toLowerCase();
            }
            addAnotherChip = addAnotherChoice.equals("yes");
        }
    }

    public void addcheckOut(List<Sandwich> sandwiches, List<Drink> drinks, List<Chip> chips)
    {
        if (sandwiches.isEmpty() || drinks.isEmpty() || chips.isEmpty()) {
            System.out.println("Cannot proceed with checkout. One or more lists is empty.");
            return;
        }
        Order order = new Order(sandwiches, drinks, chips);
        order.setSandwiches(sandwiches);
        order.setDrinks(drinks);
        order.setChips(chips);
        //displaying the receipt/order details
        order.generateReceipt(new Date(),sandwiches,drinks,chips);

        //will ask user if they want it and confirm it or if not it will be cancelled
        System.out.print("Would you like to confirm the order? (yes/no): ");
        String confirmedChoice = CheckOut.userInput.nextLine().toLowerCase();

        if (confirmedChoice.equals("yes"))
        {

            System.out.println("You're order has been Confirmed. ");
            //once complete the user will be directed to HomeScreen
            displayHomeScreen();
        } else if (confirmedChoice.equals("no")) {
            //will cancel order
            System.out.println("You're order has been cancelled bye.");
            order.getChips().clear();
            order.getSandwiches().clear();
            order.getChips().clear();
            //redirecting user to home screen
            displayHomeScreen();

        }else {
            System.out.println("Invalid input. Please enter either 'yes' or 'no'.");
            addcheckOut(sandwiches, drinks, chips);
        }
    }

}
