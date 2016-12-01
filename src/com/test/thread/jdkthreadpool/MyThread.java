package com.test.thread.jdkthreadpool;

public class MyThread implements Runnable, Comparable<MyThread> {
	
	protected String name;
	
	public MyThread(){
		
	}
	
	public MyThread(String name){
		this.name = name;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100);
			System.out.println(name+"	");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int compareTo(MyThread o) {
		int me = Integer.parseInt(this.name.split("_")[1]);
		int other = Integer.parseInt(o.name.split("_")[1]);
		if(me > other){
			//me和other 升序   ： other，me
			return 1;
		}else if(me < other){
			//me和other降序 ： other,me
			return -1;
		}else{
			return 0;
		}
	}

}
