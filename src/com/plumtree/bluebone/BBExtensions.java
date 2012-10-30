package com.plumtree.bluebone;

import java.util.ArrayList;
public class BBExtensions {
	
	public static ArrayList<String> extensions = new ArrayList<String>();
	private static BBExtensions _instance;
	
	private static void fillExtensions() {
		extensions.add("javascript");
		extensions.add("sensor");
		extensions.add("camera");
		extensions.add("opencv");
		extensions.add("geolocation");
		extensions.add("socketio");
		extensions.add("devicer");
		extensions.add("contacts");
		extensions.add("compass");
		extensions.add("database");
		extensions.add("pushnotify");
		extensions.add("texting");
		extensions.add("call");
	}
	
	public BBExtensions() {
		// TODO Auto-generated constructor stub
		fillExtensions();
	}
	
	public static BBExtensions getInstance() {
		if (_instance instanceof BBExtensions) {
			return _instance;
		} else {
			_instance = new BBExtensions();
			return _instance;
		}
	}
	
	public ArrayList<String> getExtensions() {
		return extensions;
	}
	
	public int getSize() {
		return extensions.size();
	}
	

}
