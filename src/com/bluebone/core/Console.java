package com.bluebone.core;

import android.util.Log;

public class Console {
	
	private static Console _instance;
	//private static final String TAG_INFO = "Info";
	private static final String TAG_BLUEBONE = "Blue Bone Generated";
	//private static final String TAG_VERBOSE = "Verbose";
	//private static final String TAG_DEBUG = "Debugging";
	//private static final String TAG_ERROR = "Error";
	
	public static Console getInstance() {
		if ( !(_instance instanceof Console)) {
			_instance = new Console();
		}
		
		return _instance;
	}
	
	public static void Log(String str) {
		Log.e(TAG_BLUEBONE, str);
	}
	
	
	
}
