package edu.iit.cs445.vin.boundary;

import edu.iit.cs445.vin.model.Admin;
import edu.iit.cs445.vin.model.GenericResponse;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/18/2015.
 */
public abstract class ModifyAdminRequest {
    protected String name;
    protected int adminId;

    public ModifyAdminRequest(int aId, String name){
        this.adminId = aId;
        this.name = name;
    }

    public abstract GenericResponse modifyAccount(Collection<Admin> admins);
}
