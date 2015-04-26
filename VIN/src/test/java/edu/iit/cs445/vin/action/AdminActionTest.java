package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.data.IdGenerator;
import edu.iit.cs445.vin.model.*;
import edu.iit.cs445.vin.request.AdminRequest;
import edu.iit.cs445.vin.request.MonthlySelectionRequest;
import edu.iit.cs445.vin.response.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class AdminActionTest {

    List<Admin> admins;
    AdminAction action;
    List<MonthlySelection> ms;
    List<Subscriber> subscribers;

    @Before
    public void setUp() throws Exception {
        admins = new ArrayList<Admin>();
        action = new AdminAction();
        Admin ad1 = new Admin(IdGenerator.newID(), "Default Admin");
        admins.add(ad1);

        ms = new ArrayList<MonthlySelection>();
        List<Note> wineNotes = new ArrayList<Note>(Arrays.asList(new Note(IdGenerator.newID(), Calendar.getInstance().getTime(),
                "Totally delicious wine")));
        List<Wine> wines = new ArrayList<Wine>(Arrays.asList(new Wine(IdGenerator.newID(), "The Mission", wineNotes)));
        MonthlySelection ms1 = new MonthlySelection(IdGenerator.newID(), "Feb/2015", SelectionType.RW, wines, Calendar.getInstance().getTime());
        ms.add(ms1);

        subscribers = new ArrayList<Subscriber>();
        Subscriber sub1 = new Subscriber("abc@def.com", "Abc Def", "7735551111", "AD", "AbcD",
                new Address("123 Main St", "Anytown", "Illinois", "66666"));
        sub1.setId(IdGenerator.newID());
        sub1.setDelivery(new Delivery("Tue", "AM"));
        sub1.setShipments(new ArrayList<Shipment>());
        subscribers.add(sub1);
    }

    @Test
    public void testCreateAdmin() throws Exception {
        AdminRequest adReq = new AdminRequest("Test Admin");
        IdResponse response = action.createAdmin(admins, adReq);
        assertEquals(2, admins.size());
        assertTrue(response.getId() > 0);
    }

    @Test
    public void testGetAdmins() throws Exception {
        AdminsResponse response = action.getAdmins(admins);
        assertEquals(1, response.getAdmins().size());
        assertEquals("Default Admin", response.getAdmins().get(0).getName());
    }

    @Test
    public void testUpdateAdmin() throws Exception {
        int adId = admins.get(0).getId();
        AdminRequest adreq = new AdminRequest("Best Admin");
        action.updateAdmin(admins, adId, adreq);
        assertEquals("Best Admin", admins.get(0).getName());
    }

    @Test
    public void testGetAdmin() throws Exception {
        int adId = admins.get(0).getId();
        AdminResponse response = action.getAdmin(admins,adId);
        assertEquals(adId, response.getId());
        assertEquals("Default Admin", response.getName());
    }

    @Test
    public void testGetRevenue() throws Exception {
        RevenueResponse response = action.getRevenue(subscribers);
        assertEquals(1, response.getUnits_delivered());
        assertTrue(59.99 == response.getWine_revenue());
    }

    @Test
    public void testGetMonthlySelections() throws Exception {
        MonthlySelectionsResponse response = action.getMonthlySelections(ms);
        assertEquals(1, response.getMonthly_selection().size());
    }

    @Test
    public void testAddMonthlySelection() throws Exception {
        List<Note> wineNotes = new ArrayList<Note>(Arrays.asList(new Note(IdGenerator.newID(), Calendar.getInstance().getTime(),
                "Delicious wine")));
        List<Wine> wines = new ArrayList<Wine>(Arrays.asList(new Wine(IdGenerator.newID(), "Dona Paula Black Label", wineNotes)));
        MonthlySelectionRequest msReq = new MonthlySelectionRequest(SelectionType.RW, "Jan/2015", wines);
        IdResponse response = action.addMonthlySelection(ms, subscribers, msReq);
        assertEquals(ms.get(1).getId(), response.getId());
        assertEquals(1, subscribers.get(0).getShipments().size());
    }

    @Test
    public void testGetMonthlySelection() throws Exception {
        int msId = ms.get(0).getId();
        MonthlySelectionDetailResponse response = action.getMonthlySelection(ms, msId);
        assertEquals(SelectionType.RW, response.getType());
    }
}