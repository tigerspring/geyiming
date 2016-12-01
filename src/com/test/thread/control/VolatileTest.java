package com.test.thread.control;

import org.junit.Test;

public class VolatileTest {

	volatile boolean isExit;
//	boolean isExit;
	
	public void tryExit(){
		if( isExit == !isExit){
			System.exit(0);
		}
	}
	
	public void swapValue(){
		isExit = !isExit;
	}
	
	@Test
	public void test() throws InterruptedException{
		final VolatileTest volObj = new VolatileTest();
		Thread mainThread = new Thread(){
			@Override
			public void run() {
				System.out.println("mainThread start");
				while(true){
					volObj.tryExit();
				}
			}
		};
		mainThread.start();
		Thread swapThread = new Thread(){
			public void run() {
				System.out.println("swapThread start");
				while(true){
					volObj.swapValue();
				}
			};
		};
		Thread.sleep(10000);
		swapThread.start();
		
	}
	
}
