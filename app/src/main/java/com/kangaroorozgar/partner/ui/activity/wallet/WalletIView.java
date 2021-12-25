package com.kangaroorozgar.partner.ui.activity.wallet;

import com.kangaroorozgar.partner.base.MvpView;
import com.kangaroorozgar.partner.data.network.model.MoneyResponse;
import com.kangaroorozgar.partner.data.network.model.ServerStartWalletResponse;
import com.kangaroorozgar.partner.data.network.model.WalletMoneyAddedResponse;
import com.kangaroorozgar.partner.data.network.model.WalletResponse;

import java.util.List;

public interface WalletIView extends MvpView {

    void onSuccess(WalletResponse response);

    void onSuccess(WalletMoneyAddedResponse response);
    void onSuccess(List<ServerStartWalletResponse> object);
    void onSuccess(MoneyResponse object);

    void onError(Throwable e);
}
