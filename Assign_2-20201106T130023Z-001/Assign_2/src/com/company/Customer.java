package com.company;

import java.util.*;

public class Customer {
    private String name;
    private String address;
    private int id;
    private int res_rn  = -1;
    private ArrayList<String> last_ten_orders;
   // int deliveryCharges = 40;
    private static int ID = 0;

    private int rewardsAccount;
    private float wallet;
    private FoodCompany foodCompany;
    private List<FoodItem> Cart = new ArrayList<>();
    public Customer(String name, String address, FoodCompany foodCompany) {
        last_ten_orders = new ArrayList<>();
        ID += 1;
        this.name = name;
        this.address = address;
        this.rewardsAccount = 0;
        this.wallet = 1000;
        this.foodCompany = foodCompany;
        this.id = ID;
    }
    public int getId() {
        return id;
    }
    public String getName(){
        return this.name;
    }
    public void printDetails(){
        System.out.println(id + " " + name);
    }
    public void enter(){
        System.out.println("Welcome " + this.name);
        System.out.println("Customer Menu: ");
        System.out.println("1) Check Restaurant");
        System.out.println("2) Checkout Cart");
        System.out.println("3) Reward Won. ");
        System.out.println("4) Print the recent Orders. ");
        System.out.println("5) Exit: ");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        if (option == 1){
            RestaurantMenu();
        }
        else if (option == 2){
            checkOutCart();
        }
        else if (option == 3){
            System.out.println(this.rewardsAccount);
        }
        else if (option == 4){
            printMyRecentOrders();
        }
        else {Cart = new ArrayList<>(); return ;}
        enter();
    }
    public void printMyRecentOrders(){
        for (int i = last_ten_orders.size() - 1; i >= Math.max(last_ten_orders.size() - 10, 0); i--){
            System.out.println(last_ten_orders.get(i));
        }
    }
    public void RestaurantMenu(){
        List<Restaurant> restaurant_list = foodCompany.restaurant_list;
        for (Restaurant tup: restaurant_list){
            tup.printDetails();
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose restaurant ");
        int a = scan.nextInt();
        if ((res_rn == -1)){
            res_rn = a;
            Cart = new ArrayList<>();
        }
        else if (res_rn != a){
            res_rn = a;
            Cart = new ArrayList<>();
        }
        Restaurant Restaurant_order = new Restaurant("", 0);
        for (Restaurant gup: restaurant_list){
            if (gup.getId() == a){
                Restaurant_order = gup;
            }
        }
        if (!Restaurant_order.getName().equals("")){
            AddItemToCart(Restaurant_order);
        }
    }
    public void checkOutCart(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Items in Cart: ");
        StringBuilder string_future = new StringBuilder();
        if (Cart.size() != 0) {
            string_future.append(Cart.get(0).restaurant.name);
            for (FoodItem tup : Cart) {
                tup.printDetails();
                string_future.append(tup.getName());
            }
        }
    Payment_to_be_done();
        int a = scan.nextInt();
        if (a == 1){

            float payment = Payment_is_done();
            string_future.append(payment);
            String order = string_future.toString();
            last_ten_orders.add(order);
         //   hash = new HashMap<Restaurant, Float>();
            System.out.println(Cart.size() + " items successfully bought for " + payment);
            Cart = new ArrayList<>();
        }

    }
    public float Payment_to_be_done(){
        float aj = 0;
        for (FoodItem tup: Cart){
            float k = (float) ((float) tup.price*(1 - tup.getOffer()*0.01));
            System.out.println("K: " + k + " " + tup.price);
            aj += k;
        }
        float payment = 0;
        float discount_offered_by_restaurant = 0;
        Restaurant res = Cart.get(0).restaurant;
        float payk = res.discountMe(aj);
        payment += payk;
        System.out.println("Payment: " + payment);
        payment += getDeliveryCharges();
        System.out.println("Delivery Charges: "  + getDeliveryCharges());
        System.out.println("Total Payment: " + payment);
        return payment;

    }
    public float Payment_is_done(){
        Scanner scan = new Scanner(System.in);
        float aj = 0;
        for (FoodItem tup: Cart){
            float k = (float) ((float) tup.price*(1 - tup.getOffer()*0.01));
            System.out.println("K: " + k + " " + tup.price);
            aj += k;
        }
        float payment = 0;
        float discount_offered_by_restaurant = 0;
        Restaurant res = Cart.get(0).restaurant;
            float payk = res.discountMe(aj);


            payment += payk;

        payment += getDeliveryCharges();
        System.out.println("Delivery Charges: "  + getDeliveryCharges());
         boolean sup = deductMoney(payment);
            while (sup == false){
                for (FoodItem kup: Cart){
                    kup.printDetails();
                }
                System.out.println("Insuffiient Balance in your Account. Kindly enter id of food item you want to delete. ");
                int ajaj = Integer.parseInt(scan.nextLine());
                int jup = -1;
                int u = 0;
                for (FoodItem kup: Cart){
                    if (kup.getID() == ajaj){
                        jup = u;
                        break;
                    }
                    u += 1;
                }
                if (jup != -1){
                    Cart.remove(jup);
                }
                sup = deductMoney(Payment_to_be_done());
            }
            payment = Payment_to_be_done();
        foodCompany.setAccountBalance((float) (foodCompany.getAccountBalance() + (payment - getDeliveryCharges())*(0.01)));
        res.addRewardPoints(this, payment);
            foodCompany.setDeliveryCharges(foodCompany.getDeliveryCharges() + getDeliveryCharges());
            return payment;
        }
    public int getDeliveryCharges(){
    //    foodCompany.DeliveryCharges += 40;
        return 40;
    }
    public void AddItemToCart(Restaurant restaurant){
        restaurant.printFoodItems();
        System.out.println("Choose Item By Code. ");
        Scanner scan = new Scanner(System.in);
        int item_id = scan.nextInt();
        FoodItem food_ordered = restaurant.fooditems_list.get(item_id);

        System.out.println("Enter item quantity: ");
        int quantity = scan.nextInt();
        int del = getDeliveryCharges();
        OrdersOfCustomer order = new OrdersOfCustomer(food_ordered, restaurant, quantity, del);
        for (int i = 0; i < quantity; i++) {
            Cart.add(food_ordered);
        }

    }

    public boolean deductMoney(float payment){
        System.out.println(payment);
        if (this.rewardsAccount >= payment) {
            this.rewardsAccount -= payment;
            return true;
        }
           if (rewardsAccount <= payment && wallet >= payment - rewardsAccount) {payment -= rewardsAccount;rewardsAccount = 0;
            wallet -= payment;
            System.out.println(wallet);
            return true;}
            else{ return false;}
        }

    public int getRewardsAccount(){
        return this.rewardsAccount;
    }
    public void setRewardsAccount(int k){
        this.rewardsAccount = k;
    }
    public float getWallet(){
        return this.wallet;
    }
}

