package com.kangaroorozgar.partner.ui.fragment.past;


import com.kangaroorozgar.partner.base.MvpView;
import com.kangaroorozgar.partner.data.network.model.HistoryList;

import java.util.List;

public interface PastTripIView extends MvpView {

    void onSuccess(List<HistoryList> historyList);
    void onError(Throwable e);
}
