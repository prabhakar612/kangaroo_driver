package com.kangaroorozgar.partner.ui.activity.help;


import com.kangaroorozgar.partner.base.MvpPresenter;

public interface HelpIPresenter<V extends HelpIView> extends MvpPresenter<V> {

    void getHelp();
}
