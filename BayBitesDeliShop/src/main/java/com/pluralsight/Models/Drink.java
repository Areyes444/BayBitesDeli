package com.pluralsight.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drink extends Product
{
    private List<String> drinkFlavors;
    private String size;

    public Drink(String flavor, String size)
    {
        super( 0);
        drinkFlavors = new ArrayList<>();
        drinkFlavors.add("Sprite");
        drinkFlavors.add("Fresh Lemonade");
        drinkFlavors.add("Fresh Ice Tea");
        drinkFlavors.add("Green Tea");
        drinkFlavors.add("Root Beer");
        drinkFlavors.add("Kombucha");
        drinkFlavors.add("Coconut Water");

        this.size = size;
    }

    public List<String> getDrinkFlavors()
    {
        return drinkFlavors;
    }

    public void addDrinkFlavor(String drinkFlavor)
    {
        drinkFlavors.add(drinkFlavor);
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }


    private static final Map<String, Double> drinkPrices = new HashMap<>();

    static{
        drinkPrices.put("Small", 2.00);
        drinkPrices.put("Medium", 2.50);
        drinkPrices.put("Large", 3.00);
    }

    public static Map<String, Double> getDrinkPrices()
    {
        return drinkPrices;
    }

    @Override
    public double calculateTotalPrice()
    {
        return drinkPrices.getOrDefault(size, 0.00);
    }
}
