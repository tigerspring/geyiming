package com.test.thread.control.sync;

import java.util.ArrayList;
import java.util.List;

public class BlockQueue {

	private List<Object> list = new ArrayList<Object>();
	
	public synchronized Object pop() throws InterruptedException{
		while(list.size() == 0) wait();
		
		if(list.size() > 0){
			return list.remove(0);
		}else{
			return null;
		}
	}
	
	public synchronized void put(Object obj){
		list.add(obj);
		this.notify();
	}
}
