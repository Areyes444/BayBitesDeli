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
    private List<String> sides;

    public Sandwich(String nameOfProduct, int sandwichSize, boolean extraMeats, boolean extraCheese)
    {
        super(nameOfProduct,0);
        this.sandwichSize = sandwichSize;
        this.breadTypes = new ArrayList<>();
        this.meatTypes = new ArrayList<>();
        this.cheeseTypes = new ArrayList<>();
        this.extraMeats = extraMeats;
        this.extraCheese = extraCheese;
        //creating arrays of toppings, sauces, and sides since they are included and no need to calculate
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.sides = new ArrayList<>();
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
        double baseMeatPrice = meatBasePrices.getOrDefault(sandwichSize, 0.00);
        double baseCheesePrice = cheeseBasePrices.getOrDefault(sandwichSize, 0.00);
        totalPrice += baseMeatPrice + baseCheesePrice;

        //with extra meat and cheese total the += adding everything from right and equaling
        totalPrice += extraCheese ?  extraCheesePrices.get(sandwichSize) : 0.0;
        totalPrice += extraMeats ? extraMeatPrices.get(sandwichSize) : 0.00;

        return totalPrice;

    }
}
