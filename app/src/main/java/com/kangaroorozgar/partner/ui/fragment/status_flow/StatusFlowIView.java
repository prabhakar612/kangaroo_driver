package com.kangaroorozgar.partner.ui.fragment.status_flow;

import com.kangaroorozgar.partner.base.MvpView;
import com.kangaroorozgar.partner.data.network.model.TimerResponse;
import com.kangaroorozgar.partner.data.network.model.TripResponse;

public interface StatusFlowIView extends MvpView {

    void onSuccess(Object object);

    void onWaitingTimeSuccess(TimerResponse object);
    void onSuccess(TripResponse tripResponse);
    void onError(Throwable e);
}
