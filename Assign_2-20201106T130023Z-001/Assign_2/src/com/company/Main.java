package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FoodCompany Zotato = new FoodCompany();
        Zotato.restaurant_list.add(new AuthenticRestaurant("Shah's ", 1));
        Zotato.restaurant_list.add(new Restaurant("Ravi's ", 0));
        Zotato.restaurant_list.add(new AuthenticRestaurant("Chinese ", 0));
        Zotato.restaurant_list.add(new FastFood("Wang's ", 0));
        Zotato.restaurant_list.add(new Restaurant("Paradise ", 0));
        Zotato.customer_list.add(new EliteCustomer("Sam", "New Delhi", Zotato));
        Zotato.customer_list.add(new EliteCustomer("Ram", "Indore", Zotato));
        Zotato.customer_list.add(new SpecialCustomer("Tim", "Chennai", Zotato));
        Zotato.customer_list.add(new Customer("Kim", "Kochi", Zotato));
        Zotato.customer_list.add(new Customer("Jim", "Kolkata", Zotato));
        Zotato.enter();
    }
}
