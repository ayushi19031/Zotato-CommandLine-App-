package com.company;

import java.util.Scanner;

public class FoodItem {
    protected static int idNo = 0;
    private int id;
    private String name;
    protected int price;
    protected int quantity;
    private String category;
    private int offer;
    protected Restaurant restaurant;
    public FoodItem(String name, int price, int quantity, String category, int offer){
        idNo += 1;
        this.id = idNo;
        this.name = name;
        this.price = price;
        this.quantity  = quantity;
        this.category = category;
        this.offer = offer;
    }
    public void setRestaurant(Restaurant r){
        this.restaurant = r;
    }
    public void printDetails(){
        System.out.println(id + ") " + name + " " + price + " " + quantity + " " + category + " " + offer + "% off. ");
    }
    public void edit(){
        System.out.println("Choose attribute to edit: ");
        System.out.println("1) Name: ");
        System.out.println("2) Price: ");
        System.out.println("3) Quantity: ");
        System.out.println("4) Category: ");
        System.out.println("5) Offer: ");
        Scanner scan = new Scanner(System.in);
        int att = scan.nextInt();
        if (att == 1){
            System.out.println("Enter the new name: ");
            String n = scan.nextLine();
            this.name = n;
            return ;
        }
        else if (att == 2){
            System.out.println("Enter new Price: ");
            int p = scan.nextInt();
            this.price = p;
        }
        else if (att == 3){
            System.out.println("Enter new Quantity: ");
            int q = scan.nextInt();
            this.quantity  = q;
        }
        else if (att == 4){
            System.out.println("Enter the new category: ");
            String c = scan.nextLine();
            this.category  = c;
        }
        else if (att == 5){
            System.out.println("Enter the new offer: ");
            int o = scan.nextInt();
            this.offer  = o;
        }
    }
    public int getID(){
        return this.id;
    }
    public int getOffer(){
        return this.offer;
    }

    public String getName() {
        return this.name;
    }
}
