package com.kangaroorozgar.partner.ui.activity.wallet_detail;

import com.kangaroorozgar.partner.base.MvpPresenter;
import com.kangaroorozgar.partner.data.network.model.Transaction;

import java.util.ArrayList;

public interface WalletDetailIPresenter<V extends WalletDetailIView> extends MvpPresenter<V> {
    void setAdapter(ArrayList<Transaction> myList);
}
