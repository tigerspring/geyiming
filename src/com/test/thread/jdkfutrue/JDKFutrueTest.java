package com.test.thread.jdkfutrue;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class JDKFutrueTest {

	public static void main(String args[]) throws InterruptedException, ExecutionException{
		FutureTask<String>  ft = new FutureTask<String>(new RealData("a"));
		
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.submit(ft);
		
		System.out.println("请求完毕！");
		try {
			Thread.sleep(2000);
			System.out.println("obj1执行完毕！");
			Thread.sleep(2000);
			System.out.println("obj2执行完毕！");
			Thread.sleep(2000);
			System.out.println("obj3执行完毕！");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("返回的数据为："+ft.get());
		es.shutdown();
	}
}
