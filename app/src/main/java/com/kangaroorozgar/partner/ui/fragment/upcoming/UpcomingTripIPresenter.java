package com.kangaroorozgar.partner.ui.fragment.upcoming;


import com.kangaroorozgar.partner.base.MvpPresenter;

public interface UpcomingTripIPresenter<V extends UpcomingTripIView> extends MvpPresenter<V> {

    void getUpcoming();

}
