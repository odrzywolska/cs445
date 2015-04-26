package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.data.IdGenerator;
import edu.iit.cs445.vin.model.Address;
import edu.iit.cs445.vin.model.Delivery;
import edu.iit.cs445.vin.model.Receipt;
import edu.iit.cs445.vin.model.Subscriber;
import edu.iit.cs445.vin.request.ReceiptRequest;
import edu.iit.cs445.vin.response.DeliveriesResponse;
import edu.iit.cs445.vin.response.IdResponse;
import edu.iit.cs445.vin.response.ReceiptResponse;
import edu.iit.cs445.vin.response.ReceiptsResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class DeliveryActionTest {

    List<Subscriber> subscribers;
    List<Receipt> recs;
    DeliveryAction action;

    @Before
    public void setUp() throws Exception {
        subscribers = new ArrayList<Subscriber>();
        action = new DeliveryAction();
        recs = new ArrayList<Receipt>();
        Subscriber sub1 = new Subscriber("abc@def.com", "Abc Def", "7735551111", "AD", "AbcD",
                new Address("123 Main St", "Anytown", "Illinois", "66666"));
        sub1.setId(IdGenerator.newID());
        sub1.setDelivery(new Delivery("Tue", "AM"));
        subscribers.add(sub1);
        Receipt rec = new Receipt(IdGenerator.newID(), "Abc Def", Calendar.getInstance().getTime(), sub1.getId());
        recs.add(rec);
    }

    @Test
    public void testGetDeliveries() throws Exception {
        DeliveriesResponse response = action.getDeliveries(subscribers);
        assertEquals("Abc Def", response.getDeliver_to().get(0).getName());
        assertEquals(1, response.getDeliver_to().size());
    }

    @Test
    public void testAddReceipt() throws Exception {
        ReceiptRequest rReq = new ReceiptRequest("Abc Def");
        IdResponse response = action.addReceipt(subscribers, recs, rReq);
        assertEquals(recs.get(1).getId(), response.getId());
    }

    @Test
    public void testGetReceipts() throws Exception {
        ReceiptsResponse response = action.getReceipts(recs);
        assertEquals(1, response.getReceipts().size());
    }

    @Test
    public void testGetReceipt() throws Exception {
        int recId = recs.get(0).getId();
        ReceiptResponse response = action.getReceipt(recs, recId);
        assertEquals(recId, response.getId());
    }
}