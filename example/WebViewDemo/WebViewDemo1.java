package com.example.WebViewDemo;

import android.graphics.Bitmap;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.application1.R;

public class WebViewDemo1 extends AppCompatActivity {

    WebView webView;
    Button button;
    Boolean flag=false;
    long backpress;
    LinearLayout mlayout;
    ProgressBar progressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_demo1);


        mlayout = findViewById(R.id.layout_main);
        button = (Button) findViewById(R.id.btn_click);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView = (WebView) findViewById(R.id.webview1);
                progressbar = (ProgressBar) findViewById(R.id.progressbar1);
                webView.loadUrl("https://www.amazon.com/");
                progressbar.setVisibility(View.VISIBLE);

                webView.setWebViewClient(new MyWebView());
            }
        });
    }

    @Override
    public void onBackPressed() {
//        if(backpress+2000>System.currentTimeMillis())
//        {
//            super.onBackPressed();
//            return;
//        }

        //showSnack();
        if(flag)
        {
            super.onBackPressed();
//            return;
        }
        flag = true;
        Snackbar snackbar = Snackbar.make(mlayout,"press back again",Snackbar.LENGTH_LONG);
        snackbar.show();
        Toast.makeText(this, "BACK AGAIN", Toast.LENGTH_SHORT).show();
        //backpress = System.currentTimeMillis();
    }
    private class MyWebView extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressbar.setVisibility(View.INVISIBLE);
            super.onPageFinished(view, url);

        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }
    }
}
