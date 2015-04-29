package edu.iit.cs445.vin.cli;

import edu.iit.cs445.vin.action.AdminAction;
import edu.iit.cs445.vin.action.DeliveryAction;
import edu.iit.cs445.vin.action.SubscriberAction;
import edu.iit.cs445.vin.data.*;
import edu.iit.cs445.vin.model.*;
import edu.iit.cs445.vin.request.*;
import edu.iit.cs445.vin.response.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CLIMain {

    @Option(name="-n")
    private String name = null;

    @Option(name="-e")
    private String email = null;

    @Option(name="-a")
    private String address = null;

    @Option(name="-c")
    private String city = null;

    @Option(name="-s")
    private String state = null;

    @Option(name="-z")
    private String zip = null;

    @Option(name="-h")
    private String phone = null;

    @Option(name="-f")
    private String facebookORfile = null;

    @Option(name="-t")
    private String twitter = null;

    @Option(name="-uid")
    private int uid = 0;

    @Option(name="-k")
    private String queryString = null;

    @Option(name="-dow")
    private String dow = null;

    @Option(name="-tod")
    private String tod = null;

    @Option(name="-sid")
    private int sid = 0;

    @Option(name="-nid")
    private int nid = 0;

    @Option(name="-aid")
    private int aid = 0;

    @Option(name="-mid")
    private int mid = 0;

    @Option(name="-rid")
    private int rid = 0;

    @Option(name="-wid")
    private int wid = 0;

    @Option(name="-m")
    private String message = null;

    @Argument
    private List<String> arguments = new ArrayList<String>();

    SubscriberAction subscriberAction = new SubscriberAction();
    AdminAction adminAction = new AdminAction();
    DeliveryAction deliveryAction = new DeliveryAction();

    public CLIMain(String[] args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.out.println("Error parsing line");
            e.printStackTrace();
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);

        AdminData.load();
        MonthlySelectionData.load();
        ReceiptData.load();
        SubscriberData.load();

        if(arguments.get(0).equals("subscriber")){
            if(arguments.get(1).equals("add")){
                IdErrorResponse response = subscriberAction.createSubscriber(SubscriberData.getSubscribers(),
                        new SubscriberRequest(email, name, phone, facebookORfile, twitter,
                                new Address(address, city, state, zip
                                )));
                System.out.println(mapper.writeValueAsString(response));
            }
            else if(arguments.get(1).equals("modify")){
                ErrorResponse response = subscriberAction.updateSubscriber(SubscriberData.getSubscribers(),
                        new SubscriberRequest(email, name, phone, facebookORfile, twitter,
                                new Address(address, city, state, zip)),
                        uid);
                System.out.println(mapper.writeValueAsString(response));
            }
            else if(arguments.get(1).equals("view")){
                SubscriberResponse response = subscriberAction.findSubById(SubscriberData.getSubscribers(), uid);
                System.out.println(mapper.writeValueAsString(response));
            }
            else if(arguments.get(1).equals("load")){
                SubscriberRequest request = mapper.readValue(new File(facebookORfile), SubscriberRequest.class);
                IdErrorResponse response = subscriberAction.createSubscriber(SubscriberData.getSubscribers(), request);
                System.out.println(mapper.writeValueAsString(response));
            }
        }
        else if(arguments.get(0).equals("shipments")){
            if(arguments.get(1).equals("view")){
                if(sid == 0){
                    ShipmentsResponse response = subscriberAction.getShipmentsForSub(SubscriberData.getSubscribers(), uid);
                    System.out.println(mapper.writeValueAsString(response));
                }
                else {
                    ShipmentDetailResponse response = subscriberAction.getShipmentDetailForSub(SubscriberData.getSubscribers(), uid, sid);
                    System.out.println(mapper.writeValueAsString(response));
                }
            }
            else if(arguments.get(1).equals("modify")){
                ShipmentUpdateRequest request = new ShipmentUpdateRequest(dow, tod);
                DeliveryResponse response = subscriberAction.updateShipmentDetails(SubscriberData.getSubscribers(), uid, sid, request);
                System.out.println(mapper.writeValueAsString(response));
            }
        }
        else if(arguments.get(0).equals("notes")){
            if(arguments.get(1).equals("view")){
                if(nid == 0){
                    NotesResponse response = subscriberAction.getShipmentNotes(SubscriberData.getSubscribers(), uid, sid);
                    System.out.println(mapper.writeValueAsString(response));
                }
                else{
                    Note response = subscriberAction.getShipmentNote(SubscriberData.getSubscribers(), uid, sid, nid);
                    System.out.println(mapper.writeValueAsString(response));
                }
            }
            else if(arguments.get(1).equals("add")){
                AddNoteRequest request = new AddNoteRequest(message);
                IdResponse response = subscriberAction.addShipmentNote(SubscriberData.getSubscribers(), uid, sid, request);
                System.out.println(mapper.writeValueAsString(response));
            }
            else if(arguments.get(1).equals("modify")){
                AddNoteRequest request = new AddNoteRequest(message);
                subscriberAction.updateShipmentNote(SubscriberData.getSubscribers(), uid, sid, nid, request);
            }
            else if(arguments.get(1).equals("delete")){
                subscriberAction.deleteShipmentNote(SubscriberData.getSubscribers(), uid, sid, nid);
            }
        }
        else if(arguments.get(0).equals("wines")){
            if(arguments.get(1).equals("view")){
                if(wid == 0){
                    List<WineResponse> response = subscriberAction.getWines(SubscriberData.getSubscribers(), uid);
                    System.out.println(mapper.writeValueAsString(response));
                }
                else{
                    WineResponse response = subscriberAction.getWine(SubscriberData.getSubscribers(), uid, wid);
                    System.out.println(mapper.writeValueAsString(response));
                }
            }
        }
        else if(arguments.get(0).equals("delivery")){
            if(arguments.get(1).equals("view")){
                Delivery response = subscriberAction.getDelivery(SubscriberData.getSubscribers(), uid);
                System.out.println(mapper.writeValueAsString(response));
            }
            else if(arguments.get(1).equals("modify")){
                Delivery newDel = new Delivery(dow, tod);
                subscriberAction.updateDelivery(SubscriberData.getSubscribers(), uid, newDel);
            }
        }
        else if(arguments.get(0).equals("admin")) {
            if (arguments.get(1).equals("revenue")) {
                RevenueResponse response = adminAction.getRevenue(SubscriberData.getSubscribers());
                System.out.println(mapper.writeValueAsString(response));
            } else if (arguments.get(1).equals("search")) {
                AdminResponse response = adminAction.getAdmin(AdminData.getAdmins(), aid);
                System.out.println(mapper.writeValueAsString(response));
            } else if (arguments.get(1).equals("add_monthly_selection")) {
                MonthlySelectionRequest request = mapper.readValue(new File(facebookORfile), MonthlySelectionRequest.class);
                IdResponse response = adminAction.addMonthlySelection(MonthlySelectionData.getMonthlySelections(), SubscriberData.getSubscribers(), request);
                System.out.println(mapper.writeValueAsString(response));
            } else if (arguments.get(1).equals("view_monthly_selection")) {
                if (mid == 0) {
                    MonthlySelectionsResponse response = adminAction.getMonthlySelections(MonthlySelectionData.getMonthlySelections());
                    System.out.println(mapper.writeValueAsString(response));
                } else {
                    MonthlySelectionDetailResponse response = adminAction.getMonthlySelection(MonthlySelectionData.getMonthlySelections(), mid);
                    System.out.println(mapper.writeValueAsString(response));
                }
            }
        }
        else if(arguments.get(0).equals("partner")){
            if(arguments.get(1).equals("subscriber_list")){
                DeliveriesResponse response = deliveryAction.getDeliveries(SubscriberData.getSubscribers());
                System.out.println(mapper.writeValueAsString(response));
            }
            else if(arguments.get(1).equals("add_receipt")){
                ReceiptRequest request = new ReceiptRequest(name);
                IdResponse response = deliveryAction.addReceipt(SubscriberData.getSubscribers(), ReceiptData.getReceipts(), request);
                System.out.println(mapper.writeValueAsString(response));
            }
            else if(arguments.get(1).equals("view_receipt")){
                if(rid == 0){
                    ReceiptsResponse response = deliveryAction.getReceipts(ReceiptData.getReceipts());
                    System.out.println(mapper.writeValueAsString(response));
                }
                else{
                    ReceiptResponse response = deliveryAction.getReceipt(ReceiptData.getReceipts(), rid);
                    System.out.println(mapper.writeValueAsString(response));
                }
            }
        }

        AdminData.save();
        MonthlySelectionData.save();
        ReceiptData.save();
        SubscriberData.save();
    }

    public static void main(String[] args) throws IOException {
        new CLIMain(args);
    }
}
