package com.plumtree.bluebone;

import java.io.FileOutputStream;

import org.json.JSONObject;

import android.os.AsyncTask;

public class BBAsyncLogTask extends AsyncTask<JSONObject, Integer, Boolean> {
	
	private FileOutputStream _fos;
	private boolean _done = false;
	
	@Override
	protected Boolean doInBackground(JSONObject... args) {
		// TODO Auto-generated method stub
		try {
			JSONObject json = args[0];
			if ( json.has("at") && json.has("message")) {
				this._fos.write(json.toString().getBytes());
				this._done = true;
			}
		} catch (Exception ex) {
			
		}
		return this._done;
	}
	
	public BBAsyncLogTask setFileWriter(FileOutputStream fos) {
		this._fos = fos;
		return this;
	}
	
	public FileOutputStream getFileWriter() {
		return this._fos;
	}
	
	public boolean done() {
		return this._done;
	}
	

}
