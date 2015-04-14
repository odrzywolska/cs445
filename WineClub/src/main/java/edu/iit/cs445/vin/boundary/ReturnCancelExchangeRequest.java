package edu.iit.cs445.vin.boundary;

import edu.iit.cs445.vin.model.GenericResponse;
import edu.iit.cs445.vin.model.MonthlySelectionType;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/4/2015.
 */
public abstract class ReturnCancelExchangeRequest {
    protected int subId;
    protected int delId;
    protected String reason;

    public ReturnCancelExchangeRequest(int subId, int delId, String reason){
        this.subId = subId;
        this.delId = delId;
        this.reason = reason;
    }

    public abstract GenericResponse cancelOrder(Collection<Subscriber> subs);

    public abstract GenericResponse exchangeOrder(Collection<Subscriber> subs, MonthlySelectionType newMst);

    public abstract GenericResponse returnOrder(Collection<Subscriber> subs);

}
