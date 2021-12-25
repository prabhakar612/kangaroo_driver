package com.kangaroorozgar.partner.ui.activity.add_card;

import com.kangaroorozgar.partner.base.MvpPresenter;

public interface AddCardIPresenter<V extends AddCardIView> extends MvpPresenter<V> {

    void addCard(String stripeToken);
}
