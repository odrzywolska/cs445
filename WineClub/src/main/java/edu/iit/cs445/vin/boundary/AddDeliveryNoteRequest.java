package edu.iit.cs445.vin.boundary;

import edu.iit.cs445.vin.model.GenericResponse;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/3/2015.
 */
public abstract class AddDeliveryNoteRequest {
    protected int subId;
    protected int deliveryId;
    protected String note;

    public AddDeliveryNoteRequest(int subId, int delId, String note){
        this.subId = subId;
        this.deliveryId = delId;
        this.note = note;
    }

    public abstract GenericResponse updateOrder(Collection<Subscriber> subs);
}
