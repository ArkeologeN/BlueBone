package com.bluebone.core;

import com.plumtree.bluebone.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class ChildActivity extends Activity {
	
	private BBWebView mWebView;
	private BBBootstrap mBootstrap;
	private ImageView mSplash;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.child);
		mWebView = (BBWebView) findViewById(R.id.mMainView2);
        mSplash = (ImageView) findViewById(R.id.splashView);
        mWebView.setAppId("bluebonechild");
        this.mBootstrap = BBBootstrap.newFactoryInstance();
        this.mBootstrap.initContext(this);
        this.mBootstrap.initWebView(mWebView);
        this.mBootstrap.initWebViewClient(new BBWebViewClient(mSplash, mWebView));
        this.mBootstrap.start();
	}
}
