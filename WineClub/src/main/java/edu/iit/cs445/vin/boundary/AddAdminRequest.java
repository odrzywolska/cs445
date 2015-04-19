package edu.iit.cs445.vin.boundary;

import edu.iit.cs445.vin.model.AddAdminResponse;
import edu.iit.cs445.vin.model.Admin;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/18/2015.
 */
public abstract class AddAdminRequest {
    protected String name;

    public AddAdminRequest(String name){
        this.name = name;
    }

    public abstract AddAdminResponse addAccount(Collection<Admin> admins);

}
