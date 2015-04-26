package edu.iit.cs445.vin.rest;

import edu.iit.cs445.vin.action.AdminAction;
import edu.iit.cs445.vin.data.AdminData;
import edu.iit.cs445.vin.data.MonthlySelectionData;
import edu.iit.cs445.vin.data.SubscriberData;
import edu.iit.cs445.vin.request.AdminRequest;
import edu.iit.cs445.vin.request.MonthlySelectionRequest;
import edu.iit.cs445.vin.response.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/admin")
public class AdminService {

    AdminAction action = new AdminAction();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public IdResponse createAdmin(AdminRequest request){
        AdminData.load();
        IdResponse response = action.createAdmin(AdminData.getAdmins(), request);
        AdminData.save();
        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AdminsResponse getAdmin(){
        AdminData.load();
        AdminsResponse response = action.getAdmins(AdminData.getAdmins());
        AdminData.save();
        return response;
    }

    @PUT
    @Path("/{aid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAdmin(@PathParam("aid") int id, AdminRequest request){
        AdminData.load();
        action.updateAdmin(AdminData.getAdmins(), id, request);
        AdminData.save();
    }

    @GET
    @Path("/{aid}")
    @Produces(MediaType.APPLICATION_JSON)
    public AdminResponse getAdmin(@PathParam("aid") int id){
        AdminData.load();
        AdminResponse response = action.getAdmin(AdminData.getAdmins(), id);
        AdminData.save();
        return response;
    }

    //TODO:
    @GET
    @Path("/revenue")
    @Produces(MediaType.APPLICATION_JSON)
    public RevenueResponse getRevenue(){
        AdminData.load();
        SubscriberData.load();
        RevenueResponse response =  action.getRevenue(SubscriberData.getSubscribers());
        AdminData.save();
        SubscriberData.save();
        return response;
    }

    @GET
    @Path("/monthly_selection")
    @Produces(MediaType.APPLICATION_JSON)
    public MonthlySelectionsResponse getMonthlySelections(){
        AdminData.load();
        MonthlySelectionsResponse response = action.getMonthlySelections(MonthlySelectionData.getMonthlySelections());
        AdminData.save();
        return response;
    }

    @POST
    @Path("/monthly_selection")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public IdResponse getMonthlySelection(MonthlySelectionRequest request){
        MonthlySelectionData.load();
        SubscriberData.load();
        IdResponse response = action.addMonthlySelection(MonthlySelectionData.getMonthlySelections(), SubscriberData.getSubscribers(), request);
        MonthlySelectionData.save();
        SubscriberData.save();
        return response;
    }

    @GET
    @Path("/monthly_selection/{mid}")
    @Produces(MediaType.APPLICATION_JSON)
    public MonthlySelectionDetailResponse getMonthlySelection(@PathParam("mid") int id){
        MonthlySelectionData.load();
        MonthlySelectionDetailResponse response = action.getMonthlySelection(MonthlySelectionData.getMonthlySelections(), id);
        MonthlySelectionData.save();
        return response;
    }


}
