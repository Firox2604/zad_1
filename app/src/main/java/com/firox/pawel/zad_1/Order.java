package com.firox.pawel.zad_1;

import java.io.Serializable;
import java.util.Calendar;

public class Order implements Serializable {
    private String order;
    private String time;
    private String paymentMethod;
    private String address;
    private String postalCode;
    private String city;
    private String email;
    private String phoneNumber;

    public Order(String order, String time, String paymentMethod, String address, String postalCode, String city, String email, String phoneNumber) {
        this.order = order;
        this.time = time;
        this.paymentMethod = paymentMethod;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Order() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order: ")
                .append(order)
                .append("\nTime of delivery: ")
                .append(time)
                .append("\nPayment method: ")
                .append(paymentMethod)
                .append("\nAddress :")
                .append("\n" + address)
                .append("\n" + postalCode + " ")
                .append("\n" + city)
                .append("\nContact:")
                .append("\n" + phoneNumber)
                .append("\n" + email);
        return sb.toString();
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
