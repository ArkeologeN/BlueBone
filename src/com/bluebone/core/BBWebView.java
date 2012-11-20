package com.bluebone.core;

import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.plumtree.bluebone.R;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebView;

public class BBWebView extends WebView  implements ILogAction{
	
	private boolean _isLogFileWriter = false;
	public static BBApplication mBBApplication = new BBApplication();
	private static BBJsonParser mBBJsonParser = BBJsonParser.getInstance();
	private static BBExtensions mBBExceptions = BBExtensions.getInstance();
	private String _appId = null;

	public BBWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *  Enables JavaScript usage in Application
	 */
	public void enableJavaScript() {
		this.getSettings().setJavaScriptEnabled(true);
	}
	
	/**
	 *  Disables JavaScript usage in Application
	 */
	public void disabledJavaScript() {
		this.getSettings().setJavaScriptEnabled(false);
	}

	
	public void start() {
		getModuleDefinition();
	}
	
	public void setAppId(String appid) {
		this._appId = appid;
	}
	
	
	private void getModuleDefinition() {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document docDef = builder.parse(getResources().openRawResource(R.raw.definition));
			Element elem = docDef.getElementById(this._appId);
			if (elem.hasAttributes()) {
				mBBApplication.setApplicationName(elem.getAttribute("name"));
				mBBApplication.setApplicationDir(elem.getAttribute("dir"));
				mBBApplication.setApplicationVersion(elem.getAttribute("version"));
				mBBApplication.setAppplicationEntrance(elem.getAttribute("entrance"));
				JSONObject json_object = new JSONObject(mBBJsonParser.StreamToString(getResources().openRawResource(R.raw.acl)));
				JSONObject json_acl    = json_object.getJSONObject("acl");
				if ( json_acl.has(elem.getAttribute("id"))) {
					JSONObject json_component = json_acl.getJSONObject(elem.getAttribute("id"));
					Iterator<?> keys = json_component.keys();
					while (keys.hasNext()) {
						String key = (String) keys.next();
						if (mBBExceptions.getExtensions().contains(key.replace("allow:",""))) {
							loadModule(key.replace("allow:", ""));
							mBBApplication.addToConfList(new BBConf(key, json_component.getString(key).toString()));
						} else {
							// No ACL permission defined 
							Console.Log("Permission is not defined for "+key+ " in /res/raw/acl.js");
						}
					}
					this.loadUrl("file:///android_asset/"+mBBApplication.getApplciationDir()+"/"+mBBApplication.getApplicationEntrance());
				} else {
					// No ACL found
					Console.Log("ACL not configured properly in /res/raw/acl.js");
				}
			} else {
				// No Definition found
				Console.Log("No Module Definition found in /res/raw/definition.xml");
			}
			
		} catch (Exception ex) {
			Log.v("Error", ""+ ex.toString());
		}
	}
	
	public BBApplication getApplication() {
		return mBBApplication;
	}
	
	public void allowLogFileWriting(boolean perm) {
		this._isLogFileWriter = perm;
	}
	
	public boolean isLogFileWritable() {
		return this._isLogFileWriter;
	}

	@Override
	public void logAction(String at, String message) {
		// TODO Auto-generated method stub
		try {
			if (this.isLogFileWritable()) {
				BBLogFileWriter mLogWriter = BBLogFileWriter.getInstance();
				mLogWriter.prepare();
				mLogWriter.addToLogBook(new BBLog(at, message));
			}
		} catch (Exception ex) {
			Console.Log(ex.getMessage());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void loadModule(String name) {
		try {
			String formatted_name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
			Class c = Class.forName("com.plumtree.bluebone.jsi.JSI"+formatted_name);
			this.addJavascriptInterface(c, c.getSimpleName());		
		}  catch (ClassNotFoundException ex) {
			Console.Log("Class: "+name+" not found for "+ex.getMessage());
		}
	}
}
