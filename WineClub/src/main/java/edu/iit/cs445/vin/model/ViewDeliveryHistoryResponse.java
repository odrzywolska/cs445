package edu.iit.cs445.vin.model;

import java.util.List;

/**
 * Created by odrzy_000 on 4/3/2015.
 */
public class ViewDeliveryHistoryResponse{
    private boolean status;
    private String failureDescription;
    private List<Delivery> allDeliveries;

    public ViewDeliveryHistoryResponse(List<Delivery> deliveries, boolean s, String f) {
        this.allDeliveries = deliveries;
        this.status = s;
        this.failureDescription = f;
    }

    public void printResponse() {
        System.out.println("Status: " + this.status + "\tDescription: " + this.failureDescription);
    }


}
