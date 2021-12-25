package com.kangaroorozgar.partner.ui.activity.splash;

import com.kangaroorozgar.partner.base.MvpView;
import com.kangaroorozgar.partner.data.network.model.CheckVersion;

public interface SplashIView extends MvpView {

    void verifyAppInstalled();

    void onSuccess(Object user);

    void onSuccess(CheckVersion user);

    void onError(Throwable e);

    void onLanguageChanged(Object object);
    void onCheckVersionError(Throwable e);
}
