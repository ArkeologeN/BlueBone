package com.plumtree.bluebone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

public class BBConfList extends ArrayList<BBConf> implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	
	public BBConfList() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public void addConf(BBConf _conf) {
		this.add(_conf);
	}
	
	public ListIterator<BBConf> getConfs() {
		return this.listIterator();
	}
	
	public int getIndex(BBConf _conf) {
		if (this.contains(_conf)) {
			int j = 0;
			while (this.toArray() != null) {
				j++;
			}
			return j;
		} else {
			return -1;
		}
	}
	
	public BBConf getConf(int _index) {
		return this.get(_index);
	}
}
