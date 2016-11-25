package com.test.thread.gruardedsuspen;

public class ServerThread extends Thread {

	private RequestQueue requestQueue;
	
	public ServerThread(RequestQueue requestQueue,String name){
		super(name);
		this.requestQueue = requestQueue;
	}
	
	public void run(){
		while(true){
			final Request request = requestQueue.getRequest();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"handles "+request);
		}
	}
}
