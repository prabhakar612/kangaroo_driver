package com.kangaroorozgar.partner.ui.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kangaroorozgar.partner.R;
import com.kangaroorozgar.partner.base.BaseActivity;
import com.kangaroorozgar.partner.common.SharedHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity  extends BaseActivity {
    @BindView(R.id.web_view)
    WebView webView;

    String url= "";

    private  String  TAG = "WebViewActivity";
    @Override
    public int getLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    public void initView() {

        ButterKnife.bind(this);

        try{
            url = getIntent().getStringExtra("url");
            Log.d(TAG,"onCreate :"+url);
            //webView.loadUrl(BuildConfig.BASE_URL + "privacy");
            webView.loadUrl(url);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

            webView.setWebViewClient(new WebViewClient() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    Log.d(TAG,"override :"+request.getUrl().toString());
                    return super.shouldOverrideUrlLoading(view, request);
                }
               /* @Override
                public boolean shouldOverrideUrlLoading(WebView view, String urlNewString) {
                    Log.d(TAG,"override :"+url);
                    webView.loadUrl(urlNewString);

                    webView.loadUrl(request.getUrl().toString());
                    return true;
                }*/

               /* public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    Log.d(TAG,"override :"+request.getUrl().toString());
                    view.loadUrl(request.getUrl().toString());
                    return false;
                }*/

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    Log.d(TAG,"Started :"+url);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    Log.d(TAG,"finished :"+url);
                    if(url.contains("successfully")){
                        String orderId[] = url.split("ordId=");
                        SharedHelper.putKey(WebViewActivity.this,"orderId",orderId[1]);
                        Intent intent = new Intent();
                        intent.putExtra("add_money", true);
                        setResult(Activity.RESULT_OK, intent);

                        finish();



                    }
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
