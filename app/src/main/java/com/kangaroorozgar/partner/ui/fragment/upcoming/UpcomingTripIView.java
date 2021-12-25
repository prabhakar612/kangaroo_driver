package com.kangaroorozgar.partner.ui.fragment.upcoming;

import com.kangaroorozgar.partner.base.MvpView;
import com.kangaroorozgar.partner.data.network.model.HistoryList;

import java.util.List;

public interface UpcomingTripIView extends MvpView {

    void onSuccess(List<HistoryList> historyList);
    void onError(Throwable e);
}
