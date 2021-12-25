package com.kangaroorozgar.partner.ui.bottomsheetdialog.invoice_flow;

import com.kangaroorozgar.partner.base.MvpPresenter;

import java.util.HashMap;

public interface InvoiceDialogIPresenter<V extends InvoiceDialogIView> extends MvpPresenter<V> {

    void statusUpdate(HashMap<String, Object> obj, Integer id);

}
