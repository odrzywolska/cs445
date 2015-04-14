package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.boundary.SubscriberInfoRequest;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/4/2015.
 */
public class GetSubscriberInfo extends SubscriberInfoRequest {

    @Override
    public int getNumSubs(Collection<Subscriber> subs) {
        return 0;
    }

    @Override
    public int newSubsPastMonth(Collection<Subscriber> subs) {
        return 0;
    }

    @Override
    public int newSubsPastYear(Collection<Subscriber> subs) {
        return 0;
    }

    @Override
    public int cancelledSubsPastMonth(Collection<Subscriber> subs) {
        return 0;
    }

    @Override
    public int cancelledSubsPastYear(Collection<Subscriber> subs) {
        return 0;
    }
}
