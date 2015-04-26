package edu.iit.cs445.vin.response;

import edu.iit.cs445.vin.model.*;
import edu.iit.cs445.vin.model.Error;

import java.util.List;

public class DeliveryResponse {
    int uid;
    int sid;
    String delivery_day;
    String time_of_day;
    List<edu.iit.cs445.vin.model.Error> errors;

    public DeliveryResponse() {
    }

    public DeliveryResponse(int uid, List<Error> errors, String time_of_day, String delivery_day, int sid) {
        this.uid = uid;
        this.errors = errors;
        this.time_of_day = time_of_day;
        this.delivery_day = delivery_day;
        this.sid = sid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
