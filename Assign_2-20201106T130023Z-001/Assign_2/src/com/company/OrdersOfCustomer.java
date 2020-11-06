package com.company;

public class OrdersOfCustomer {
    FoodItem food;
    Restaurant res;
    int q;
    float p;
    int del;
    public OrdersOfCustomer(FoodItem foodordered, Restaurant res, int quantity, int del){
        this.food = foodordered;
        this.res = res;
        this.q = quantity;
        this.del = del;
    }
    public void printDetails(){
        System.out.println("Bought: " + food.getName() + " quantity " + q +  "from Restaurant: " + res.getName() + "Delivery Charge: " + this.del);
    }
}
