package edu.iit.cs445.vin.response;

import java.util.List;

public class AdminsResponse {

    List<AdminResponse> admins;

    public AdminsResponse() {
    }

    public AdminsResponse(List<AdminResponse> admins) {
        this.admins = admins;
    }

    public List<AdminResponse> getAdmins() {
        return admins;
    }

    public void setAdmins(List<AdminResponse> admins) {
        this.admins = admins;
    }
}
