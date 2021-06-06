/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.project;

/**
 *
 * @author shah1932
 */
public class Food {
    
    //The price that the banana strawberry smoothie will sell at
    int howMany;
    double subTotal;
    double totalCost;
    public double buyFood(int affect,String discount, double cost, double price){
        //This method will have the customer buy the food and will call another method that will calculate the profit, the total sold, and total cost
        //This method will also show how many smoothies were bought
        if (affect==1){
            howMany = (int)(Math.floor(Math.random()*3)+1);
        }
        else if(affect==2){
            howMany = (int)(Math.floor(Math.random()*6)+3);
        }
        else{
            howMany = (int)(Math.floor(Math.random()*10)+6);
        }
        if(discount.equals("Yes")){
            subTotal = howMany*price;
            double off=subTotal*.15;
            subTotal=subTotal-off;
        }else{
            subTotal = howMany*price;
        }
        totalCost = howMany*cost;
        double profit = Math.floor((subTotal-totalCost)*100)/100;//The Math.floor or Math.round is not working
//        setBank(subTotal,pay);
        return profit;
    }
    public double setBank(double pay){
        pay = Math.floor(((pay-subTotal)*100))/100;
        return pay;
    }
    public double getSubTotal(){
        subTotal = Math.floor(((subTotal)*100))/100;
        return subTotal;
    }
    public double getCost(){
        return totalCost;
    }
    public int getItemCount(){
        return howMany;
    }
}
