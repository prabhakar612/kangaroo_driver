package com.kangaroorozgar.partner.ui.fragment.past;


import com.kangaroorozgar.partner.base.MvpPresenter;

public interface PastTripIPresenter<V extends PastTripIView> extends MvpPresenter<V> {

    void getHistory();

}
