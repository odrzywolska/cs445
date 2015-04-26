package edu.iit.cs445.vin.response;

import edu.iit.cs445.vin.model.DeliveryStatus;

public class ShipmentResponse {
    int id;
    String selection_month;
    DeliveryStatus status;

    public ShipmentResponse() {
    }

    public ShipmentResponse(int id, String selection_month, DeliveryStatus status) {
        this.id = id;
        this.selection_month = selection_month;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSelection_month() {
        return selection_month;
    }

    public void setSelection_month(String selection_month) {
        this.selection_month = selection_month;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }
}
