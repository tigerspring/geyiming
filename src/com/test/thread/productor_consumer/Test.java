package com.test.thread.productor_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<PCData> queue = new LinkedBlockingQueue<PCData>();
		Productor productor1 = new Productor(queue);
		Productor productor2 = new Productor(queue);
		Productor productor3 = new Productor(queue);
		Consumer consumer1 = new Consumer(queue);
		Consumer consumer2 = new Consumer(queue);
		Consumer consumer3 = new Consumer(queue);
		
		ExecutorService excservice = Executors.newCachedThreadPool();
		excservice.execute(productor1);
		excservice.execute(productor2);
		excservice.execute(productor3);
		excservice.execute(consumer1);
		excservice.execute(consumer2);
		excservice.execute(consumer3);
		
		Thread.sleep(10*1000);
		
		productor1.stop();
		productor2.stop();
		productor3.stop();
		
		Thread.sleep(3000);
		excservice.shutdown();
		
	}
}
