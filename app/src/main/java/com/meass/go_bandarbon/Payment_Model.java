package com.meass.go_bandarbon;

public class Payment_Model {
    String payment_number,payment_methode,my_payment_number,pay,uuid,date,time;



    public String getPayment_number() {
        return payment_number;
    }

    public void setPayment_number(String payment_number) {
        this.payment_number = payment_number;
    }

    public String getPayment_methode() {
        return payment_methode;
    }

    public void setPayment_methode(String payment_methode) {
        this.payment_methode = payment_methode;
    }

    public String getMy_payment_number() {
        return my_payment_number;
    }

    public void setMy_payment_number(String my_payment_number) {
        this.my_payment_number = my_payment_number;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Payment_Model(String payment_number, String payment_methode,
                         String my_payment_number, String pay, String uuid, String date, String time) {
        this.payment_number = payment_number;
        this.payment_methode = payment_methode;
        this.my_payment_number = my_payment_number;
        this.pay = pay;
        this.uuid = uuid;
        this.date = date;
        this.time = time;
    }

    public Payment_Model() {
    }
}
