package com.bluebone.core;


import android.app.Activity;

public interface IBBBootstrap  {
	
	public void initContext(Activity act);
	public void initWebView(BBWebView webView);
	public void initWebViewClient(BBWebViewClient webViewClient);
	public void initWebViewClient(BBWebViewChromeClient webViewClient);
	public void initApplication(BBApplication app);
	public void start();
}
