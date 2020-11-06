package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Restaurant{
    protected int id;
    protected int offer;
    protected String name;
    protected int rewardPoints;
    protected HashMap<Integer, FoodItem> fooditems_list;
    protected ArrayList<FoodItem> foodItems_list;
    protected static int ID;
    public Restaurant(String name, int off){
        ID += 1;
        this.name = name;
        this.id = ID;
        this.offer = off;
        this.rewardPoints = 0;
        this.fooditems_list = new HashMap<>();
        this.foodItems_list = new ArrayList<>();
    }
    public void printDetails(){
        System.out.println(this.id + " " + this.name);
    }
    public void enter(){
        System.out.println("Welcome  " + this.name);
        System.out.println("1) Add item");
        System.out.println("2) Edit item");
        System.out.println("3) Print Rewards. ");
        System.out.println("4) Discount on bill value. ");
        System.out.println("5) Exit. ");
        Scanner scan = new Scanner(System.in);
        int IdRestaurant = scan.nextInt();
        if (IdRestaurant == 1){ addFoodItem();}
        else if (IdRestaurant == 2){editFoodItem();}
        else if (IdRestaurant == 3){ printRewardPoints();}
        else if (IdRestaurant == 4){ printOffer();}
        else{return; }
        enter();
    }
    public void  editFoodItem(){
        for (FoodItem gupshup: foodItems_list){
            gupshup.printDetails();
        }
        Scanner scan = new Scanner(System.in);
        int id_enter = scan.nextInt();
        FoodItem tobeChanged = fooditems_list.get(id_enter);
        tobeChanged.edit();
    }
    public void printOffer(){
        System.out.println("Offer on bill value: " + offer);
    }
    public void printRewardPoints(){
        System.out.println(this.rewardPoints);
    }
    public String getName(){
        return this.name;
    }
    public void addFoodItem(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter food item: ");
        String name_food = scan.nextLine();
        System.out.println("Price of Item: ");
        int price_of_item = Integer.parseInt(scan.nextLine());
        System.out.println("Item quantity: ");
        int quantity_of_item = Integer.parseInt(scan.nextLine());
        System.out.println("Item Category: ");
        String Item_category = scan.nextLine();
        System.out.println("Offer: ");
        int offer = Integer.parseInt(scan.nextLine());
        FoodItem food = new FoodItem(name_food, price_of_item, quantity_of_item, Item_category, offer);
        food.setRestaurant(this);
        fooditems_list.put(food.getID(), food);
        foodItems_list.add(food);
        food.printDetails();
    }
    public int getId(){
        return this.id;
    }
    public void printFoodItems(){
        for (FoodItem gup: this.foodItems_list){
            gup.printDetails();
        }
    }
    public void addRewardPoints(Customer customer, float money){
        customer.setRewardsAccount(customer.getRewardsAccount() + ((int) money/100)*5);
        this.rewardPoints += ((int) (money)/100)*5;
        System.out.println("Reward Points given to " + customer.getName() + ": " + customer.getRewardsAccount());
        System.out.println("Reward Points given to " + this.name + ": " + this.rewardPoints);
    }
    public void payFoodCompany(FoodCompany zotato, float pay){
        zotato.setAccountBalance((float) (zotato.getAccountBalance()+ pay *(0.01)));
    }

    public float discountMe(float payment){
        payment += 0;
        return payment;
    }
}
