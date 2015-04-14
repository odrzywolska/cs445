package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.boundary.DeliveryListRequest;
import edu.iit.cs445.vin.model.Delivery;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.*;

/**
 * Created by odrzy_000 on 4/4/2015.
 */
public class GetDeliveryList extends DeliveryListRequest {
    @Override
    public List<Delivery> getDeliveryList(Collection<Subscriber> subs) {
        List<Delivery> nextDayDelivery = new ArrayList<Delivery>();

        for(Subscriber s:subs){
            if(s.isActive()){
                List<Delivery> delHistory = s.getDeliveryHistory();
                Delivery lastDel = delHistory.get(delHistory.size() - 1);
                Date delDate = lastDel.getDeliveryDate();
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, 1);
                if(Calendar.getInstance().getTime().before(delDate) && cal.getTime().after(delDate)){
                    nextDayDelivery.add(lastDel);
                }
            }
        }
        return nextDayDelivery;
    }
}
