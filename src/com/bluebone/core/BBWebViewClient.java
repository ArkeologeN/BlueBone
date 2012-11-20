package com.bluebone.core;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class BBWebViewClient extends WebViewClient {
	
	private ImageView _imageView;
	private BBWebView _webView;
	private int _interval = 1000;
	
	public BBWebViewClient(ImageView imageView, BBWebView webView) {
		// TODO Auto-generated constructor stub
		this.setSplashImage(imageView);
		this.setWebView(webView);
	}
	
	public BBWebViewClient() {
		// TODO Auto-generated constructor stub
	}
	
	public BBWebViewClient(BBWebView webView) {
		this.setWebView(webView);
	}
	
	@Override
	public void onPageFinished(WebView view, String url) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(getDelayInterval());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this._imageView.setVisibility(View.GONE);
		this._webView.setVisibility(View.VISIBLE);
	}
	
	public void setSplashImage(ImageView imageView) {
		this._imageView = imageView;
	}
	
	public void setWebView(BBWebView webView) {
		this._webView = webView;
	}
	
	public BBWebView getWebView() {
		return this._webView;
	}
	
	public ImageView getSplashImage() {
		return this._imageView;
	}
	
	public void setDelayInterval(int interval) {
		this._interval = interval;
	}
	
	public int getDelayInterval() {
		return this._interval;
	}
}