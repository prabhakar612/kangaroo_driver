package com.kangaroorozgar.partner.ui.activity.upcoming_detail;


import com.kangaroorozgar.partner.base.MvpView;
import com.kangaroorozgar.partner.data.network.model.HistoryDetail;

public interface UpcomingTripDetailIView extends MvpView {

    void onSuccess(HistoryDetail historyDetail);
    void onError(Throwable e);
}
