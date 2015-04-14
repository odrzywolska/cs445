package edu.iit.cs445.vin.boundary;

import edu.iit.cs445.vin.model.GenericResponse;
import edu.iit.cs445.vin.model.MonthlySelectionType;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/3/2015.
 */
public abstract class ChangeDeliveryRequest {
    protected int subId;
    protected int weekOfMonth;
    protected int dayOfWeek;
    protected int hour;
    protected boolean onlyOnce;
    protected MonthlySelectionType mst;
    protected int quantity;

    public ChangeDeliveryRequest(int subId, int weekOfMonth, int dayOfWeek, int hour, MonthlySelectionType mst, int q, boolean onlyOnce){
        this.subId = subId;
        this.weekOfMonth = weekOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.hour = hour;
        this.mst = mst;
        this.quantity = q;
        this.onlyOnce = onlyOnce;
    }

    public ChangeDeliveryRequest(int subId, int weekOfMonth, int dayOfWeek, int hour, boolean onlyOnce){
        this.subId = subId;
        this.weekOfMonth = weekOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.hour = hour;
        this.onlyOnce = onlyOnce;
    }

    public ChangeDeliveryRequest(int subId, MonthlySelectionType mst, int q, boolean onlyOnce){
        this.subId = subId;
        this.mst = mst;
        this.quantity = q;
        this.onlyOnce = onlyOnce;
    }

    public abstract GenericResponse changeDelivery(Collection<Subscriber> subs);
}
