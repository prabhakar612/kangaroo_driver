package com.kangaroorozgar.partner.ui.activity.wallet;

import com.kangaroorozgar.partner.base.MvpPresenter;

import java.util.HashMap;

public interface WalletIPresenter<V extends WalletIView> extends MvpPresenter<V> {

    void getWalletData();
    void addMoney(HashMap<String, Object> obj);

    void checkMoney(HashMap<String, Object> obj);
    void addServerWallet(String userType,String userId,String payment,String amount);

}
