package com.plumtree.bluebone;

import java.io.FileOutputStream;
import org.json.JSONObject;
import android.content.Context;

public class BBLogFileWriter implements IBBIo {
	
	private static BBLogFileWriter _instance;
	private FileOutputStream _fos;
	private Context _context;
	private BBAbstractLog _log;
	private final String FILE_NAME = "logbook";
	private BBAsyncLogTask mAsyncLogTask;
	
	public static BBLogFileWriter getInstance() {
		if (_instance instanceof BBLogFileWriter) {
			return _instance;
		} else {
			_instance = new  BBLogFileWriter();
			return _instance;
		}
	}
	
	public void setContext(Context context) {
		this._context = context;
	}
	
	public Context getContext() {
		return this._context;
	}
	
	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		try {
			_fos = this._context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
		} catch (Exception ex) {
			Console.Log(ex.getMessage());
		}
	}
	
	public void addToLogBook(BBAbstractLog log) {
		this._log = log;
		this.write();
	}
	/*
	 * 
	 */
	
	private void write() {
		try {
			JSONObject json_log = new JSONObject();
			this.mAsyncLogTask = new BBAsyncLogTask();
			if ( !this.mAsyncLogTask.isCancelled() ) {
				if (_log instanceof BBAbstractLog) {
					
					json_log.put("at", _log.getAt());
					json_log.put("message", _log.getMessage());
					if (_fos instanceof FileOutputStream) {
						this._fos.write(json_log.toString().getBytes());
					}
				}
				this.mAsyncLogTask
					.setFileWriter(_fos).execute(json_log).cancel(true);
			}
		} catch (Exception ex) {
			Console.Log(ex.getMessage());
		}
	}
}
