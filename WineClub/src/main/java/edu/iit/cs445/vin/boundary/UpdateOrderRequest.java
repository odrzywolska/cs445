package edu.iit.cs445.vin.boundary;

import edu.iit.cs445.vin.model.GenericResponse;
import edu.iit.cs445.vin.model.MonthlySelectionType;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/3/2015.
 */
public abstract class UpdateOrderRequest {
    protected int subId;
    protected MonthlySelectionType mst;
    protected int quantity;

    public UpdateOrderRequest(int subId, MonthlySelectionType mst, int quantity){
        this.subId = subId;
        this.mst = mst;
        this.quantity = quantity;
    }

    public abstract GenericResponse updateOrder(Collection<Subscriber> subs);
}
