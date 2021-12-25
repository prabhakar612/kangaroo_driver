package com.kangaroorozgar.partner.ui.fragment.dispute;

import com.kangaroorozgar.partner.base.MvpView;
import com.kangaroorozgar.partner.data.network.model.DisputeResponse;

import java.util.List;

public interface DisputeIView extends MvpView {

    void onSuccessDispute(List<DisputeResponse> responseList);

    void onSuccess(Object object);

    void onError(Throwable e);
}
