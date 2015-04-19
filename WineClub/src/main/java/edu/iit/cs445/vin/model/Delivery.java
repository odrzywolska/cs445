package edu.iit.cs445.vin.model;

import edu.iit.cs445.vin.action.IdGenerator;
import edu.iit.cs445.vin.data.Properties;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by odrzy_000 on 4/3/2015.
 */
public class Delivery {
    private MonthlySelectionType mst;
    private int quantity;
    private Date deliveryDate;
    private Subscriber sub;
    private String note;
    private int deliveryId;
    private String firstName;
    private String lastName;
    private DeliveryStatus delStat;
    private Double price;

    public Delivery(Subscriber sub){
        this(sub, "");
    }

    public Delivery(Subscriber sub, String note){
        this.mst = MonthlySelectionType.RW;
        this.quantity = 1;
        this.sub = sub;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.WEEK_OF_MONTH, 1);
        cal.set(Calendar.DAY_OF_WEEK,1);
        cal.set(Calendar.HOUR, 12);
        cal.set(Calendar.MINUTE, 0);
        this.deliveryDate = cal.getTime();
        this.deliveryId = IdGenerator.newID();
        this.note = note;
        this.delStat = DeliveryStatus.Pending;
        this.price = Properties.DEFAULT_PRICE;
    }

    public Delivery(Subscriber sub, String note, Date date, MonthlySelectionType mst, int q){
        this.mst = mst;
        this.quantity = q;
        this.sub = sub;
        this.deliveryDate = date;
        this.note = note;
        this.deliveryId = IdGenerator.newID();
        this.delStat = DeliveryStatus.Pending;
        this.price = Properties.DEFAULT_PRICE;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public DeliveryStatus getDelStat() {
        return delStat;
    }

    public void setDeliveryDate(Date date){
        this.deliveryDate = date;
    }

    public void updateOrder(MonthlySelectionType mst, int q){
        this.mst = mst;
        this.quantity = q;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setSignature(String first, String last){
        this.firstName = first;
        this.lastName = last;
    }

    public void setDelStat(DeliveryStatus delStat){
        this.delStat = delStat;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public String getNote() {
        return note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Delivery)) return false;

        Delivery delivery = (Delivery) o;

        if (deliveryId != delivery.deliveryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return deliveryId;
    }
}
