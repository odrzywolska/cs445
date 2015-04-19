package edu.iit.cs445.vin.rest;

/**
 * Created by odrzy_000 on 4/13/2015.
 */
import edu.iit.cs445.vin.action.AddDeliveryNote;
import edu.iit.cs445.vin.action.AddSubscriber;
import edu.iit.cs445.vin.action.ChangeDelivery;
import edu.iit.cs445.vin.action.ModifySubscriber;
import edu.iit.cs445.vin.boundary.AddSubscriberRequest;
import edu.iit.cs445.vin.boundary.ModifySubscriberRequest;
import edu.iit.cs445.vin.data.SubscribersData;
import edu.iit.cs445.vin.model.AddSubscriberResponse;
import edu.iit.cs445.vin.model.Delivery;
import edu.iit.cs445.vin.model.Subscriber;
import edu.iit.cs445.vin.rest.requests.DeliveryDateTimeRequest;
import edu.iit.cs445.vin.rest.requests.SubscriberRequest;
import edu.iit.cs445.vin.rest.responses.ShipmentNoteResponse;
import edu.iit.cs445.vin.rest.responses.ShipmentResponse;
import edu.iit.cs445.vin.rest.responses.SubscriberResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/sub")
public class SubscriberService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public SubscriberResponse createSub(SubscriberRequest newSubReq){
        AddSubscriberRequest subReq = new AddSubscriber(newSubReq.getAddress().getStreet(),
                newSubReq.getAddress().getCity(),
                newSubReq.getAddress().getState(),
                newSubReq.getAddress().getZip(),
                newSubReq.getName(),
                newSubReq.getEmail(),
                newSubReq.getPhone(),
                newSubReq.getTwitter(),
                newSubReq.getFacebook());
        AddSubscriberResponse response = subReq.addAccount(SubscribersData.getSubs());

        if (response.isStatus())
            return new SubscriberResponse(response.getID(), null);
        else
            return new SubscriberResponse(response.getID(), Arrays.asList(response.getFailureDescription()));
    }

    @POST
    @Path("/wtf")
    @Produces(MediaType.APPLICATION_JSON)
    public String wtf(){
        return "Hooray at least this works";
    }


    @PUT
    @Path("/{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public edu.iit.cs445.vin.rest.responses.GenericResponse updateSub(@PathParam("uid") int id, SubscriberRequest newSubReq){

        ModifySubscriberRequest subReq = new ModifySubscriber(id,
                newSubReq.getAddress().getStreet(),
                newSubReq.getAddress().getCity(),
                newSubReq.getAddress().getState(),
                newSubReq.getAddress().getZip(),
                newSubReq.getName(),
                newSubReq.getEmail(),
                newSubReq.getPhone());
        edu.iit.cs445.vin.model.GenericResponse response = subReq.modifyAccount(SubscribersData.getSubs());

        return new edu.iit.cs445.vin.rest.responses.GenericResponse(Arrays.asList(response.getFailureDescription()));
    }

    @GET
    @Path("/{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    public SubscriberRequest getSub(@PathParam("uid") int id){
        for(Subscriber s: SubscribersData.getSubs()) {
            if (s.getID() == id) {
                return new SubscriberRequest(s.getName(),
                        s.getEmail(),
                        s.getPhone(),
                        s.getTwitter(),
                        s.getFacebook(),
                        s.getAddress());
            }
        }
        return null;
    }

    @GET
    @Path("/{uid}/shipments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ShipmentResponse> getShipments(@PathParam("uid") int id) {
        for (Subscriber s : SubscribersData.getSubs()) {
            if (s.getID() == id) {
                List<Delivery> allDels = s.getDeliveryHistory();
                List<ShipmentResponse> shipments = new ArrayList<>();
                for (Delivery del : allDels) {
                    shipments.add(new ShipmentResponse(del.getDeliveryId(),
                            del.getDeliveryDate(),
                            del.getDelStat().toString()));
                }
                return shipments;
            }
        }
        return null;
    }

    @GET
    @Path("/{uid}/shipments/{sid}")
    @Produces(MediaType.APPLICATION_JSON)
    public ShipmentResponse getShip(@PathParam("uid") int subId, @PathParam("sid") int shipId) {
        for (Subscriber s : SubscribersData.getSubs()) {
            if (s.getID() == subId) {
                List<Delivery> allDels = s.getDeliveryHistory();
                for (Delivery del : allDels) {
                    if (del.getDeliveryId() == shipId) {
                        return new ShipmentResponse(del.getDeliveryId(),
                                del.getDeliveryDate(),
                                del.getDelStat().toString());
                    }
                }
            }
        }
        return null;
    }

//TODO:
//    @PUT
//    @Path("/{uid}/shipments/{sid}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Date getShipDate(@PathParam("uid") int subId, @PathParam("sid") int shipId) {
//        for (Subscriber s : SubscribersData.getSubs()) {
//            if (s.getID() == subId) {
//                List<Delivery> allDels = s.getDeliveryHistory();
//                for (Delivery del : allDels) {
//                    if (del.getDeliveryId() == shipId) {
//                        return del.getDeliveryDate();
//                    }
//                }
//            }
//        }
//        return null;
//    }


    @GET
    @Path("/{uid}/shipments/{sid}/notes")
    @Produces(MediaType.APPLICATION_JSON)
    public ShipmentNoteResponse getShipNote(@PathParam("uid") int subId, @PathParam("sid") int shipId) {
        for (Subscriber s : SubscribersData.getSubs()) {
            if (s.getID() == subId) {
                List<Delivery> allDels = s.getDeliveryHistory();
                for (Delivery del : allDels) {
                    if (del.getDeliveryId() == shipId) {
                        return new ShipmentNoteResponse(del.getDeliveryId(),
                                del.getDeliveryDate(),
                                del.getNote());
                    }
                }
            }
        }
        return null;
    }


    @POST
    @Path("/{uid}/shipments/{sid}/notes")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String setShipNote(@PathParam("uid") int subId, @PathParam("sid") int shipId, String note) {
        for (Subscriber s : SubscribersData.getSubs()) {
            if (s.getID() == subId) {
                List<Delivery> allDels = s.getDeliveryHistory();
                for (Delivery del : allDels) {
                    if (del.getDeliveryId() == shipId) {
                        new AddDeliveryNote(subId,shipId,note);
                        return "Note set";
                    }
                }
            }
        }
        return "Error";
    }

    @GET
    @Path("/{uid}/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Date getDelInfo(@PathParam("uid") int id) {
        for (Subscriber s : SubscribersData.getSubs()) {
            if (s.getID() == id) {
                return s.getDelivery().getDeliveryDate();
            }
        }
        return null;
    }

    @PUT
    @Path("/{uid}/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getDelInfo(@PathParam("uid") int id, DeliveryDateTimeRequest setDateTime) {
        for (Subscriber s : SubscribersData.getSubs()) {
            if (s.getID() == id) {
                new ChangeDelivery(id, 1,setDateTime.getDay(),setDateTime.getTime(),false);
                return "Delivery date and time updated";
            }
        }
        return "Error";
    }

































}
