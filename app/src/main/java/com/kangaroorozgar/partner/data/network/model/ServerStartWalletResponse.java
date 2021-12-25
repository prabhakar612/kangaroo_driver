
package com.kangaroorozgar.partner.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ServerStartWalletResponse {

    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("IPGList")
    @Expose
    private List<Object> iPGList = null;
    @SerializedName("OrderAmount")
    @Expose
    private String orderAmount;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("BAFCharge")
    @Expose
    private Boolean bAFCharge;
    @SerializedName("1LinkCharge")
    @Expose
    private Boolean _1LinkCharge;
    @SerializedName("Created_on")
    @Expose
    private String createdOn;
    @SerializedName("Order_Expire_After_Seconds")
    @Expose
    private Integer orderExpireAfterSeconds;
    @SerializedName("Click2Pay")
    @Expose
    private String click2Pay;
    @SerializedName("ConnectPayId")
    @Expose
    private String connectPayId;
    @SerializedName("FetchOrderType")
    @Expose
    private String fetchOrderType;
    @SerializedName("ConnectPayFee")
    @Expose
    private String connectPayFee;
    @SerializedName("OrderNumber")
    @Expose
    private String orderNumber;
    @SerializedName("ParityAmount")
    @Expose
    private String parityAmount;
    @SerializedName("IsParity")
    @Expose
    private Boolean isParity;
    @SerializedName("PayProId")
    @Expose
    private String payProId;
    @SerializedName("IsFeeApplied")
    @Expose
    private String isFeeApplied;
    @SerializedName("PayProFee")
    @Expose
    private String payProFee;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Object> getIPGList() {
        return iPGList;
    }

    public void setIPGList(List<Object> iPGList) {
        this.iPGList = iPGList;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getBAFCharge() {
        return bAFCharge;
    }

    public void setBAFCharge(Boolean bAFCharge) {
        this.bAFCharge = bAFCharge;
    }

    public Boolean get1LinkCharge() {
        return _1LinkCharge;
    }

    public void set1LinkCharge(Boolean _1LinkCharge) {
        this._1LinkCharge = _1LinkCharge;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getOrderExpireAfterSeconds() {
        return orderExpireAfterSeconds;
    }

    public void setOrderExpireAfterSeconds(Integer orderExpireAfterSeconds) {
        this.orderExpireAfterSeconds = orderExpireAfterSeconds;
    }

    public String getClick2Pay() {
        return click2Pay;
    }

    public void setClick2Pay(String click2Pay) {
        this.click2Pay = click2Pay;
    }

    public String getConnectPayId() {
        return connectPayId;
    }

    public void setConnectPayId(String connectPayId) {
        this.connectPayId = connectPayId;
    }

    public String getFetchOrderType() {
        return fetchOrderType;
    }

    public void setFetchOrderType(String fetchOrderType) {
        this.fetchOrderType = fetchOrderType;
    }

    public String getConnectPayFee() {
        return connectPayFee;
    }

    public void setConnectPayFee(String connectPayFee) {
        this.connectPayFee = connectPayFee;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getParityAmount() {
        return parityAmount;
    }

    public void setParityAmount(String parityAmount) {
        this.parityAmount = parityAmount;
    }

    public Boolean getIsParity() {
        return isParity;
    }

    public void setIsParity(Boolean isParity) {
        this.isParity = isParity;
    }

    public String getPayProId() {
        return payProId;
    }

    public void setPayProId(String payProId) {
        this.payProId = payProId;
    }

    public String getIsFeeApplied() {
        return isFeeApplied;
    }

    public void setIsFeeApplied(String isFeeApplied) {
        this.isFeeApplied = isFeeApplied;
    }

    public String getPayProFee() {
        return payProFee;
    }

    public void setPayProFee(String payProFee) {
        this.payProFee = payProFee;
    }

}
