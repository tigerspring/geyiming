package com.test.thread.jdkthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args){
		ExecutorService service = new ThreadPoolExecutor(100, 200, 0L, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());
		
		for(int i = 0 ; i < 1000 ; i++){
			service.execute(new MyThread("testExecutorThreadPool3_"+Integer.toString(999 - i)));
		}
	}
}
