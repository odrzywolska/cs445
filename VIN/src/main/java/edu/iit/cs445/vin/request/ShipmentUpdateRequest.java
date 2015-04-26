package edu.iit.cs445.vin.request;

public class ShipmentUpdateRequest {
    String delivery_day;
    String time_of_day;

    public ShipmentUpdateRequest() {
    }

    public ShipmentUpdateRequest(String delivery_day, String time_of_day) {
        this.delivery_day = delivery_day;
        this.time_of_day = time_of_day;
    }

    public String getDelivery_day() {
        return delivery_day;
    }

    public void setDelivery_day(String delivery_day) {
        this.delivery_day = delivery_day;
    }

    public String getTime_of_day() {
        return time_of_day;
    }

    public void setTime_of_day(String time_of_day) {
        this.time_of_day = time_of_day;
    }
}
