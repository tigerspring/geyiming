package com.test.single;

import java.util.HashSet;
import java.util.Set;

public class SigletonTestClient implements Runnable{

	private Long currentTime = System.currentTimeMillis();
	
	private Set<SingletonUpdate> set = new HashSet<SingletonUpdate>();
	
	public static void main(String args[]){
		new Thread(new SigletonTestClient()).start();
		new Thread(new SigletonTestClient()).start();
		new Thread(new SigletonTestClient()).start();
		new Thread(new SigletonTestClient()).start();
		new Thread(new SigletonTestClient()).start();
		new Thread(new SigletonTestClient()).start();
		new Thread(new SigletonTestClient()).start();
		new Thread(new SigletonTestClient()).start();
		new Thread(new SigletonTestClient()).start();
		new Thread(new SigletonTestClient()).start();
	}

	@Override
	public void run() {
		for(int i = 0 ; i < 1000000000 ; i++)
//			Singleton.getInstance();
//			LazySingleton.getInstance();
			set.add(SingletonUpdate.getInstance());
		
		System.out.println("size="+set.size());
		System.out.println("spend:"+(System.currentTimeMillis()-currentTime)+"ms");
	}
}
