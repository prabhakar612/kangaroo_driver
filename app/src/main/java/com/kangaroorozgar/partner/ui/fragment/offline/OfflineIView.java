package com.kangaroorozgar.partner.ui.fragment.offline;

import com.kangaroorozgar.partner.base.MvpView;

public interface OfflineIView extends MvpView {

    void onSuccess(Object object);
    void onError(Throwable e);
}
