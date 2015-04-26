package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.data.IdGenerator;
import edu.iit.cs445.vin.model.*;
import edu.iit.cs445.vin.request.AddNoteRequest;
import edu.iit.cs445.vin.request.ShipmentUpdateRequest;
import edu.iit.cs445.vin.request.SubscriberRequest;
import edu.iit.cs445.vin.response.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;

public class SubscriberActionTest {

    List<Subscriber> subscribers;
    SubscriberAction action;

    @Before
    public void setUp() throws Exception {
        subscribers = new ArrayList<Subscriber>();
        action = new SubscriberAction();
        Subscriber sub1 = new Subscriber("abc@def.com", "Abc Def", "7735551111", "AD", "AbcD",
                new Address("123 Main St", "Anytown", "Illinois", "66666"));
        List<Note> wineNotes = new ArrayList<Note>(Arrays.asList(new Note(IdGenerator.newID(), Calendar.getInstance().getTime(),
                "Totally delicious wine")));
        List<Wine> wines = new ArrayList<Wine>(Arrays.asList(new Wine(IdGenerator.newID(), "The Mission", wineNotes)));
        List<Shipment> ship = new ArrayList<Shipment>(Arrays.asList(new Shipment(IdGenerator.newID(), "Feb", "2014", DeliveryStatus.Delivered,
                SelectionType.AR, wines, "Tue", "AM")));
        List<Note> shipNotes = new ArrayList<Note>(Arrays.asList(new Note(IdGenerator.newID(), Calendar.getInstance().getTime(),"Great shipment")));
        ship.get(0).setNotes(shipNotes);
        sub1.setId(IdGenerator.newID());
        sub1.setShipments(ship);
        sub1.setDelivery(new Delivery("Tue", "AM"));
        subscribers.add(sub1);
    }

    @Test
    public void testCreateSubscriber() throws Exception {
        SubscriberRequest subReq = new SubscriberRequest("abc@google.com", "Ann Def", "7735552222", "AnnD", "AnnD",
                new Address("333 Main St", "Anytown", "Illinois", "66666"));
        IdErrorResponse response = action.createSubscriber(subscribers, subReq);
        assertTrue(response.getId() > 0);
        assertEquals(0, response.getErrors().size());
        assertEquals(2, subscribers.size());
    }

    @Test
    public void testCreateSubscriber1() throws Exception {
        SubscriberRequest subReq = new SubscriberRequest("abc@def.com", "Ann Def", "7735552222", "AnnD", "AnnD",
                new Address("333 Main St", "Anytown", "Illinois", "66666"));
        IdErrorResponse response = action.createSubscriber(subscribers, subReq);
        assertEquals(-1, response.getId());
        assertEquals(1, response.getErrors().size());
        assertEquals(1014, response.getErrors().get(0).getCode());
        assertEquals(1, subscribers.size());
    }

    @Test
    public void testCreateSubscriber2() throws Exception {
        SubscriberRequest subReq = new SubscriberRequest("abc@yahoo.com", "Ann Dee", "7735552222", "AnnD", "AnnD",
                new Address("333 Main St", "Anytown", "south dakota", "66666"));
        IdErrorResponse response = action.createSubscriber(subscribers, subReq);
        assertEquals(-1, response.getId());
        assertEquals(1, response.getErrors().size());
        assertEquals(1009, response.getErrors().get(0).getCode());
        assertEquals(1, subscribers.size());
    }

    @Test
    public void testCreateSubscriber3() throws Exception {
        SubscriberRequest subReq = new SubscriberRequest("abcyahoo.com", "Ann Dee", "7735552222", "AnnD", "AnnD",
                new Address("333 Main St", "Anytown", "IL", "66666"));
        IdErrorResponse response = action.createSubscriber(subscribers, subReq);
        assertEquals(-1, response.getId());
        assertEquals(1, response.getErrors().size());
        assertEquals(1003, response.getErrors().get(0).getCode());
        assertEquals(1, subscribers.size());
    }

    @Test
    public void testCreateSubscriber4() throws Exception {
        SubscriberRequest subReq = new SubscriberRequest("abc@yahoo.com", "Ann Dee", "7735552222", "AnnD", "AnnD",
                new Address("333 Main St", "Anytown", "", "66666"));
        IdErrorResponse response = action.createSubscriber(subscribers, subReq);
        assertEquals(-1, response.getId());
        assertEquals(1, response.getErrors().size());
        assertEquals(1008, response.getErrors().get(0).getCode());
        assertEquals(1, subscribers.size());
    }

    @Test
    public void testCreateSubscriber5() throws Exception {
        SubscriberRequest subReq = new SubscriberRequest("abcyahoo.com", "Ann Dee", "7735552222", "AnnD", "AnnD",
                new Address("333 Main St", "Anytown", "", "66666"));
        IdErrorResponse response = action.createSubscriber(subscribers, subReq);
        assertEquals(-1, response.getId());
        assertEquals(2, response.getErrors().size());
        assertEquals(1003, response.getErrors().get(0).getCode());
        assertEquals(1008, response.getErrors().get(1).getCode());
        assertEquals(1, subscribers.size());
    }

    @Test
    public void testUpdateSubscriber() throws Exception {
        int subId = subscribers.get(0).getId();
        SubscriberRequest subReq = new SubscriberRequest("abc@def.com", "Abc Def", "7735550000", "AD", "AbcD",
                new Address("123 Main St", "Anytown", "Illinois", "66666"));
        ErrorResponse response = action.updateSubscriber(subscribers,subReq,subId);
        assertEquals(response.getErrors().size(), 0);
        assertEquals(1, subscribers.size());
        assertEquals("7735550000", subscribers.get(0).getPhone());
    }

    @Test
    public void testUpdateSubscriber1() throws Exception {
        int subId = subscribers.get(0).getId();
        SubscriberRequest subReq = new SubscriberRequest("abc@def.com", "Abc Def", "7735551111", "AD", "AbcD",
                new Address("123 Main St", "Anytown", "Illinois", "66666"));
        ErrorResponse response = action.updateSubscriber(subscribers, subReq, subId + 1);
        assertEquals(1, response.getErrors().size());
        assertEquals(1, subscribers.size());
    }

    @Test
    public void testFindSubById() throws Exception {
        int subId = subscribers.get(0).getId();
        SubscriberResponse response = action.findSubById(subscribers, subId);
        assertEquals("Abc Def", response.getName());
        assertEquals("7735551111", response.getPhone());
        assertEquals("abc@def.com", response.getEmail());
    }

    @Test
    public void testFindSubById1() throws Exception {
        int subId = subscribers.get(0).getId();
        SubscriberResponse response = action.findSubById(subscribers, subId + 1);
        assertEquals(null, response);
    }

    @Test
    public void testGetShipmentsForSub() throws Exception {
        int subId = subscribers.get(0).getId();
        int shipId = subscribers.get(0).getShipments().get(0).getId();
        ShipmentsResponse response = action.getShipmentsForSub(subscribers, subId);
        assertEquals(1, response.getShipments().size());
        assertEquals(shipId, response.getShipments().get(0).getId());
    }

    @Test
    public void testGetShipmentDetailForSub() throws Exception {
        int subId = subscribers.get(0).getId();
        int shipId = subscribers.get(0).getShipments().get(0).getId();
        ShipmentDetailResponse response = action.getShipmentDetailForSub(subscribers, subId, shipId);
        assertEquals("Feb/2014", response.getSelection_month());
        assertEquals(DeliveryStatus.Delivered, response.getStatus());
        assertEquals(SelectionType.AR, response.getType());
    }

    @Test
    public void testGetShipmentDetailForSub2() throws Exception {
        int subId = subscribers.get(0).getId();
        int shipId = subscribers.get(0).getShipments().get(0).getId();
        ShipmentDetailResponse response = action.getShipmentDetailForSub(subscribers, subId, shipId+1);
        assertEquals(null, response);
    }

    @Test
    public void testUpdateShipmentDetails() throws Exception {
        int subId = subscribers.get(0).getId();
        int shipId = subscribers.get(0).getShipments().get(0).getId();
        ShipmentUpdateRequest shipUpReq = new ShipmentUpdateRequest("Mon", "PM");
        action.updateShipmentDetails(subscribers, subId, shipId, shipUpReq);
        assertEquals("Mon", subscribers.get(0).getShipments().get(0).getDeliveryDay());
        assertEquals("PM", subscribers.get(0).getShipments().get(0).getDeliveryTime());
    }

    @Test
    public void testGetShipmentNotes() throws Exception {
        int subId = subscribers.get(0).getId();
        int shipId = subscribers.get(0).getShipments().get(0).getId();
        NotesResponse response = action.getShipmentNotes(subscribers, subId, shipId);
        assertEquals(1, response.getNotes().size());
    }

    @Test
    public void testAddShipmentNote() throws Exception {
        int subId = subscribers.get(0).getId();
        int shipId = subscribers.get(0).getShipments().get(0).getId();
        AddNoteRequest addNoteReq = new AddNoteRequest("Awesome shipment");
        IdResponse response = action.addShipmentNote(subscribers, subId, shipId, addNoteReq);
        int noteId = subscribers.get(0).getShipments().get(0).getNotes().get(1).getId();
        assertEquals(noteId, response.getId());
    }

    @Test
    public void testGetShipmentNote() throws Exception {
        int subId = subscribers.get(0).getId();
        int shipId = subscribers.get(0).getShipments().get(0).getId();
        int noteId = subscribers.get(0).getShipments().get(0).getNotes().get(0).getId();
        Note shipNote = action.getShipmentNote(subscribers, subId, shipId, noteId);
        assertEquals("Great shipment", shipNote.getContent());
    }

    @Test
    public void testUpdateShipmentNote() throws Exception {
        int subId = subscribers.get(0).getId();
        int shipId = subscribers.get(0).getShipments().get(0).getId();
        int noteId = subscribers.get(0).getShipments().get(0).getNotes().get(0).getId();
        AddNoteRequest addNoteReq = new AddNoteRequest("The greatest shipment");
        action.updateShipmentNote(subscribers, subId, shipId, noteId, addNoteReq);
        assertEquals("The greatest shipment", subscribers.get(0).getShipments().get(0).getNotes().get(0).getContent());
    }

    @Test
    public void testDeleteShipmentNote() throws Exception {
        int subId = subscribers.get(0).getId();
        int shipId = subscribers.get(0).getShipments().get(0).getId();
        int noteId = subscribers.get(0).getShipments().get(0).getNotes().get(0).getId();
        action.deleteShipmentNote(subscribers, subId, shipId, noteId);
        assertEquals(0, subscribers.get(0).getShipments().get(0).getNotes().size());
    }

    @Test
    public void testGetWines() throws Exception {
        int subId = subscribers.get(0).getId();
        List<WineResponse> wineList = action.getWines(subscribers, subId);
        assertEquals(1, wineList.size());
    }

    @Test
    public void testGetWine() throws Exception {
        int subId = subscribers.get(0).getId();
        int wineId = subscribers.get(0).getShipments().get(0).getWines().get(0).getId();
        WineResponse response = action.getWine(subscribers, subId, wineId);
        assertEquals(wineId, response.getId());
        assertEquals("The Mission", response.getLabel_name());
    }

    @Test
    public void testGetWineNotes() throws Exception {
        int subId = subscribers.get(0).getId();
        int wineId = subscribers.get(0).getShipments().get(0).getWines().get(0).getId();
        int wineNoteId = subscribers.get(0).getShipments().get(0).getWines().get(0).getNotes().get(0).getId();
        NotesResponse response = action.getWineNotes(subscribers, subId, wineId);
        assertEquals(wineNoteId, response.getNotes().get(0).getId());
        assertEquals(1, response.getNotes().size());
    }

    @Test
    public void testAddWineNote() throws Exception {
        int subId = subscribers.get(0).getId();
        int wineId = subscribers.get(0).getShipments().get(0).getWines().get(0).getId();
        AddNoteRequest addNoteReq = new AddNoteRequest("Would buy more");
        IdResponse response = action.addWineNote(subscribers, subId, wineId, addNoteReq);
        int newNoteId = subscribers.get(0).getShipments().get(0).getWines().get(0).getNotes().get(1).getId();
        assertEquals(newNoteId, response.getId());
    }

    @Test
    public void testGetWineNote() throws Exception {
        int subId = subscribers.get(0).getId();
        int wineId = subscribers.get(0).getShipments().get(0).getWines().get(0).getId();
        int wineNoteId = subscribers.get(0).getShipments().get(0).getWines().get(0).getNotes().get(0).getId();
        Note theNote = action.getWineNote(subscribers, subId, wineId, wineNoteId);
        assertEquals("Totally delicious wine", theNote.getContent());
    }

    @Test
    public void testUpdateWineNote() throws Exception {
        int subId = subscribers.get(0).getId();
        int wineId = subscribers.get(0).getShipments().get(0).getWines().get(0).getId();
        int wineNoteId = subscribers.get(0).getShipments().get(0).getWines().get(0).getNotes().get(0).getId();
        AddNoteRequest addNoteReq = new AddNoteRequest("Delicious wine");
        action.updateWineNote(subscribers, subId, wineId, wineNoteId, addNoteReq);
        assertEquals("Delicious wine", subscribers.get(0).getShipments().get(0).getWines().get(0).getNotes().get(0).getContent());
    }

    @Test
    public void testDeleteWineNote() throws Exception {
        int subId = subscribers.get(0).getId();
        int wineId = subscribers.get(0).getShipments().get(0).getWines().get(0).getId();
        int wineNoteId = subscribers.get(0).getShipments().get(0).getWines().get(0).getNotes().get(0).getId();
        action.deleteWineNote(subscribers, subId, wineId, wineNoteId);
        assertEquals(0, subscribers.get(0).getShipments().get(0).getWines().get(0).getNotes().size());
    }

    @Test
    public void testGetDelivery() throws Exception {
        int subId = subscribers.get(0).getId();
        Delivery theDel = action.getDelivery(subscribers, subId);
        assertEquals("Tue", theDel.getDow());
        assertEquals("AM", theDel.getTod());
    }

    @Test
    public void testUpdateDelivery() throws Exception {
        int subId = subscribers.get(0).getId();
        Delivery updateDel  = new Delivery("Mon","PM");
        action.updateDelivery(subscribers,subId,updateDel);
        assertEquals("Mon", subscribers.get(0).getDelivery().getDow());
        assertEquals("PM", subscribers.get(0).getDelivery().getTod());
    }
}