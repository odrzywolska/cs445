//package edu.iit.cs445.vin.rest;
//
//import edu.iit.cs445.vin.action.AddAdmin;
//import edu.iit.cs445.vin.action.ModifyAdmin;
//import edu.iit.cs445.vin.boundary.AddAdminRequest;
//import edu.iit.cs445.vin.boundary.ModifyAdminRequest;
//import edu.iit.cs445.vin.data.AdminData;
//import edu.iit.cs445.vin.model.AddAdminResponse;
//import edu.iit.cs445.vin.model.Admin;
//import edu.iit.cs445.vin.rest.requests.AdminRequest;
//import edu.iit.cs445.vin.rest.responses.AdminResponse;
//
//import javax.ws.rs.*;
//import java.util.Collection;
//import java.util.List;
//
///**
// * Created by odrzy_000 on 4/18/2015.
// */
//@Path("/admin")
//public class AdminServices {
//
//    @POST
//    @Path("/")
//    public AdminResponse createAdmin(AdminRequest newAdmin){
//        AddAdminRequest adminReq = new AddAdmin(newAdmin.getName());
//        AddAdminResponse response = adminReq.addAccount(AdminData.getAdmins());
//        return new AdminResponse(response.getId());
//    }
//
//    @GET
//    @Path("/")
//    public Collection<Admin> getAllAdmins(){
//        return AdminData.getAdmins();
//    }
//
//    @PUT
//    @Path("/{aid}")
//    public String changeAdminName(@PathParam("aid") int id, String name){
//        ModifyAdminRequest adReq = new ModifyAdmin(id, name);
//        return "Admin name updated";
//    }
//
//
//
//
//
//
//
//}
