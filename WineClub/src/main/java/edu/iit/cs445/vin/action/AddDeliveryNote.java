package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.boundary.AddDeliveryNoteRequest;
import edu.iit.cs445.vin.model.Delivery;
import edu.iit.cs445.vin.model.GenericResponse;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/3/2015.
 */
public class AddDeliveryNote extends AddDeliveryNoteRequest {

    public AddDeliveryNote(int subId, int delivery, String note) {
        super(subId, delivery, note);
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
            if(del.getDeliveryId() == delId){
                return del;
            }
        }
        return null;
    }

    @Override
    public GenericResponse updateOrder(Collection<Subscriber> subs) {
        Subscriber dataBaseSub = getAccount(subs, subId);

        if (dataBaseSub == null) {
            return new GenericResponse(false, "User does not have an account");
        }

        Delivery delivery = getDelivery(dataBaseSub.getDeliveryHistory(), deliveryId);

        if(delivery == null){
            return new GenericResponse(false, "This delivery does not exist");
        }

        else {
            delivery.setNote(note);
            return new GenericResponse(true, "Note added successfully");
        }
    }
}
