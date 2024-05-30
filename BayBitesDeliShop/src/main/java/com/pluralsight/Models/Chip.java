package com.pluralsight.Models;

public class Chip extends Product
{
    private String chipName;

    public Chip(String nameOfProduct, String chipName)
    {
        super(nameOfProduct, 1.50);
        this.chipName = chipName;
    }

    @Override
    public double calculateTotalPrice()
    {
        return super.getBasePrice();
    }
}
