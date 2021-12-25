package com.kangaroorozgar.partner.ui.activity.splash;

import com.kangaroorozgar.partner.base.MvpPresenter;

import java.util.HashMap;

public interface SplashIPresenter<V extends SplashIView> extends MvpPresenter<V> {

    void handlerCall();

    void getPlaces();

    void checkVersion(HashMap<String, Object> map);

    void changeLanguage(String languageID);
}
