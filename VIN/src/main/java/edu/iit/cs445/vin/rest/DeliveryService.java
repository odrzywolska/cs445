package edu.iit.cs445.vin.rest;

import edu.iit.cs445.vin.action.DeliveryAction;
import edu.iit.cs445.vin.data.ReceiptData;
import edu.iit.cs445.vin.data.SubscriberData;
import edu.iit.cs445.vin.request.ReceiptRequest;
import edu.iit.cs445.vin.response.DeliveriesResponse;
import edu.iit.cs445.vin.response.IdResponse;
import edu.iit.cs445.vin.response.ReceiptResponse;
import edu.iit.cs445.vin.response.ReceiptsResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class DeliveryService {

    DeliveryAction action = new DeliveryAction();

    @GET
    @Path("/partner")
    @Produces(MediaType.APPLICATION_JSON)
    public DeliveriesResponse getDeliveries(){
        SubscriberData.load();
        DeliveriesResponse response = action.getDeliveries(SubscriberData.getSubscribers());
        SubscriberData.save();
        return response;
    }

    @POST
    @Path("/receipt")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public IdResponse addReceipt(ReceiptRequest request){
        SubscriberData.load();
        ReceiptData.load();
        IdResponse response = action.addReceipt(SubscriberData.getSubscribers(), ReceiptData.getReceipts(), request);
        SubscriberData.save();
        ReceiptData.save();
        return response;
    }

    @GET
    @Path("/receipt")
    @Produces(MediaType.APPLICATION_JSON)
    public ReceiptsResponse getReceipts(){
        ReceiptData.load();
        ReceiptsResponse response = action.getReceipts(ReceiptData.getReceipts());
        ReceiptData.save();
        return response;
    }

    @GET
    @Path("/receipt/{rid}")
    @Produces(MediaType.APPLICATION_JSON)
    public ReceiptResponse getReceipt(@PathParam("rid") int id){
        ReceiptData.load();
        ReceiptResponse response = action.getReceipt(ReceiptData.getReceipts(), id);
        ReceiptData.save();
        return response;
    }


}
