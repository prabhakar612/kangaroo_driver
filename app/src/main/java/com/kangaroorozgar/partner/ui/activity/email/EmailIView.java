package com.kangaroorozgar.partner.ui.activity.email;

import com.kangaroorozgar.partner.base.MvpView;
import com.kangaroorozgar.partner.data.network.model.ForgotResponse;
import com.kangaroorozgar.partner.data.network.model.User;

public interface EmailIView extends MvpView {
    void onSuccess(User object);
    void onSuccess(ForgotResponse forgotResponse);



    void onError(Throwable e);
}
