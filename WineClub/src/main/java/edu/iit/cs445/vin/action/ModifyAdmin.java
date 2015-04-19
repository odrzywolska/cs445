package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.boundary.ModifyAdminRequest;
import edu.iit.cs445.vin.data.AdminData;
import edu.iit.cs445.vin.model.Admin;
import edu.iit.cs445.vin.model.GenericResponse;

import java.util.Collection;

/**
 * Created by odrzy_000 on 4/18/2015.
 */
public class ModifyAdmin extends ModifyAdminRequest {

    private Admin a;
    public ModifyAdmin(int aId, String name) {
        super(aId, name);
    }

    @Override
    public GenericResponse modifyAccount(Collection<Admin> admins) {
        for(Admin a: admins){
            if(a.getId() == adminId){
                a.setName(name);
                return new GenericResponse(true, "Congratulations, your account has been updated");
            }
        }
        return new GenericResponse(false, "This account does not exist");
    }
}
