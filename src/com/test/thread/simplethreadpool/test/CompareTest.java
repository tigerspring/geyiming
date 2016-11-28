package com.test.thread.simplethreadpool.test;

import com.test.thread.simplethreadpool.ThreadPool;

public class CompareTest {

	public static void main(String args[]){
		Long beginTime = System.currentTimeMillis();
		for(int i = 0 ; i < 10000 ; i++){
			new Thread(new MyThread("testNoThreadPool"+Integer.toString(i))).start();
		}
		System.out.println("no thread pool time:"+(System.currentTimeMillis() - beginTime));
		
		beginTime = System.currentTimeMillis();
		for(int i = 0 ; i < 10000 ; i++){
			ThreadPool.getInstance().start(new MyThread("testNoThreadPool"+Integer.toString(i)));
		}
		System.out.println("no thread pool time:"+(System.currentTimeMillis() - beginTime));
	}
}
