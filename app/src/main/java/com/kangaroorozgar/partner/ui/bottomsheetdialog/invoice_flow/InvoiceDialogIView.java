package com.kangaroorozgar.partner.ui.bottomsheetdialog.invoice_flow;

import com.kangaroorozgar.partner.base.MvpView;

public interface InvoiceDialogIView extends MvpView {

    void onSuccess(Object object);
    void onError(Throwable e);
}
