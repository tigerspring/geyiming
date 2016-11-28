package com.test.thread.productor_consumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<PCData> queue;
	private static final int SLEEPTIME = 1000;
	
	public Consumer(BlockingQueue<PCData> queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		System.out.println("start consumer id="+Thread.currentThread().getId());
		Random r = new Random();
		try {
			while(true){
				PCData  data = this.queue.take();
				if(null != data){
					int re = data.getIntData()*data.getIntData();
					System.out.println(MessageFormat.format("{0}*{1}={2}", data.getIntData(),data.getIntData(),re));
					Thread.sleep(r.nextInt(SLEEPTIME));
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
