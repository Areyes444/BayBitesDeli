package com.pluralsight.Models;

public abstract class Product
{
    private String nameOfProduct;
    private double basePrice;


    public Product(String nameOfProduct, double basePrice)
    {
        this.nameOfProduct = nameOfProduct;
        this.basePrice = basePrice;


    }

    public String getNameOfProduct()
    {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct)
    {
        this.nameOfProduct = nameOfProduct;
    }

    public double getBasePrice()
    {
        return basePrice;
    }

    public void setBasePrice(double basePrice)
    {
        this.basePrice = basePrice;
    }

   public abstract double calculateTotalPrice();
}
