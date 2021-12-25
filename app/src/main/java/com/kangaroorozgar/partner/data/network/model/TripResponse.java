package com.kangaroorozgar.partner.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TripResponse {

    @SerializedName("account_status")
    @Expose
    private String accountStatus;
    @SerializedName("service_status")
    @Expose
    private String serviceStatus;
    @SerializedName("requests")
    @Expose
    private List<Request> requests = null;

    @SerializedName("online")
    @Expose
    private String online;

    @SerializedName("provider_details")
    @Expose
    private Provider providerDetails;

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public Provider getProviderDetails() {
        return providerDetails;
    }

    public void setProviderDetails(Provider providerDetails) {
        this.providerDetails = providerDetails;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }
}
