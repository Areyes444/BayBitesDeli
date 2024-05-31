package com.pluralsight.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sandwich extends Product
{
    private int sandwichSize;
    private List<String> breadTypes;
    private List<String> meatTypes;
    private List<String> cheeseTypes;
    private boolean extraMeats;
    private boolean extraCheese;
    private List<String> toppings;
    private List<String> sauces;
    private boolean toasted;
    private List<String> sides;

    public Sandwich( int sandwichSize, List<String> breadTypes, List<String> meatTypes, boolean extraMeats,
                     List<String> cheeseTypes, boolean extraCheese, List<String> toppings, List<String> sauces,
                     boolean toasted, List<String> sides)
    {
        super(0);
        this.sandwichSize = sandwichSize;

        //created the breads,meats, cheese, toppings, sauce and sides array just to call to checkout class
        this.breadTypes = new ArrayList<>();
        this.breadTypes.add("White bread");
        this.breadTypes.add("Wheat bread");
        this.breadTypes.add("Rye bread");
        this.breadTypes.add("Multigrain bread");
        this.breadTypes.add("Wrap");

        this.meatTypes = new ArrayList<>();
        this.meatTypes.add("Steak");
        this.meatTypes.add("Ham");
        this.meatTypes.add("Salami");
        this.meatTypes.add("Roast beef");
        this.meatTypes.add("Chicken");
        this.meatTypes.add("Bacon");
        this.meatTypes.add("Tofu");

        this.cheeseTypes = new ArrayList<>();
        this.cheeseTypes.add("American");
        this.cheeseTypes.add("Provolone");
        this.cheeseTypes.add("Cheddar");
        this.cheeseTypes.add("Swiss");
        this.cheeseTypes.add("Plant Based");

        this.extraMeats = extraMeats;
        this.extraCheese = extraCheese;
        this.toasted = toasted;

        this.toppings = new ArrayList<>();
        this.toppings.add("Lettuce");
        this.toppings.add("Peppers");
        this.toppings.add("Onions");
        this.toppings.add("Tomatoes");
        this.toppings.add("Jalapenos");
        this.toppings.add("Cucumbers");
        this.toppings.add("Pickles");
        this.toppings.add("Guacamole");
        this.toppings.add("Mushrooms");

        this.sauces = new ArrayList<>();
        this.sauces.add("Mayo");
        this.sauces.add("Mustard");
        this.sauces.add("Ketchup");
        this.sauces.add("Ranch");
        this.sauces.add("Thousand Islands");
        this.sauces.add("Vinaigrette");
        this.sauces.add("BBQ");

        this.sides = new ArrayList<>();
        this.sides.add("Au Jus");
        this.sides.add("Sauce");
        this.sides.add("Napkins");
        this.sides.add("Utensils");
    }

    public int getSandwichSize()
    {
        return sandwichSize;
    }

    public void setSandwichSize(int sandwichSize)
    {
        this.sandwichSize = sandwichSize;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public boolean isExtraCheese()
    {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese)
    {
        this.extraCheese = extraCheese;
    }

    public boolean isExtraMeats()
    {
        return extraMeats;
    }

    public void setExtraMeats(boolean extraMeats)
    {
        this.extraMeats = extraMeats;
    }

    public List<String> getBreadTypes()
    {
        return breadTypes;
    }

    public void addBreadType(String breadType)
    {
        breadTypes.add(breadType);

    }

    public void addMeatType(String meatType)
    {
        meatTypes.add(meatType);
    }

    public List<String> getMeatTypes()
    {
        return meatTypes;
    }

    public void addCheeseType(String cheeseType)
    {
        cheeseTypes.add(cheeseType);
    }

    public List<String> getCheeseTypes()
    {
        return cheeseTypes;
    }

    public void addTopping(String topping)
    {
        toppings.add(topping);
    }

    public List<String> getToppings()
    {
        return toppings;
    }

    public void addSauce(String sauce)
    {
        sauces.add(sauce);
    }

    public List<String> getSauces()
    {
        return sauces;
    }

    public void addSide(String side)
    {
        sides.add(side);
    }

    public List<String> getSides()
    {
        return sides;
    }



    //creating hashMaps for each pricing for cheese and meats defining them
    private static final Map<Integer, Double> meatBasePrices = new HashMap<>();
    private static final Map<Integer, Double> cheeseBasePrices = new HashMap<>();
    private static final Map<Integer, Double> extraMeatPrices = new HashMap<>();
    private static final Map<Integer, Double> extraCheesePrices = new HashMap<>();

//Here we are initializing them and putting the sizes of sandwiches and the pricing
    static {
        meatBasePrices.put(4, 1.00);
        meatBasePrices.put(8, 2.00);
        meatBasePrices.put(12, 3.00);

        cheeseBasePrices.put(4, 0.75);
        cheeseBasePrices.put(8, 1.50);
        cheeseBasePrices.put(12, 2.25);

        extraMeatPrices.put(4, 0.50);
        extraMeatPrices.put(8, 1.00);
        extraMeatPrices.put(12, 1.50);

        extraCheesePrices.put(4, 0.30);
        extraCheesePrices.put(8, 0.60);
        extraCheesePrices.put(12, 0.90);
    }


    @Override
    public double calculateTotalPrice()
    {   //setting the total price to 0.00
        double totalPrice = 0.0;
        //getting the baseprice without no extra meat or cheesee
        double baseMeatPrice = getBaseMeatPrice(sandwichSize);
        double baseCheesePrice = getBaseCheesePrice(sandwichSize);
        totalPrice += baseMeatPrice + baseCheesePrice;

        //with extra meat and cheese total the += adding everything from right and equaling
        totalPrice += extraCheese ?  getExtraCheesePrice(sandwichSize) : 0.0;
        totalPrice += extraMeats ? getExtraMeatPrice(sandwichSize) : 0.00;

        return totalPrice;

    }
    private double getBaseMeatPrice(int size) {
        return getBasePrice(size, meatBasePrices);
    }

    private double getBaseCheesePrice(int size) {
        return getBasePrice(size, cheeseBasePrices);
    }

    private double getExtraMeatPrice(int size) {
        return getBasePrice(size, extraMeatPrices);
    }

    private double getExtraCheesePrice(int size) {
        return getBasePrice(size, extraCheesePrices);
    }

    private double getBasePrice(int size, Map<Integer, Double> priceMap) {
        return priceMap.getOrDefault(size, 0.0);
    }
}
