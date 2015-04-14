package edu.iit.cs445.vin.boundary;

import edu.iit.cs445.vin.model.Delivery;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.Collection;
import java.util.List;

/**
 * Created by odrzy_000 on 4/4/2015.
 */
public abstract class DeliveryListRequest {

    public abstract List<Delivery> getDeliveryList(Collection<Subscriber> subs);

}
