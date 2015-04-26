package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.data.IdGenerator;
import edu.iit.cs445.vin.model.*;
import edu.iit.cs445.vin.model.Error;
import edu.iit.cs445.vin.request.AddNoteRequest;
import edu.iit.cs445.vin.request.ShipmentUpdateRequest;
import edu.iit.cs445.vin.request.SubscriberRequest;
import edu.iit.cs445.vin.response.*;

import java.util.*;

public class SubscriberAction {

    List<String> bannedStates = Arrays.asList("ALABAMA","ARKANSAS","DELAWARE","KENTUCKY","MASSACHUSETTS","MISSISSIPPI",
            "OKLAHOMA","PENNSYLVANIA","SOUTH DAKOTA","UTAH","AL","AK","DE","KY","MA","MS","OK","PA","SD","UT");

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public IdErrorResponse createSubscriber(Collection<Subscriber> subscribers, SubscriberRequest request){
        Subscriber subscriber = new Subscriber(
                request.getEmail(),
                request.getName(),
                request.getPhone(),
                request.getFacebook(),
                request.getTwitter(),
                request.getAddress()
        );

        List<Error> errors = checkValidSubscriber(subscriber);

        if(subscribers.contains(subscriber)){
            errors.add(new Error(1014, "An account with this email address exists"));
        }
        if(errors.size() == 0) {
            subscriber.setId(IdGenerator.newID());
            subscriber.setShipments(new ArrayList<Shipment>());
            subscriber.setDelivery(new Delivery("Tue","AM"));
            subscribers.add(subscriber);
            return new IdErrorResponse(subscriber.getId(), errors);
        }

        return new IdErrorResponse(-1, errors);
    }

    public ErrorResponse updateSubscriber(Collection<Subscriber> subscribers, SubscriberRequest request, int id){
        Subscriber subscriber = new Subscriber(
                request.getEmail(),
                request.getName(),
                request.getPhone(),
                request.getFacebook(),
                request.getTwitter(),
                request.getAddress()
        );

        List<Error> errors = checkValidSubscriber(subscriber);
        if(errors.size() > 0){
            return new ErrorResponse(errors);
        }

        for(Subscriber s:subscribers){
            if(s.getId() == id){
                s.setAddress(request.getAddress());
                s.setEmail(request.getEmail());
                s.setName(request.getName());
                s.setPhone(request.getPhone());
                s.setFacebook(request.getFacebook());
                s.setTwitter(request.getTwitter());
                return new ErrorResponse(errors);
            }
        }

        errors.add(new Error(301, "Subscriber ID " + id + " does not exist"));
        return new ErrorResponse(errors);
    }

    private List<Error> checkValidSubscriber(Subscriber subscriber){
        List<Error> errors = new ArrayList<Error>();
        if(subscriber.getName() == null || subscriber.getName().trim().isEmpty()){
            errors.add(new Error(1000, "Name must be provided"));
        }
        if(subscriber.getName().split(" ").length < 2){
            errors.add(new Error(1001, "Bad name"));
        }
        if(subscriber.getEmail() == null || subscriber.getEmail().trim().isEmpty()){
            errors.add(new Error(1002, "Email address must be provided"));
        }
        if(!subscriber.getEmail().matches(EMAIL_PATTERN)){
            errors.add(new Error(1003, "Invalid email address"));
        }
        if(subscriber.getAddress().getStreet()  == null || subscriber.getAddress().getStreet().trim().isEmpty()){
            errors.add(new Error(1004, "Address must be provided"));
        }
        if(subscriber.getAddress().getStreet().split(" ").length < 2){
            errors.add(new Error(1005, "Bad address"));
        }
        if(subscriber.getAddress().getCity()  == null || subscriber.getAddress().getCity().trim().isEmpty()){
            errors.add(new Error(1006, "City must be provided"));
        }
        if(subscriber.getAddress().getCity().length() < 3){
            errors.add(new Error(1007, "Bad city"));
        }
        if(subscriber.getAddress().getState() == null || subscriber.getAddress().getState().trim().isEmpty()){
            errors.add(new Error(1008, "State must be provided"));
        }
        if(bannedStates.contains(subscriber.getAddress().getState().toUpperCase())){
            errors.add(new Error(1009, "We may not ship to this state"));
        }
        if(subscriber.getAddress().getZip()  == null || subscriber.getAddress().getZip().trim().isEmpty()){
            errors.add(new Error(1010, "ZIP code must be provided"));
        }
        if(!subscriber.getAddress().getZip().matches("^\\d{5}(?:[-\\s]\\d{4})?$")){
            errors.add(new Error(1011, "Bad ZIP code"));
        }
        if(subscriber.getPhone()  == null || subscriber.getPhone().trim().isEmpty()){
            errors.add(new Error(1012, "Phone number must be provided"));
        }


        return errors;
    }

    public SubscriberResponse findSubById(Collection<Subscriber> subscribers, int id) {
        Subscriber s = this.findSubscriberById(subscribers, id);
        if(s == null)
            return null;

        return new SubscriberResponse(
                        s.getEmail(),
                        s.getName(),
                        s.getPhone(),
                        s.getFacebook(),
                        s.getTwitter(),
                        s.getAddress()
        );
    }

    private Subscriber findSubscriberById(Collection<Subscriber> subscribers, int id) {
        for(Subscriber s:subscribers){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }

    public ShipmentsResponse getShipmentsForSub(Collection<Subscriber> subscribers, int id) {
        List<Shipment> shipments = getShipmentsForSubDetail(subscribers, id);
        if(shipments == null)
            return null;
        List<ShipmentResponse> response = new ArrayList<ShipmentResponse>();
        for(Shipment s:shipments){
            response.add(new ShipmentResponse(s.getId(), s.getMonth() + "/" + s.getYear(), s.getDeliveryStatus()));
        }
        return new ShipmentsResponse(response);
    }

    public ShipmentDetailResponse getShipmentDetailForSub(Collection<Subscriber> subscribers, int id, int sid) {
        Shipment ship = findShipmentById(subscribers, id, sid);
        if(ship == null)
            return null;
        return new ShipmentDetailResponse(
                ship.getMonth() + "/" + ship.getYear(),
                ship.getDeliveryStatus(),
                ship.getSelectionType(),
                ship.getWines());
    }

    private List<Shipment> getShipmentsForSubDetail(Collection<Subscriber> subscribers, int id){
        Subscriber sub = this.findSubscriberById(subscribers, id);
        if(sub == null)
            return null;
        return sub.getShipments();
    }

    private Shipment findShipmentById(Collection<Subscriber> subscribers, int id, int sid){
        List<Shipment> shipments = getShipmentsForSubDetail(subscribers, id);
        if(shipments == null)
            return null;
        for(Shipment s:shipments){
            if(s.getId() == sid){
                return s;
            }
        }
        return null;
    }

    public DeliveryResponse updateShipmentDetails(Collection<Subscriber> subscribers, int id, int sid, ShipmentUpdateRequest request) {
        Shipment ship = findShipmentById(subscribers, id, sid);
        if(ship != null){
            ship.setDeliveryDay(request.getDelivery_day());
            ship.setDeliveryTime(request.getTime_of_day());
        }
        return new DeliveryResponse(id, new ArrayList<Error>(), request.getTime_of_day(), request.getDelivery_day(), sid);
    }

    public NotesResponse getShipmentNotes(Collection<Subscriber> subscribers, int id, int sid) {
        Shipment ship = findShipmentById(subscribers, id, sid);
        if(ship == null)
            return null;
        return new NotesResponse(ship.getNotes());
    }

    public IdResponse addShipmentNote(Collection<Subscriber> subscribers, int id, int sid, AddNoteRequest request) {
        Shipment ship = findShipmentById(subscribers, id, sid);
        if(ship == null)
            return null;
        Note note = new Note(IdGenerator.newID(), Calendar.getInstance().getTime(), request.getContent());
        ship.getNotes().add(note);
        return new IdResponse(note.getId());
    }

    public Note getShipmentNote(Collection<Subscriber> subscribers, int id, int sid, int nid) {
        Shipment ship = findShipmentById(subscribers, id, sid);
        if(ship == null)
            return null;
        for(Note n:ship.getNotes()){
            if(n.getId() == nid){
                return n;
            }
        }
        return null;
    }

    public void updateShipmentNote(Collection<Subscriber> subscribers, int id, int sid, int nid, AddNoteRequest request) {
        Note note = getShipmentNote(subscribers, id, sid, nid);
        if(note != null){
            note.setDate(Calendar.getInstance().getTime());
            note.setContent(request.getContent());
        }
    }

    public void deleteShipmentNote(Collection<Subscriber> subscribers, int id, int sid, int nid) {
        Shipment ship = findShipmentById(subscribers, id, sid);
        if(ship != null) {
            Iterator<Note> it = ship.getNotes().iterator();
            while (it.hasNext()) {
                if (it.next().getId() == nid) {
                    it.remove();
                    break;
                }
            }
        }
    }

    public List<WineResponse> getWines(Collection<Subscriber> subscribers, int id) {
        List<Shipment> shipments = getShipmentsForSubDetail(subscribers, id);
        if(shipments == null)
            return null;
        List<Wine> wines = new ArrayList<Wine>();
        for(Shipment s:shipments){
            wines.addAll(s.getWines());
        }

        List<WineResponse> wineResponses = new ArrayList<WineResponse>();
        for(Wine w:wines){
            wineResponses.add(new WineResponse(w.getId(),w.getLabel_name(),w.getNotes()));
        }

        return wineResponses;
    }

    public WineResponse getWine(Collection<Subscriber> subscribers, int id, int wid) {
        List<WineResponse> wines = getWines(subscribers, id);
        if(wines == null || wines.size() == 0)
            return null;
        for(WineResponse w:wines){
            if(w.getId() == wid){
                return w;
            }
        }
        return null;
    }

    public NotesResponse getWineNotes(Collection<Subscriber> subscribers, int id, int wid) {
        WineResponse wine = getWine(subscribers, id, wid);
        if(wine == null)
            return null;
        return new NotesResponse(wine.getNotes());
    }

    public IdResponse addWineNote(Collection<Subscriber> subscribers, int id, int wid, AddNoteRequest request) {
        WineResponse wine = getWine(subscribers, id, wid);
        if(wine == null)
            return null;
        Note note = new Note(IdGenerator.newID(), Calendar.getInstance().getTime(), request.getContent());
        wine.getNotes().add(note);
        return new IdResponse(note.getId());
    }

    public Note getWineNote(Collection<Subscriber> subscribers, int id, int wid, int nid) {
        WineResponse wine = getWine(subscribers, id, wid);
        if(wine == null)
            return null;
        for(Note n:wine.getNotes()){
            if(n.getId() == nid){
                return n;
            }
        }
        return null;
    }

    public void updateWineNote(Collection<Subscriber> subscribers, int id, int wid, int nid, AddNoteRequest request) {
        Note note = getWineNote(subscribers, id, wid, nid);
        if(note != null) {
            note.setDate(Calendar.getInstance().getTime());
            note.setContent(request.getContent());
        }
    }

    public void deleteWineNote(Collection<Subscriber> subscribers, int id, int wid, int nid) {
        WineResponse wine = getWine(subscribers, id, wid);
        if(wine != null) {
            Iterator<Note> it = wine.getNotes().iterator();
            while (it.hasNext()) {
                if (it.next().getId() == nid) {
                    it.remove();
                    break;
                }
            }
        }
    }

    public Delivery getDelivery(Collection<Subscriber> subscribers, int id) {
        Subscriber sub = findSubscriberById(subscribers, id);
        if(sub == null)
            return null;
        return sub.getDelivery();
    }

    public void updateDelivery(Collection<Subscriber> subscribers, int id, Delivery delivery) {
        Subscriber sub = findSubscriberById(subscribers, id);
        if(sub != null){
            sub.setDelivery(delivery);
        }

    }
}
