package com.company;

public class EliteCustomer extends Customer {
    int delivery_charge = 0;

    public EliteCustomer(String name, String address, FoodCompany foodCompany) {
        super(name, address, foodCompany);
    }

    @Override
    public void printDetails() {
        System.out.println(getId() + ") " + getName() + " (Elite)");
    }

    @Override
    public int getDeliveryCharges() {
        return 0;
    }
}
