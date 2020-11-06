package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodCompany {
    protected List<Restaurant> restaurant_list;
    protected List<Customer> customer_list;
    private float AccountBalance = 0;
    private int DeliveryCharges = 0;
    public FoodCompany(){
        this.restaurant_list = new ArrayList<Restaurant>();
        this.customer_list = new ArrayList<Customer>();
    }
    public void enter(){
        System.out.println("Welcome to Zotato. ");
        System.out.println("1. Enter as Restaurant Owner");
        System.out.println("2. Enter as Customer");
        System.out.println("3. Check User Details. ");
        System.out.println("4. Company Account Details. ");
        System.out.println("5. Exit");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        if (a  == 1){ displayRestaurantList();}
        else if (a == 2){ displayCustomerList();}
        else if (a == 3){checkUserDetails();}
        else if (a == 4){displayCompanyAccountDetails();}
        else {return; }
        enter();
    }
    public void printRestaurantLst(){
        System.out.println("Choose Restaurant. ");
        for (Restaurant tuptup: restaurant_list){
            tuptup.printDetails();
        }
        Scanner scan = new Scanner(System.in);
        int RestaurantUser = scan.nextInt();
        Restaurant Restaurant_p;
        Restaurant_p = new Restaurant("", 0);
        for (Restaurant gupshup: restaurant_list){
            if (gupshup.getId() == RestaurantUser){
                Restaurant_p = gupshup;
                break;
            }
        }
    }
    public void displayRestaurantList(){
        System.out.println("Choose Restaurant. ");
        for (Restaurant tuptup: restaurant_list){
            tuptup.printDetails();
        }
        Scanner scan = new Scanner(System.in);
        int RestaurantUser = scan.nextInt();
        Restaurant Restaurant_p;
        Restaurant_p = new Restaurant("", 0);
        for (Restaurant gupshup: restaurant_list){
            if (gupshup.getId() == RestaurantUser){
                Restaurant_p = gupshup;
                break;
            }
        }
        if (!Restaurant_p.getName().equals("")){
        Restaurant_p.enter();}

    }
    public void displayCustomerList(){
        for (Customer tuptup: customer_list){
            tuptup.printDetails();
        }
        Scanner scan = new Scanner(System.in);
        int CustomerUser = scan.nextInt();
        Customer Customer_p = new Customer("", "", this);
        for (Customer gupshup: customer_list){
            if (gupshup.getId() == CustomerUser){
                Customer_p = gupshup;
                break;
            }
        }
        if (!Customer_p.getName().equals("")){
            Customer_p.enter();
        }
    }
    public void checkUserDetails(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1) Customer List");
        System.out.println("2) Restaurant List");
        int a = scan.nextInt();
        if (a == 1){
            for (Customer lup: customer_list){
                lup.printDetails();
                System.out.println(lup.getWallet());
            }
            int s = scan.nextInt();
            for (Customer lup: customer_list){
                if (lup.getId() == s){
                    lup.printDetails();
                    System.out.println(lup.getRewardsAccount());
                }
            }
        }
        else{
            for (Restaurant lup: restaurant_list){
                lup.printDetails();
            }
            int s = scan.nextInt();
            for (Restaurant lup: restaurant_list){
                if (lup.id == s){
                    lup.printDetails();
                    System.out.println(lup.rewardPoints);
                }
            }
        }
    }
    public void displayCompanyAccountDetails(){
        System.out.println("Total Company Balance: " + this.AccountBalance);
        System.out.println("Total Delivery Charges Collected: " + this.DeliveryCharges);
    }
    public  List<Restaurant> getRestaurantList(){
        return restaurant_list;
    }

    public void setAccountBalance(float accountBalance) {
        AccountBalance = accountBalance;
    }
    public float getAccountBalance(){
        return this.AccountBalance;
    }
    public void setDeliveryCharges(int deliveryCharges){
        this.DeliveryCharges = deliveryCharges;

    }
    public int getDeliveryCharges(){
        return this.DeliveryCharges;
    }
}
