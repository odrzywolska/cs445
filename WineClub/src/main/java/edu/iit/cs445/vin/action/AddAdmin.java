package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.boundary.AddAdminRequest;
import edu.iit.cs445.vin.model.AddAdminResponse;
import edu.iit.cs445.vin.model.Admin;
import edu.iit.cs445.vin.model.GenericResponse;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/18/2015.
 */
public class AddAdmin extends AddAdminRequest {
    private Admin admin;

    public AddAdmin(String name) {
        super(name);
    }


    public AddAdminResponse addAccount(Collection<Admin> admins){
        Admin admin = new Admin();
        admins.add(admin);
        return new AddAdminResponse(admin.getId());
    }
}
