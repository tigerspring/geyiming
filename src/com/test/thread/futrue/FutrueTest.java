package com.test.thread.futrue;

/**
 * Futrue模式学习
 * @author Administrator
 *
 */
public class FutrueTest {

	public static void main(String args[]){
		Client client = new Client();
		
		Data data = client.requestData("name");
		System.out.println("请求完毕!");
		try {
			//这里用一个sleep代替其他的业务处理
			//在处理这些业务逻辑过程中，RealData被创建，从而充分利用了等待时间
			Thread.sleep(2000);
			System.out.println("obj1执行完毕！");
			Thread.sleep(2000);
			System.out.println("obj2执行完毕！");
			Thread.sleep(2000);
			System.out.println("obj3执行完毕！");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(data.getResult());
	}
}
