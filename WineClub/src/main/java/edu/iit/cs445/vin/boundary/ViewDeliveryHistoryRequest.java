package edu.iit.cs445.vin.boundary;

import edu.iit.cs445.vin.model.Subscriber;
import edu.iit.cs445.vin.model.ViewDeliveryHistoryResponse;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/3/2015.
 */
public abstract class ViewDeliveryHistoryRequest {

    protected int subId;

    public ViewDeliveryHistoryRequest(int subId){
        this.subId = subId;
    }

    public abstract ViewDeliveryHistoryResponse allDeliveries(Collection<Subscriber> subs);
}
