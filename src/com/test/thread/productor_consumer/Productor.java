package com.test.thread.productor_consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Productor implements Runnable {
	
	private volatile boolean isRunning = true;
	
	private BlockingQueue<PCData> queue;//内存缓冲区队列
	
	private static AtomicInteger count = new AtomicInteger();//总数原子操作
	
	private static final int SLEEPTIME = 1000;
	
	public Productor(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		PCData pcData = null;
		Random r = new Random();
		System.out.println("start productor id= "+Thread.currentThread().getId());
		try {
			while(isRunning){
				Thread.sleep(r.nextInt(SLEEPTIME));
				pcData = new PCData(count.incrementAndGet());//构造任务数据
				System.out.println(pcData + " is put into queue ");
				if(!queue.offer(pcData)){
					System.out.println("failed to put data:"+ pcData);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void stop(){
		isRunning = false;
	}

}
