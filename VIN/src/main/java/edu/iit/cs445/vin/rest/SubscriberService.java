package edu.iit.cs445.vin.rest;

import edu.iit.cs445.vin.action.SubscriberAction;
import edu.iit.cs445.vin.data.SubscriberData;
import edu.iit.cs445.vin.model.Delivery;
import edu.iit.cs445.vin.model.Note;
import edu.iit.cs445.vin.request.AddNoteRequest;
import edu.iit.cs445.vin.request.ShipmentUpdateRequest;
import edu.iit.cs445.vin.request.SubscriberRequest;
import edu.iit.cs445.vin.response.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/sub")
public class SubscriberService {

    SubscriberAction action = new SubscriberAction();
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public IdErrorResponse createSub(SubscriberRequest request){
        SubscriberData.load();
        IdErrorResponse response = action.createSubscriber(SubscriberData.getSubscribers(), request);
        SubscriberData.save();
        return response;
    }

    @PUT
    @Path("/{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ErrorResponse updateSub(@PathParam("uid") int id, SubscriberRequest request){
        SubscriberData.load();
        ErrorResponse response = action.updateSubscriber(SubscriberData.getSubscribers(), request, id);
        SubscriberData.save();
        return response;
    }

    @GET
    @Path("/{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    public SubscriberResponse getSub(@PathParam("uid") int id){
        SubscriberData.load();
        SubscriberResponse response = action.findSubById(SubscriberData.getSubscribers(), id);
        SubscriberData.save();
        return response;
    }

    @GET
    @Path("/{uid}/shipments")
    @Produces(MediaType.APPLICATION_JSON)
    public ShipmentsResponse getShipments(@PathParam("uid") int id){
        SubscriberData.load();
        ShipmentsResponse response = action.getShipmentsForSub(SubscriberData.getSubscribers(), id);
        SubscriberData.save();
        return response;
    }

    @GET
    @Path("/{uid}/shipments/{sid}")
    @Produces(MediaType.APPLICATION_JSON)
    public ShipmentDetailResponse getShipmentById(@PathParam("uid") int id, @PathParam("sid") int sid){
        SubscriberData.load();
        ShipmentDetailResponse response = action.getShipmentDetailForSub(SubscriberData.getSubscribers(), id, sid);
        SubscriberData.save();
        return response;
    }

    @PUT
    @Path("/{uid}/shipments/{sid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateShipmentDetails(@PathParam("uid") int id, @PathParam("sid") int sid, ShipmentUpdateRequest request){
        SubscriberData.load();
        action.updateShipmentDetails(SubscriberData.getSubscribers(), id, sid, request);
        SubscriberData.save();
    }

    @GET
    @Path("/{uid}/shipments/{sid}/notes")
    @Produces(MediaType.APPLICATION_JSON)
    public NotesResponse getShipmentNotesById(@PathParam("uid") int id, @PathParam("sid") int sid){
        SubscriberData.load();
        NotesResponse response = action.getShipmentNotes(SubscriberData.getSubscribers(), id, sid);
        SubscriberData.save();
        return response;
    }

    @POST
    @Path("/{uid}/shipments/{sid}/notes")
    @Produces(MediaType.APPLICATION_JSON)
    public IdResponse addShipmentNote(@PathParam("uid") int id, @PathParam("sid") int sid, AddNoteRequest request){
        SubscriberData.load();
        IdResponse response = action.addShipmentNote(SubscriberData.getSubscribers(), id, sid, request);
        SubscriberData.save();
        return response;
    }

    @GET
    @Path("/{uid}/shipments/{sid}/notes/{nid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Note getShipmentNote(@PathParam("uid") int id, @PathParam("sid") int sid, @PathParam("nid") int nid){
        SubscriberData.load();
        Note response = action.getShipmentNote(SubscriberData.getSubscribers(), id, sid, nid);
        SubscriberData.save();
        return response;
    }

    @PUT
    @Path("/{uid}/shipments/{sid}/notes/{nid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateShipmentNote(@PathParam("uid") int id, @PathParam("sid") int sid, @PathParam("nid") int nid, AddNoteRequest request){
        SubscriberData.load();
        action.updateShipmentNote(SubscriberData.getSubscribers(), id, sid, nid, request);
        SubscriberData.save();
    }

    @DELETE
    @Path("/{uid}/shipments/{sid}/notes/{nid}")
    public void deleteShipmentNote(@PathParam("uid") int id, @PathParam("sid") int sid, @PathParam("nid") int nid){
        SubscriberData.load();
        action.deleteShipmentNote(SubscriberData.getSubscribers(), id, sid, nid);
        SubscriberData.save();
    }

    @GET
    @Path("/{uid}/wines")
    @Produces(MediaType.APPLICATION_JSON)
    public List<WineResponse> getWines(@PathParam("uid") int id){
        SubscriberData.load();
        List<WineResponse> response = action.getWines(SubscriberData.getSubscribers(), id);
        SubscriberData.save();
        return response;
    }

    @GET
    @Path("/{uid}/wines/{wid}")
    @Produces(MediaType.APPLICATION_JSON)
    public WineResponse getWine(@PathParam("uid") int id, @PathParam("wid") int wid){
        SubscriberData.load();
        WineResponse response = action.getWine(SubscriberData.getSubscribers(), id, wid);
        SubscriberData.save();
        return response;
    }

    @GET
    @Path("/{uid}/wines/{wid}/notes")
    @Produces(MediaType.APPLICATION_JSON)
    public NotesResponse getWineNotes(@PathParam("uid") int id, @PathParam("wid") int wid){
        SubscriberData.load();
        NotesResponse response = action.getWineNotes(SubscriberData.getSubscribers(), id, wid);
        SubscriberData.save();
        return response;
    }

    @POST
    @Path("/{uid}/wines/{wid}/notes")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public IdResponse addWineNote(@PathParam("uid") int id, @PathParam("wid") int wid, AddNoteRequest request){
        SubscriberData.load();
        IdResponse response = action.addWineNote(SubscriberData.getSubscribers(), id, wid, request);
        SubscriberData.save();
        return response;
    }

    @GET
    @Path("/{uid}/wines/{wid}/notes/{nid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Note getWineNote(@PathParam("uid") int id, @PathParam("wid") int wid, @PathParam("nid") int nid){
        SubscriberData.load();
        Note response = action.getWineNote(SubscriberData.getSubscribers(), id, wid, nid);
        SubscriberData.save();
        return response;
    }

    @PUT
    @Path("/{uid}/wines/{wid}/notes/{nid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateWineNote(@PathParam("uid") int id, @PathParam("wid") int wid, @PathParam("nid") int nid, AddNoteRequest request){
        SubscriberData.load();
        action.updateWineNote(SubscriberData.getSubscribers(), id, wid, nid, request);
        SubscriberData.save();
    }

    @DELETE
    @Path("/{uid}/wines/{wid}/notes/{nid}")
    public void deleteWineNote(@PathParam("uid") int id, @PathParam("wid") int wid, @PathParam("nid") int nid){
        SubscriberData.load();
        action.deleteWineNote(SubscriberData.getSubscribers(), id, wid, nid);
        SubscriberData.save();
    }

    @GET
    @Path("/{uid}/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Delivery getDelivery(@PathParam("uid") int id){
        SubscriberData.load();
        Delivery response = action.getDelivery(SubscriberData.getSubscribers(), id);
        SubscriberData.save();
        return response;
    }

    @PUT
    @Path("/{uid}/delivery")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDelivery(@PathParam("uid") int id, Delivery delivery){
        SubscriberData.load();
        action.updateDelivery(SubscriberData.getSubscribers(), id, delivery);
        SubscriberData.save();
    }
}
