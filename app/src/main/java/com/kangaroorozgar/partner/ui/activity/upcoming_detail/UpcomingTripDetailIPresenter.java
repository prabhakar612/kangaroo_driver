package com.kangaroorozgar.partner.ui.activity.upcoming_detail;


import com.kangaroorozgar.partner.base.MvpPresenter;

public interface UpcomingTripDetailIPresenter<V extends UpcomingTripDetailIView> extends MvpPresenter<V> {

    void getUpcomingDetail(String request_id);

}
