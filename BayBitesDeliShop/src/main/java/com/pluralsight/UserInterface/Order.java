package com.pluralsight.UserInterface;

import com.pluralsight.Models.Chip;
import com.pluralsight.Models.Drink;
import com.pluralsight.Models.Sandwich;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order
{
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chip> chips;

    public Order(List<Sandwich> sandwiches, List<Drink> drinks, List<Chip> chips)
    {
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
    }

    public List<Sandwich> getSandwiches()
    {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches)
    {
        this.sandwiches = sandwiches;
    }

    public List<Drink> getDrinks()
    {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks)
    {
        this.drinks = drinks;
    }

    public List<Chip> getChips()
    {
        return chips;
    }

    public void setChips(List<Chip> chips)
    {
        this.chips = chips;
    }

}