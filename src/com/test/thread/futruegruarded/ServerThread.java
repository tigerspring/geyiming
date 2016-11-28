package com.test.thread.futruegruarded;

import com.test.thread.futrue.FutrueData;
import com.test.thread.futrue.RealData;

public class ServerThread extends Thread {

	private RequestQueue reuqestQueue;
	
	public ServerThread(RequestQueue requestQueue,String name){
		super(name);
		this.reuqestQueue = requestQueue;
	}
	
	@Override
	public void run() {
		while(true){
			final Request request = this.reuqestQueue.getRequest();
			final FutrueData futrueData = (FutrueData) request.getResponse();
			
			RealData realData = new RealData(request.getName());
			futrueData.setRealData(realData);
			System.out.println(Thread.currentThread().getName()+"	handles:"+request);
		}
	}
}
