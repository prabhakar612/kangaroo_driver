package com.kangaroorozgar.partner.ui.fragment.offline;

import com.kangaroorozgar.partner.base.MvpPresenter;

import java.util.HashMap;

public interface OfflineIPresenter<V extends OfflineIView> extends MvpPresenter<V> {

    void providerAvailable(HashMap<String, Object> obj);
}
