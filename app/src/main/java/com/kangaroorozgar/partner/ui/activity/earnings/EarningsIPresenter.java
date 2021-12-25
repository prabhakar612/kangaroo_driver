package com.kangaroorozgar.partner.ui.activity.earnings;


import com.kangaroorozgar.partner.base.MvpPresenter;

public interface EarningsIPresenter<V extends EarningsIView> extends MvpPresenter<V> {

    void getEarnings();
}
