package com.kangaroorozgar.partner;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import androidx.multidex.MultiDex;

import com.facebook.stetho.Stetho;
import com.kangaroorozgar.partner.common.LocaleHelper;
import com.kangaroorozgar.partner.data.network.model.HistoryDetail;
import com.kangaroorozgar.partner.data.network.model.HistoryList;
import com.kangaroorozgar.partner.data.network.model.Request_;
import com.kangaroorozgar.partner.data.network.model.TripResponse;
import com.yariksoffice.lingver.Lingver;


public class MvpApplication extends Application {

    public static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    public static float DEFAULT_ZOOM = 15;
    public static Location mLastKnownLocation ;

    private static MvpApplication mInstance;

    public static synchronized MvpApplication getInstance() {
        return mInstance;
    }

    public static Request_ DATUM = null;
    public static TripResponse tripResponse = null;
    public static Integer time_to_left = 60;
    public static HistoryList DATUM_history = null;
    public static HistoryDetail DATUM_history_detail = null;
    public static boolean isCash = true;
    public static boolean isCard = true;

    public static boolean isPayumoney;
    public static boolean isPaypal;
    public static boolean isPaytm;
    public static boolean isPaypalAdaptive;
    public static boolean isBraintree;

    public static boolean canGoToChatScreen;
    public static boolean isChatScreenOpen;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        mInstance = this;
        Lingver.init(this, "en");

    }

//    public static NumberFormat getNumberFormat() {
//        Locale locale = new Locale("pt", "BR");
//        Locale.setDefault(locale);
//
//        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
//        numberFormat.setCurrency(Currency.getInstance("BRL"));
//        numberFormat.setMinimumFractionDigits(0);
//        return numberFormat;
//    }
//
//    public String getNewNumberFormat(double d) {
//        return getNumberFormat().format(d);
//    }

    public String getNewNumberFormat(double d) {
        Double e = d;
        int i = e.intValue();
              String text = String.valueOf(i);
        //int text2 = d.intValue();

//        int integerPlaces = text.indexOf('.');
//        int decimalPlaces = text.length() - integerPlaces - 1;
//        if (decimalPlaces == 2) return text;
//        else if (decimalPlaces == 1) return text;
//        else if (decimalPlaces == 0) return text;
//        else if (decimalPlaces > 2) {
//            String converted = String.valueOf((double) Math.round(d * 100) / 100);
//            int convertedInegers = converted.indexOf('.');
//            int convertedDecimals = converted.length() - convertedInegers - 1;
//            if (convertedDecimals == 2) return converted;
//            else if (convertedDecimals == 1) return converted + "0";
//            else if (convertedDecimals == 0) return converted + ".00";
//            else return converted;
//        } else
            return text;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "en"));
        MultiDex.install(newBase);
    }

}
