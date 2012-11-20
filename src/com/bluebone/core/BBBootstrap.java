package com.bluebone.core;

import android.app.Activity;

public class BBBootstrap implements IBBBootstrap {
	
	private BBWebView _webView;
	@SuppressWarnings("unused")
	private BBApplication _application = null;
	@SuppressWarnings("unused")
	private Activity _activity = null;
	
	public static BBBootstrap newFactoryInstance() {
		return new BBBootstrap();
	}

	@Override
	public void initContext(Activity act) {
		// TODO Auto-generated method stub
		this._activity = act;
	}

	@Override
	public void initWebView(BBWebView webView) {
		// TODO Auto-generated method stub
		this._webView = webView;
	}

	@Override
	public void initApplication(BBApplication app) {
		// TODO Auto-generated method stub
		this._application = app;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		try {
			if ( _webView instanceof BBWebView) {
				_webView.start();				
			}
		} catch (Exception ex) {
			Console.Log(ex.getMessage());
		}
	}

	@Override
	public void initWebViewClient(BBWebViewClient webViewClient) {
		// TODO Auto-generated method stub
		try {
			this._webView.setWebViewClient(webViewClient);
		} catch (Exception ex) {
			
		}
	}

	@Override
	public void initWebViewClient(BBWebViewChromeClient webViewClient) {
		// TODO Auto-generated method stub
		try {
			this._webView.setWebChromeClient(webViewClient);
		} catch (Exception ex) {
			
		}
	}

}
