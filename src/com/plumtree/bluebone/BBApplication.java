package com.plumtree.bluebone;

public class BBApplication implements IApplication {
	
	private String _appName, _appVersion, _appDir,_appEntrance = null;
	private BBConfList mConfList = new BBConfList();

	@Override
	public void setApplicationName(String appName) {
		// TODO Auto-generated method stub
		this._appName = appName;
	}

	@Override
	public void setApplicationVersion(String appVer) {
		// TODO Auto-generated method stub
		this._appVersion = appVer;
	}

	@Override
	public void setApplicationDir(String appDir) {
		// TODO Auto-generated method stub
		this._appDir = appDir;
	}

	@Override
	public void setAppplicationEntrance(String appEntrance) {
		// TODO Auto-generated method stub
		this._appEntrance = appEntrance;
	}

	@Override
	public String getApplicationName() {
		// TODO Auto-generated method stub
		return this._appName;
	}

	@Override
	public String getApplicationVersion() {
		// TODO Auto-generated method stub
		return this._appVersion;
	}

	@Override
	public String getApplciationDir() {
		// TODO Auto-generated method stub
		return this._appDir;
	}

	@Override
	public String getApplicationEntrance() {
		// TODO Auto-generated method stub
		return this._appEntrance;
	}
	
	public void addAllToConfList(BBConfList _confSet) {
		this.mConfList.addAll(_confSet);
	}
	
	public void addToConfList(BBConf _conf) {
		this.mConfList.addConf(_conf);
	}
	
	public BBConf getFromConfList(int index) {
		return this.mConfList.get(index);
	}
	
	public int getConfListSize() {
		return mConfList.size();
	}
	
}
