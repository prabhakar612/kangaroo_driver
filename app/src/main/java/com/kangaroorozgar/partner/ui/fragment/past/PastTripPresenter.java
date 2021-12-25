package com.kangaroorozgar.partner.ui.fragment.past;

import com.kangaroorozgar.partner.base.BasePresenter;
import com.kangaroorozgar.partner.data.network.APIClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PastTripPresenter<V extends PastTripIView> extends BasePresenter<V> implements PastTripIPresenter<V> {

    @Override
    public void getHistory() {
        getCompositeDisposable().add(APIClient
                .getAPIClient()
                .getHistory()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getMvpView()::onSuccess,getMvpView()::onError));
    }
}
