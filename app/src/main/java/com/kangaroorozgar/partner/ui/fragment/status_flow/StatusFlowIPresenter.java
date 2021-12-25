package com.kangaroorozgar.partner.ui.fragment.status_flow;

import com.kangaroorozgar.partner.base.MvpPresenter;

import java.util.HashMap;

public interface StatusFlowIPresenter<V extends StatusFlowIView> extends MvpPresenter<V> {

    void statusUpdate(HashMap<String, Object> obj, Integer id);

    void waitingTime(String time, String requestId);

    void getTrip(HashMap<String, Object> params);

    void checkWaitingTime(String requestId);
}
