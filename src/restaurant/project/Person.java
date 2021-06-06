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
public class Person {
//    public String setName(){
//        
//    }
    public int manageHunger(int hunger,int trial){
        if(trial==5){//This will control the hunger of a person...It will be a random number and will be added to the hunger of the person
            if (hunger==1){
                hunger++;
            }else if(hunger==3){
                hunger--;
            }else{
                hunger=2;
            }
        }
        
            return hunger;       
    }
    public double setMoney(double bank,int debtRaise){
        if (debtRaise==7){
            //you get a raise
            bank=bank+10;
        }
        if(debtRaise==13){
            //you get a debt
            bank=bank-10;
        }
        return bank;
    }
    public String useCoupon(int yOrn){
        //This will decide if a coupon will be used
        
        if(yOrn<10){
            return "Yes";
        }else{
            return "No";
        }
    }
}
