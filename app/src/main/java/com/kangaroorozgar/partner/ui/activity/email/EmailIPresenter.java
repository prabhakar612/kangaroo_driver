package com.kangaroorozgar.partner.ui.activity.email;

import com.kangaroorozgar.partner.base.MvpPresenter;

import java.util.HashMap;

public interface EmailIPresenter<V extends EmailIView> extends MvpPresenter<V>
{
    void login(HashMap<String, Object> obj);
    void forgot(HashMap<String, Object> obj);
}
