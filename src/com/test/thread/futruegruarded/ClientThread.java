package com.test.thread.futruegruarded;

import java.util.ArrayList;
import java.util.List;

import com.test.thread.futrue.FutrueData;

public class ClientThread extends Thread {
	
	private RequestQueue requestQueue;
	private List<Request> myRequest = new ArrayList<Request>();

	public ClientThread(RequestQueue requestQueue,String name){
		super(name);
		this.requestQueue = requestQueue;
	}
	
	
	@Override
	public void run() {
		for(int i = 0 ; i < 10 ; i++){
			Request requset = new Request("RequsetID:"+i+" ThreadName:+"+Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName()+" requests:"+requset);
			requset.setResponse(new FutrueData());
			
			myRequest.add(requset);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(Request r: myRequest){
			System.out.println("ClientThread Name is:"+Thread.currentThread().getName()+" Response:"+r.getResponse().getResult());
		}
	}
}
