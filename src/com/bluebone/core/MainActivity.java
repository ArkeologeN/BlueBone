package com.bluebone.core;

import com.plumtree.bluebone.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	private BBWebView mWebView;
	private BBBootstrap mBootstrap;
	private ImageView mSplash;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mWebView = (BBWebView) findViewById(R.id.mMainView);
        mSplash = (ImageView) findViewById(R.id.splashView);
        mWebView.setAppId("bluebone");
        mWebView.enableJavaScript();
        this.mBootstrap = BBBootstrap.newFactoryInstance();
        this.mBootstrap.initContext(this);
        this.mBootstrap.initWebView(mWebView);
        this.mBootstrap.initWebViewClient(new BBWebViewChromeClient(mSplash, mWebView));
        this.mBootstrap.start();
    }
}