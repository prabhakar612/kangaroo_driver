package com.kangaroorozgar.partner.ui.activity.notification_manager;

import com.kangaroorozgar.partner.base.MvpPresenter;

public interface NotificationManagerIPresenter<V extends NotificationManagerIView> extends MvpPresenter<V> {
    void getNotificationManager();
}
