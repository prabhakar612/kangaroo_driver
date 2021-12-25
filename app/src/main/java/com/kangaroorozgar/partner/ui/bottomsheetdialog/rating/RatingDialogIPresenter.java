package com.kangaroorozgar.partner.ui.bottomsheetdialog.rating;

import com.kangaroorozgar.partner.base.MvpPresenter;

import java.util.HashMap;

public interface RatingDialogIPresenter<V extends RatingDialogIView> extends MvpPresenter<V> {

    void rate(HashMap<String, Object> obj, Integer id);
}
