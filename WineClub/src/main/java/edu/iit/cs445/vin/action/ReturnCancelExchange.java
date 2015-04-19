package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.boundary.ReturnCancelExchangeRequest;
import edu.iit.cs445.vin.model.*;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/4/2015.
 */
public class ReturnCancelExchange extends ReturnCancelExchangeRequest {

    public ReturnCancelExchange(int subId, int delId, String reason) {
        super(subId, delId, reason);
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
    public GenericResponse cancelOrder(Collection<Subscriber> subs) {
        Subscriber dataBaseSub = getAccount(subs, subId);


        if (dataBaseSub == null) {
            return new GenericResponse(false, "User does not have an account");
        }

        Delivery delivery = getDelivery(dataBaseSub.getDeliveryHistory(), delId);

        if (delivery == null) {
            return new GenericResponse(false, "This delivery does not exist");
        }
        else{
            delivery.setDelStat(DeliveryStatus.Canceled);
            double returnAmount = delivery.getQuantity() * delivery.getPrice();
            return new GenericResponse(false, "Order has been cancelled");
        }
    }

    @Override
    public GenericResponse exchangeOrder(Collection<Subscriber> subs, MonthlySelectionType newMst) {
        Subscriber dataBaseSub = getAccount(subs, subId);

        if (dataBaseSub == null) {
            return new GenericResponse(false, "User does not have an account");
        }
        Delivery delivery = getDelivery(dataBaseSub.getDeliveryHistory(), delId);

        if (delivery == null) {
            return new GenericResponse(false, "This delivery does not exist");
        }
        else{
            delivery.setDelStat(DeliveryStatus.Exchanged);
            delivery.updateOrder(newMst, delivery.getQuantity());
            return new GenericResponse(false, "Order has been exchanged");
        }
    }

    @Override
    public GenericResponse returnOrder(Collection<Subscriber> subs) {
        Subscriber dataBaseSub = getAccount(subs, subId);


        if (dataBaseSub == null) {
            return new GenericResponse(false, "User does not have an account");
        }

        Delivery delivery = getDelivery(dataBaseSub.getDeliveryHistory(), delId);

        if(delivery == null) {
            return new GenericResponse(false, "This delivery does not exist");
        }
        else{
            delivery.setDelStat(DeliveryStatus.Returned);
            double returnAmount = delivery.getQuantity() * delivery.getPrice();
            return new GenericResponse(false, "Order has been returned");
        }
    }
}
