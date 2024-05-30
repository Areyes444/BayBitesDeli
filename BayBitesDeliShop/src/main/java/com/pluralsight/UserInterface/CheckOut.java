package com.pluralsight.UserInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckOut
{
    private static Scanner userInput = new Scanner(System.in);

    public void displayHomeScreen()
    {
        System.out.println("*".repeat(10) + "Bay Bites Deli Shop" + "*".repeat(10));
        String input = "";
        int choice = -1;
        while (choice !=0)
        {
            try{
                System.out.println();
                System.out.println("1) New Order");
                System.out.println("0) Exit the Application");
                System.out.println("Enter your choice: ");
                input = userInput.nextLine().strip();
                choice = Integer.parseInt(input);
                switch (choice)
                {
                    case 1:
                        startNewOrder();
                        break;
                    case 0:
                        System.out.println("GoodBye, exiting the Application");
                        break;
                    default:
                        System.out.println("Invalid input.Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                userInput.nextLine();
                System.out.println("Invalid input. Please enter a valid option.");
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid option.");
            } catch (Exception e) {
                System.out.println("Something went wrong. Please try again.");
            }
        }
    }



}
