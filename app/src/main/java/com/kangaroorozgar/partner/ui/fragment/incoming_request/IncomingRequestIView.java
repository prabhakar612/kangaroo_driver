package com.kangaroorozgar.partner.ui.fragment.incoming_request;

import com.kangaroorozgar.partner.base.MvpView;

public interface IncomingRequestIView extends MvpView {

    void onSuccessAccept(Object responseBody);
    void onSuccessCancel(Object object);
    void onError(Throwable e);
}
