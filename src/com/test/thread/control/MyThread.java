package com.test.thread.control;

public class MyThread extends Thread {

	private volatile boolean stop = false;
//	private boolean stop = false;
	
	public void stopMe(){
		stop = true;
	}
	
	@Override
	public void run() {
		int i = 0; 
		while(!stop){
			i++;
		}
		System.out.println("Stop Thread");
	}
	
	public static void main(String args[]) throws InterruptedException{
		MyThread t = new MyThread();
		t.start();
		Thread.sleep(1000);
		t.stopMe();
		Thread.sleep(1000);
	}
}
