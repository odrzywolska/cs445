package edu.iit.cs445.vin.action;


import edu.iit.cs445.vin.data.IdGenerator;
import edu.iit.cs445.vin.model.*;
import edu.iit.cs445.vin.request.AdminRequest;
import edu.iit.cs445.vin.request.MonthlySelectionRequest;
import edu.iit.cs445.vin.response.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public class AdminAction {

    public IdResponse createAdmin(Collection<Admin> admins, AdminRequest request) {
        Admin admin = new Admin(IdGenerator.newID(), request.getName());
        admins.add(admin);
        return new IdResponse(admin.getId());
    }

    public AdminsResponse getAdmins(Collection<Admin> admins) {
        List<AdminResponse> response = new ArrayList<AdminResponse>();
        for(Admin a:admins){
            response.add(new AdminResponse(a.getId(), a.getName()));
        }
        return new AdminsResponse(response);
    }


    public void updateAdmin(Collection<Admin> admins, int id, AdminRequest request) {
        Admin admin = getAdminById(admins, id);
        if(admin != null) {
            admin.setName(request.getName());
        }
    }

    private Admin getAdminById(Collection<Admin> admins, int id){
        for(Admin a:admins){
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }

    public AdminResponse getAdmin(Collection<Admin> admins, int id) {
        Admin admin = getAdminById(admins, id);
        if(admin == null)
            return null;
        return new AdminResponse(admin.getId(), admin.getName());
    }


    public RevenueResponse getRevenue(Collection<Subscriber> subscribers) {
        return new RevenueResponse(
                subscribers.size(),
                0,
                subscribers.size()*59.99,
                subscribers.size()*6.01
        );
    }


    public MonthlySelectionsResponse getMonthlySelections(Collection<MonthlySelection> monthlySelections) {
        List<MonthlySelectionResponse> responses = new ArrayList<MonthlySelectionResponse>();
        for(MonthlySelection m:monthlySelections){
            responses.add(new MonthlySelectionResponse(m.getId(), m.getSelection_month(), m.getType()));
        }
        return new MonthlySelectionsResponse(responses);
    }

    public IdResponse addMonthlySelection(Collection<MonthlySelection> monthlySelections, Collection<Subscriber> subscribers, MonthlySelectionRequest request) {
        MonthlySelection monthlySelection = new MonthlySelection(
                IdGenerator.newID(),
                request.getSelection_month(),
                request.getType(),
                request.getWines(),
                Calendar.getInstance().getTime()
        );

        for(Subscriber s: subscribers){
            if(s.getDelivery().getType() == request.getType()){
                s.getShipments().add(new Shipment(
                        IdGenerator.newID(),
                        request.getSelection_month().split("/")[0],
                        request.getSelection_month().split("/")[1],
                        DeliveryStatus.Pending,
                        request.getType(),
                        request.getWines(),
                        s.getDelivery().getDow(),
                        s.getDelivery().getTod()
                        )
                );
            }
        }

        monthlySelections.add(monthlySelection);
        return new IdResponse(monthlySelection.getId());
    }

    public MonthlySelectionDetailResponse getMonthlySelection(Collection<MonthlySelection> monthlySelections, int id) {
        for(MonthlySelection m:monthlySelections){
            if(m.getId() == id){
                List<WineResponse> wines = new ArrayList<WineResponse>();
                for(Wine w:m.getWines()){
                    wines.add(new WineResponse(w.getId(), w.getLabel_name(), null));
                }
                return new MonthlySelectionDetailResponse(
                        m.getId(),
                        m.getSelection_month(),
                        m.getType(),
                        m.getCreate_date(),
                        wines
                );
            }
        }
        return null;
    }
}
