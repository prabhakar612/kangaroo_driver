
package com.kangaroorozgar.partner.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("DatePaid")
    @Expose
    private String datePaid;
    @SerializedName("AmountPayable")
    @Expose
    private Integer amountPayable;
    @SerializedName("OrderNumber")
    @Expose
    private String orderNumber;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("OrderStatus")
    @Expose
    private String orderStatus;
    @SerializedName("OrderAmountPaid")
    @Expose
    private Integer orderAmountPaid;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(String datePaid) {
        this.datePaid = datePaid;
    }

    public Integer getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Integer amountPayable) {
        this.amountPayable = amountPayable;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderAmountPaid() {
        return orderAmountPaid;
    }

    public void setOrderAmountPaid(Integer orderAmountPaid) {
        this.orderAmountPaid = orderAmountPaid;
    }

}
