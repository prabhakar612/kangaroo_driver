package com.kangaroorozgar.partner.ui.activity.earnings;


import com.kangaroorozgar.partner.base.MvpView;
import com.kangaroorozgar.partner.data.network.model.EarningsList;

public interface EarningsIView extends MvpView {

    void onSuccess(EarningsList earningsLists);

    void onError(Throwable e);
}
