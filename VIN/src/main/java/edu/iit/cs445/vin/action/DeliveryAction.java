package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.data.IdGenerator;
import edu.iit.cs445.vin.model.DeliveryStatus;
import edu.iit.cs445.vin.model.Receipt;
import edu.iit.cs445.vin.model.Subscriber;
import edu.iit.cs445.vin.request.ReceiptRequest;
import edu.iit.cs445.vin.response.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public class DeliveryAction {

    public DeliveriesResponse getDeliveries(Collection<Subscriber> subscribers) {
        List<DeliverToResponse> responses = new ArrayList<DeliverToResponse>();
        for(Subscriber s:subscribers){
            responses.add( new DeliverToResponse(
                    s.getName(),
                    s.getPhone(),
                    s.getEmail(),
                    s.getAddress(),
                    s.getDelivery().getDow(),
                    s.getDelivery().getTod(),
                    s.getDelivery().getType()
            ));
        }
        return new DeliveriesResponse(responses);
    }

    public IdResponse addReceipt(Collection<Subscriber> subscribers, Collection<Receipt> receipts, ReceiptRequest request) {
        Subscriber subscriber = null;
        for(Subscriber s:subscribers){
            if(s.getName().equals(request.getName())){
                subscriber = s;
                break;
            }
        }
        if(subscriber == null)
            return null;

        Receipt receipt = new Receipt(
                IdGenerator.newID(),
                request.getName(),
                Calendar.getInstance().getTime(),
                subscriber.getId());

        int shipments = subscriber.getShipments().size();
        subscriber.getShipments().get(shipments-1).setDeliveryStatus(DeliveryStatus.Delivered);
        receipts.add(receipt);
        return new IdResponse(receipt.getId());
    }

    public ReceiptsResponse getReceipts(Collection<Receipt> receipts) {
        List<ReceiptResponse> responses = new ArrayList<ReceiptResponse>();
        for(Receipt r:receipts){
            responses.add(new ReceiptResponse(
                    r.getId(),
                    r.getDate(),
                    r.getSubId(),
                    r.getName()
            ));
        }
        return new ReceiptsResponse(responses);
    }

    public ReceiptResponse getReceipt(Collection<Receipt> receipts, int id) {
        for(Receipt r:receipts){
            if(r.getId() == id){
                return new ReceiptResponse(
                        r.getId(),
                        r.getDate(),
                        r.getSubId(),
                        r.getName()
                );
            }
        }
        return null;
    }
}
