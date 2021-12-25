package com.kangaroorozgar.partner.ui.activity.setting;

import com.kangaroorozgar.partner.base.MvpPresenter;

public interface SettingsIPresenter<V extends SettingsIView> extends MvpPresenter<V> {
    void changeLanguage(String languageID);
}
