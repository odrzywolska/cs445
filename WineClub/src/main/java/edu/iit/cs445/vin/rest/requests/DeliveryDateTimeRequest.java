package edu.iit.cs445.vin.rest.requests;

import com.sun.org.apache.bcel.internal.generic.SWITCH;

/**
 * Created by odrzy_000 on 4/18/2015.
 */
public class DeliveryDateTimeRequest {
    String day, time;

    public DeliveryDateTimeRequest() {
    }

    public DeliveryDateTimeRequest(String day, String time) {
        this.day = day;
        this.time = time;
    }

    public int getDay() {
        int dayOfWeek = 1;
        switch(day){
            case "Mon": dayOfWeek = 1;
                break;
            case "Tue": dayOfWeek = 2;
                break;
            case "Wed": dayOfWeek = 3;
                break;
            case "Thu": dayOfWeek = 4;
                break;
            case "Fri": dayOfWeek = 5;
                break;
            case "Sat": dayOfWeek = 6;
                break;
            default: dayOfWeek = -1;
        }
        return dayOfWeek;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getTime() {
        int timeHour = 12;
        switch(time){
            case "AM": timeHour = 8;
                break;
            case "PM": timeHour = 14;
                break;
            default: timeHour = -1;
        }
        return timeHour;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
