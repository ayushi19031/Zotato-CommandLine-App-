package com.company;

public class AuthenticRestaurant extends Restaurant{
    public AuthenticRestaurant(String name, int k) {
        super(name, k);
    }
    public void printDetails(){
        System.out.println(this.id + ") " + this.name + " " + "(Authentic )");
    }

    @Override
    public void addRewardPoints(Customer customer, float money) {

        customer.setRewardsAccount(customer.getRewardsAccount() + ((int) money/200)*25);
        this.rewardPoints += ((int) (money)/200)*25;
        System.out.println("Reward Points given to Authentic Restaurant: " + this.name+ ": " + this.rewardPoints + " " + money);
    }

    public float discountMe(float payment){
        float k = payment;
        k = (float) (payment*(1 - (0.01)*offer));
        if (k >= 50) {k -= 50;}
        return k;
    }
}
