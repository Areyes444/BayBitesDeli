package com.pluralsight.Models;

import java.util.ArrayList;
import java.util.List;

public class Chip extends Product
{
    private List<String> chipTypes;

    public Chip(String selectedFlavor)
    {
        super(1.50);
        chipTypes = new ArrayList<>();
        chipTypes.add("Classic Lay Chips");
        chipTypes.add("La Vick's Jalapeno Chips");
        chipTypes.add("Baked Hot Cheeto Chips");
        chipTypes.add("Barbecue chips");
        chipTypes.add("Sour cream and onion chips");
        chipTypes.add("Sun chips");
        chipTypes.add("Multigrain chips");

    }

    public void addChipType(String chipType)
    {
        chipTypes.add(chipType);
    }

    public List<String> getChipTypes()
    {
        return chipTypes;
    }


    @Override
    public double calculateTotalPrice()
    {
        return super.getBasePrice();
    }
}
