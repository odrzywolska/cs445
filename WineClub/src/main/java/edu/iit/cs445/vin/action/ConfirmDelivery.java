package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.boundary.ConfirmDeliveryRequest;
import edu.iit.cs445.vin.model.Delivery;
import edu.iit.cs445.vin.model.DeliveryStatus;
import edu.iit.cs445.vin.model.GenericResponse;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/4/2015.
 */
public class ConfirmDelivery extends ConfirmDeliveryRequest {
    public ConfirmDelivery(int subId, int delId, String firstName, String lastName) {
        super(subId, delId, firstName, lastName);
    }

    private Subscriber getAccount(Collection<Subscriber> subs, int id) {
        for(Subscriber s:subs){
            if(s.getID() == id){
                return s;
            }
        }
        return null;
    }

    private Delivery getDelivery(Collection<Delivery> dels, int delId) {
        for(Delivery del:dels){
            if(del.getId() == delId){
                return del;
            }
        }
        return null;
    }

    @Override
    public GenericResponse confirmDelivery(Collection<Subscriber> subs) {
        Subscriber dataBaseSub = getAccount(subs, subId);

        if (dataBaseSub == null) {
            return new GenericResponse(false, "User does not have an account");
        }

        Delivery delivery = getDelivery(dataBaseSub.getDeliveryHistory(), delId);

        if(delivery == null){
            return new GenericResponse(false, "This delivery does not exist");
        }

        else {
            delivery.setSignature(firstName, lastName);
            delivery.setDelStat(DeliveryStatus.Delivered);
            return new GenericResponse(true, "Order has been delivered");
        }
    }
}
