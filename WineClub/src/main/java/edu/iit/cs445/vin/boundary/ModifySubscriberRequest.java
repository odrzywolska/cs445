package edu.iit.cs445.vin.boundary;

import edu.iit.cs445.vin.model.GenericResponse;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/3/2015.
 */
public abstract class ModifySubscriberRequest {

    protected String street, city, state, zip;
    protected String name, email, phone, twitter, facebook;
    protected int subId;

    public ModifySubscriberRequest(int subId, String street, String c, String state, String z, String n, String e, String p) {
        this.subId = subId;
        this.street = street;
        this.city = c;
        this.state = state;
        this.zip = z;
        this.name = n;
        this.email = e;
        this.phone = p;
    }

    public abstract GenericResponse modifyAccount(Collection<Subscriber> subs);

    public abstract GenericResponse cancelSubscription(Collection<Subscriber> subs);
}


