/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author shah1932
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label,item1Price,item2Price,item3Price,bank1,bank2,bank3,sold,totalSubTotal,totalCost,totalProfit,couponUsed;
    private double totProfit; 
    private double totCost;
    private double totalMade;
    private int itemCount;
    private int coupCount;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        double myCost = (Math.floor(Math.random()*2)+1);
        double price = myCost+2.99;
        int randHunger=(int)(Math.floor(Math.random()*3)+1);
        int x;
        int useCoupon;
        double money;
        int affect;
        int change;
        int season = (int)(Math.floor(Math.random()*4)+1);//1 represents winter, 2 represents Spring, 3 represents Summer, 4 represents Fall
        if(season==1){
            x=5;
            System.out.println("It is Winter!");
        }else if(season==2){
            x=10;
            System.out.println("It is Spring!");
        }else if(season==3){
            x=20;
            System.out.println("It is Summer!");
        }else{
            x=12;
            System.out.println("It is Fall!");
        }
        coupCount=0;
        String coupon;
        Person cust1 = new Person();
        Person cust2 = new Person();
        Person cust3 = new Person();
        money=(int)(Math.floor(Math.random()*10)+50);
        change=(int)(Math.floor(Math.random()*20)+1);
        bank1.setText(Double.toString(cust1.setMoney(money,change)));
        money=(int)(Math.floor(Math.random()*10)+50);
        change=(int)(Math.floor(Math.random()*20)+1);
        bank2.setText(Double.toString(cust2.setMoney(money,change)));
        money=(int)(Math.floor(Math.random()*10)+50);
        change=(int)(Math.floor(Math.random()*20)+1);
        bank3.setText(Double.toString(cust3.setMoney(money,change)));
        Food item1 = new Food();
        Food item2 = new Food();
        Food item3 = new Food();
        item1Price.setText(Double.toString(price));
        item2Price.setText(Double.toString(price));
        item3Price.setText(Double.toString(price));

        for(int custCount=0; custCount<x; custCount++){
            int who = (int)(Math.floor(Math.random()*3))+1;
            if(who==1){
                useCoupon=(int)(Math.floor(Math.random()*20)+1);
                money = cust1.setMoney(money,change);
                affect = cust1.manageHunger(randHunger,custCount);
                coupon = cust1.useCoupon(useCoupon);
                if(coupon.equals("Yes")){
                    coupCount++;
                }
            }else if(who==2){
                useCoupon=(int)(Math.floor(Math.random()*20)+1);
                money = cust2.setMoney(money,change);
                affect = cust2.manageHunger(randHunger,custCount);
                coupon = cust2.useCoupon(useCoupon);
                if(coupon.equals("Yes")){
                    coupCount++;
                }
            }else{
                money = cust3.setMoney(money,change);
                useCoupon=(int)(Math.floor(Math.random()*20)+1);
                affect = cust3.manageHunger(randHunger,custCount);
                coupon = cust3.useCoupon(useCoupon);
                if(coupon.equals("Yes")){
                    coupCount++;
                }
            }
            int whichFood = (int)(Math.floor(Math.random()*3))+1;
            if(whichFood==1){
                item1.setBank(money);
                totProfit = totProfit+item1.buyFood(affect,coupon,myCost,price);
                totCost = totCost+item1.getCost();
                totalMade = totalMade+item1.getSubTotal();
                itemCount=itemCount+item1.getItemCount();
            }else if(whichFood==2){
                item2.setBank(money);
                totProfit = totProfit+item2.buyFood(affect,coupon,myCost,price);
                totCost = totCost+item2.getCost();
                totalMade = totalMade+item2.getSubTotal();
                itemCount=itemCount+item2.getItemCount();
            }else{
                item3.setBank(money);
                totProfit = totProfit+item3.buyFood(affect,coupon,myCost,price);
                totCost = totCost+item3.getCost();
                totalMade = totalMade+item3.getSubTotal();
                itemCount=itemCount+item3.getItemCount();
            }
         }

    }
    @FXML
    private void report(ActionEvent event) {
        couponUsed.setText(Integer.toString(coupCount));
        totalCost.setText(Double.toString(totCost));
        totalSubTotal.setText(Double.toString(totalMade));
        totalProfit.setText(Double.toString(totProfit));
        sold.setText(Integer.toString(itemCount));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
