
package com.kangaroorozgar.partner.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Referral {

    @SerializedName("referral")
    @Expose
    private String referral;
    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("ride_otp")
    @Expose
    private String rideOtp;
    @SerializedName("ride_toll")
    @Expose
    private String rideToll;
    @SerializedName("online")
    @Expose
    private String online;

    public String getReferral() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRideOtp() {
        return rideOtp;
    }

    public void setRideOtp(String rideOtp) {
        this.rideOtp = rideOtp;
    }

    public String getRideToll() {
        return rideToll;
    }

    public void setRideToll(String rideToll) {
        this.rideToll = rideToll;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

}
