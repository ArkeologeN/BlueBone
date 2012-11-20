package com.bluebone.core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.util.Log;

public class BBJsonParser {
	
	private static BBJsonParser _instance;
	
	public static BBJsonParser getInstance() {
		if (_instance instanceof BBJsonParser) {
			return _instance;
		} else {
			_instance = new BBJsonParser();
			return _instance;
		}
	}
	
	public String StreamToString(InputStream _stream) {
		String toReturn = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(_stream, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while (( line = reader.readLine()) != null) {
				sb.append(line);
			}
			_stream.close();
			
			toReturn =  sb.toString();
		} catch (Exception ex) {
			Log.v("Exception", ex.getMessage().toString());
		}
		return toReturn;
	}
}
