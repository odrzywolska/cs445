package edu.iit.cs445.vin.boundary;

import edu.iit.cs445.vin.model.Subscriber;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/4/2015.
 */
public abstract class SubscriberInfoRequest {

    public abstract int getNumSubs(Collection<Subscriber> subs);

    public abstract int newSubsPastMonth(Collection<Subscriber> subs);

    public abstract int newSubsPastYear(Collection<Subscriber> subs);

    public abstract int cancelledSubsPastMonth(Collection<Subscriber> subs);

    public abstract int cancelledSubsPastYear(Collection<Subscriber> subs);

}
