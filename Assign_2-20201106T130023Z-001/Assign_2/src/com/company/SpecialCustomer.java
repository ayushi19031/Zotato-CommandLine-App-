package com.company;

public class SpecialCustomer extends Customer{
    int delivery_charge = 20;
    public SpecialCustomer(String name, String address, FoodCompany accountBalance) {
        super(name, address, accountBalance);
    }

    @Override
    public void printDetails() {
        System.out.println(getId() + ") " + getName() + " (Special)");
    }

    @Override
    public int getDeliveryCharges() {
        return 20;
    }
}
