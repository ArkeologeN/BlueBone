package com.bluebone.core;

public abstract class BBAbstractLog {
	
	public String _at, _message = "";
	
	protected void setAt(String at) {
		this._at = at;
	}
	
	protected void setMessage(String message) {
		this._message = message;
	}
	
	protected String getAt() {
		return this._at;
	}
	
	protected String getMessage() {
		return this._message;
	}
}
