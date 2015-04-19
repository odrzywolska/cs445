package edu.iit.cs445.vin.rest.responses;

import java.util.Date;

/**
 * Created by odrzy_000 on 4/18/2015.
 */
public class ShipmentResponse {
    int id;
    Date deliveryDate;
    String status;

    public ShipmentResponse() {
    }

    public ShipmentResponse(int id, Date deliveryDate, String status) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
