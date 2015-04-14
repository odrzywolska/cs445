package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.boundary.ModifySubscriberRequest;
import edu.iit.cs445.vin.model.Address;
import edu.iit.cs445.vin.model.GenericResponse;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/3/2015.
 */
public class ModifySubscriber extends ModifySubscriberRequest{
    private Address a;
    private Subscriber s;

    public ModifySubscriber(int subId, String street, String city, String state, String zip,
                         String name, String email, String phone, String creditCard) {
        super(subId, street, city, state, zip, name, email, phone, creditCard);
    }

    @Override
    public GenericResponse modifyAccount(Collection<Subscriber> subs) {
        a = new Address(this.street, this.city, this.state, this.zip);
        s = new Subscriber(this.name, this.email, this.phone, a, this.facebook, this.twitter, this.creditCard);

        if (addressInBannedState()) {
            return new GenericResponse(false, "Cannot ship to this state");
        }

        Subscriber dataBaseSub = getAccount(subs, s);

        if (dataBaseSub == null) {
            return new GenericResponse(false, "User does not have an account");
        } else {
            dataBaseSub.updateInfo(name, email, phone, a, creditCard);
            return new GenericResponse(true, "Congratulations, your account has been updated");
        }
    }

    @Override
    public GenericResponse cancelSubscription(Collection<Subscriber> subs) {
        Subscriber dataBaseSub = getAccount(subs, s);
        if (dataBaseSub == null) {
            return new GenericResponse(false, "User does not have an account");
        } else {
            dataBaseSub.cancelSubscription();
            return new GenericResponse(true, "Your subscription has been cancelled");
        }
    }

    private Subscriber getAccount(Collection<Subscriber> subs, Subscriber sub) {
        for(Subscriber s:subs){
            if(s.equals(sub)){
                return s;
            }
        }
        return null;
    }

    private boolean addressInBannedState() {
        return false;
    }
}
