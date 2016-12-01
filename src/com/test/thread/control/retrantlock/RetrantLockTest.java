package com.test.thread.control.retrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class RetrantLockTest {

	ReentrantLock lock = new ReentrantLock();
	private Runnable createTask(){
		return new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						if(lock.tryLock(500,TimeUnit.MICROSECONDS)){
							try{
								System.out.println("locked:"+Thread.currentThread().getName());
								Thread.sleep(1000);
							}finally{
								lock.unlock();
								System.out.println("unlocked:"+Thread.currentThread().getName());
							}
							break;
						}else{
							System.out.println("unable locked:"+Thread.currentThread().getName());
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		};
	}
}
