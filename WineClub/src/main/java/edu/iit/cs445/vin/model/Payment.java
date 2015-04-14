package edu.iit.cs445.vin.model;

/**
 * Created by odrzy_000 on 4/4/2015.
 */
public class Payment {
    private String creditCardNum;
    private double charge, refund;

    public Payment(){
        this.creditCardNum = "123456789";
        this.charge = 0.0;
        this.refund = 0.0;
    }

    public Payment(String creditCardNum){
        this.creditCardNum = creditCardNum;
    }

    public void addCharge(double charge){
        this.charge += charge;
    }

    public void refund(double refund){
        this.refund += refund;
    }

    public double accBalance(){
        return charge - refund;
    }

    public double getCharge() {
        return charge;
    }

    public double getRefund() {
        return refund;
    }

    public void updateCard(String creditCardNum){
        this.creditCardNum = creditCardNum;
    }
}


