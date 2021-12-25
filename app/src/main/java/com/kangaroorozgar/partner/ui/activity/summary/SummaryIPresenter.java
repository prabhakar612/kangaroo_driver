package com.kangaroorozgar.partner.ui.activity.summary;


import com.kangaroorozgar.partner.base.MvpPresenter;

public interface SummaryIPresenter<V extends SummaryIView> extends MvpPresenter<V> {

    void getSummary(String data);
}
