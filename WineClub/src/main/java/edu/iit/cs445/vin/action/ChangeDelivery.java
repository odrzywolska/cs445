package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.boundary.ChangeDeliveryRequest;
import edu.iit.cs445.vin.model.GenericResponse;
import edu.iit.cs445.vin.model.MonthlySelectionType;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.Calendar;
import java.util.Collection;

/**
 * Created by odrzy_000 on 4/3/2015.
 */
public class ChangeDelivery extends ChangeDeliveryRequest {

    public ChangeDelivery(int subId, int weekOfMonth, int dayOfWeek, int hour, MonthlySelectionType mst, int q, boolean onlyOnce) {
        super(subId, weekOfMonth, dayOfWeek, hour, mst, q, onlyOnce);
    }

    public ChangeDelivery(int subId, int weekOfMonth, int dayOfWeek, int hour, boolean onlyOnce){
        super(subId, weekOfMonth, dayOfWeek, hour, onlyOnce);
    }

    public ChangeDelivery(int subId, MonthlySelectionType mst, int q, boolean onlyOnce) {
        super(subId, mst, q, onlyOnce);
    }

    private Subscriber getAccount(Collection<Subscriber> subs, int id) {
        for(Subscriber s:subs){
            if(s.getID() == id){
                return s;
            }
        }
        return null;
    }

    @Override
    public GenericResponse changeDelivery(Collection<Subscriber> subs) {

        Subscriber dataBaseSub = getAccount(subs, subId);

        if (dataBaseSub == null) {
            return new GenericResponse(false, "User does not have an account");
        }

        if(weekOfMonth == 0 && dayOfWeek == 0 && hour == 0){
            if(onlyOnce){
                dataBaseSub.updateOrderOnce(mst, quantity);
                return new GenericResponse(true, "Next order successfully modified");
            }
            else{
                dataBaseSub.updateOrderPreference(mst, quantity);
                return new GenericResponse(true, "All future order successfully modified");
            }
        }

        if(quantity == 0 && mst == null){
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, 1);
            cal.set(Calendar.WEEK_OF_MONTH, weekOfMonth);
            cal.set(Calendar.DAY_OF_WEEK,dayOfWeek);
            cal.set(Calendar.HOUR, hour);
            cal.set(Calendar.MINUTE, 0);
            if(onlyOnce){
                dataBaseSub.updateDeliveryOnce(cal.getTime());
                return new GenericResponse(true, "Next delivery successfully modified");
            }
            else{
                dataBaseSub.updateDeliveryPreference(cal.getTime());
                return new GenericResponse(true, "All future deliveries successfully modified");
            }
        }

        else{
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, 1);
            cal.set(Calendar.WEEK_OF_MONTH, weekOfMonth);
            cal.set(Calendar.DAY_OF_WEEK,dayOfWeek);
            cal.set(Calendar.HOUR, hour);
            cal.set(Calendar.MINUTE, 0);
            if(onlyOnce){
                dataBaseSub.updateOrderOnce(mst, quantity);
                dataBaseSub.updateDeliveryOnce(cal.getTime());
                return new GenericResponse(true, "Next order and delivery successfully modified");
            }
            else{
                dataBaseSub.updateOrderPreference(mst, quantity);
                dataBaseSub.updateDeliveryPreference(cal.getTime());
                return new GenericResponse(true, "All future orders and deliveries successfully modified");
            }
        }

    }
}
