package com.plumtree.bluebone;

public class BBConf {
	
	private String _name, _status;
	
	public BBConf() {
		// TODO Auto-generated constructor stub
	}
	
	public BBConf(String name, String status) {
		this._name = name;
		this._status = status;
	}
	
	
	public void setConfName(String name) {
		this._name = name;
	}
	
	public void setConfStatus(String status) {
		this._status = status;
	}
	
	public String getConfName() {
		return this._name;
	}
	
	public String getConfStatus() {
		return this._status;
	}
}
