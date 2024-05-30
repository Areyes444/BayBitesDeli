package com.pluralsight.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drink extends Product
{
    private String drinkFlavor;
    private String size;

    public Drink(String nameOfProduct, String drinkFlavor, String size)
    {
        super(nameOfProduct, 0);
        this.drinkFlavor = drinkFlavor;
        this.size = size;
    }




    private static final Map<String, Double> drinkPrices = new HashMap<>();

    static{
        drinkPrices.put("Small", 2.00);
        drinkPrices.put("Medium", 2.50);
        drinkPrices.put("Large", 3.00);
    }





    @Override
    public double calculateTotalPrice()
    {
        return drinkPrices.getOrDefault(size, 0.00);
    }
}
