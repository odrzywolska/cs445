package edu.iit.cs445.vin.boundary;

import edu.iit.cs445.vin.model.GenericResponse;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/4/2015.
 */
public abstract class ConfirmDeliveryRequest {
    protected int subId;
    protected int delId;
    protected String firstName;
    protected String lastName;

    public ConfirmDeliveryRequest(int subId, int delId, String firstName, String lastName){
        this.subId = subId;
        this.delId = delId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public abstract GenericResponse confirmDelivery(Collection<Subscriber> subs);
}
