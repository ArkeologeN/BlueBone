package com.bluebone.core;

public interface IApplication {
	
	public void setApplicationName(String appName);
	public void setApplicationVersion(String appVer);
	public void setApplicationDir(String appDir);
	public void setAppplicationEntrance(String appEntrance);
	
	public String getApplicationName();
	public String getApplicationVersion();
	public String getApplciationDir();
	public String getApplicationEntrance();
	
}
