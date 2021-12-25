package com.kangaroorozgar.partner.ui.activity.regsiter;

import com.kangaroorozgar.partner.base.MvpView;
import com.kangaroorozgar.partner.data.network.model.SettingsResponse;
import com.kangaroorozgar.partner.data.network.model.User;

public interface RegisterIView extends MvpView {

    void onSuccess(User user);

    void onSuccess(Object verifyEmail);

    void onSuccess(SettingsResponse response);

    void onError(Throwable e);

    void onSuccessPhoneNumber(Object object);

    void onVerifyPhoneNumberError(Throwable e);

    void onVerifyEmailError(Throwable e);

}
