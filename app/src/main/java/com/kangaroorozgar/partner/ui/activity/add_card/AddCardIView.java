package com.kangaroorozgar.partner.ui.activity.add_card;

import com.kangaroorozgar.partner.base.MvpView;

public interface AddCardIView extends MvpView {

    void onSuccess(Object card);

    void onError(Throwable e);
}
