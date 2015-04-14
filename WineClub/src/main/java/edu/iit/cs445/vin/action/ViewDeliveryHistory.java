package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.boundary.ViewDeliveryHistoryRequest;
import edu.iit.cs445.vin.model.Delivery;
import edu.iit.cs445.vin.model.Subscriber;
import edu.iit.cs445.vin.model.ViewDeliveryHistoryResponse;

import java.util.Collection;
import java.util.List;

/**
 * Created by odrzy_000 on 4/3/2015.
 */
public class ViewDeliveryHistory extends ViewDeliveryHistoryRequest{

    public ViewDeliveryHistory(int subId){
        super(subId);
    }

    @Override
    public ViewDeliveryHistoryResponse allDeliveries(Collection<Subscriber> subs) {
        Subscriber dataBaseSub = getAccount(subs, subId);

        if (dataBaseSub == null) {
            return new ViewDeliveryHistoryResponse(null, false, "User does not have an account");
        } else {
            List<Delivery> deliveryHistory = dataBaseSub.getDeliveryHistory();
            return new ViewDeliveryHistoryResponse(deliveryHistory, true, "Delivery history returned");
        }
    }

    private Subscriber getAccount(Collection<Subscriber> subs, int id) {
        for(Subscriber s:subs){
            if(s.getID() == id){
                return s;
            }
        }
        return null;
    }
}
