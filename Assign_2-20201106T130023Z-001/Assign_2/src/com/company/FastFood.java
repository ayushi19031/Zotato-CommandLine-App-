package com.company;

public class FastFood extends Restaurant{

    public FastFood(String name, int k) {
        super(name, k);
    }
    public void printDetails(){
        System.out.println(this.id + ") " + this.name + " " + "(FastFood)");
    }
    public void addRewardPoints(Customer customer, float money){
        customer.setRewardsAccount(customer.getRewardsAccount() + ((int) money/150)*10);
        this.rewardPoints += ((int)(money)/150)*10;
        System.out.println("Reward Points given to " + this.name + ": " + this.rewardPoints);
    }

    @Override
    public float discountMe(float payment) {
        float k = payment;
        k = (float) (payment*(1 - offer*(0.01)));
        if (k >= 25)k -= 25;
        return k;
    }
}
