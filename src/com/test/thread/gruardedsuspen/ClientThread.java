package com.test.thread.gruardedsuspen;

public class ClientThread extends Thread {

	private RequestQueue requestQueue;
	
	public ClientThread(RequestQueue requestQueue,String name){
		super(name);
		this.requestQueue = requestQueue;
	}
	
	public void run(){
		for(int i = 0 ; i < 10 ; i++){
			Request request = new Request("RequstID:"+i+"	ThreadName+"+Thread.currentThread().getName());
			
			System.out.println(Thread.currentThread().getName()+"	requests"+request);
			
			requestQueue.addRequest(request);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("RequstID:"+i+"	ThreadName+"+Thread.currentThread().getName()+"	request end");
		}
	}
}
