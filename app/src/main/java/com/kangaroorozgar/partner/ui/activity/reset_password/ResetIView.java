package com.kangaroorozgar.partner.ui.activity.reset_password;

import com.kangaroorozgar.partner.base.MvpView;

public interface ResetIView extends MvpView{

    void onSuccess(Object object);
    void onError(Throwable e);
}
