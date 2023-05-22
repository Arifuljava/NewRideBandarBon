package com.meass.go_bandarbon;

public class OrderModel {
    String from,to,distance,datetime,status,time,
            uuid,phone,vechles,Order_price,useremail,drivername,driverphonenumber,paymentMethode,
            transcation,type,weight,assign_date,deliverydate;


    public OrderModel() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVechles() {
        return vechles;
    }

    public void setVechles(String vechles) {
        this.vechles = vechles;
    }

    public String getOrder_price() {
        return Order_price;
    }

    public void setOrder_price(String order_price) {
        Order_price = order_price;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getDriverphonenumber() {
        return driverphonenumber;
    }

    public void setDriverphonenumber(String driverphonenumber) {
        this.driverphonenumber = driverphonenumber;
    }

    public String getPaymentMethode() {
        return paymentMethode;
    }

    public void setPaymentMethode(String paymentMethode) {
        this.paymentMethode = paymentMethode;
    }

    public String getTranscation() {
        return transcation;
    }

    public void setTranscation(String transcation) {
        this.transcation = transcation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAssign_date() {
        return assign_date;
    }

    public void setAssign_date(String assign_date) {
        this.assign_date = assign_date;
    }

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
    }

    public OrderModel(String from, String to, String
            distance, String datetime, String status, String time,
                      String uuid, String phone, String vechles, String order_price, String useremail,
                      String drivername, String driverphonenumber, String paymentMethode, String transcation,
                      String type, String weight, String assign_date, String deliverydate) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.datetime = datetime;
        this.status = status;
        this.time = time;
        this.uuid = uuid;
        this.phone = phone;
        this.vechles = vechles;
        Order_price = order_price;
        this.useremail = useremail;
        this.drivername = drivername;
        this.driverphonenumber = driverphonenumber;
        this.paymentMethode = paymentMethode;
        this.transcation = transcation;
        this.type = type;
        this.weight = weight;
        this.assign_date = assign_date;
        this.deliverydate = deliverydate;
    }
}
