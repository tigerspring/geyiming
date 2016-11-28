package com.test.thread.simplethreadpool;

public class PThread extends Thread{
	
	//线程池
	private ThreadPool pool;
	//任务
	private Runnable target;
	private boolean isShutDown = false;
	private boolean isIdle = false;
	
	
	public PThread(Runnable target,String name,ThreadPool threadPool){
		super(name);
		this.pool = threadPool;
		this.target = target;
	}
	
	public Runnable getTarget(){
		return this.target;
	}
	
	public boolean isIdle(){
		return this.isIdle;
	}
	
	@Override
	public void run() {
		while(!isShutDown){
			isIdle = false;
			if(target != null){
				target.run();
			}
			//任务结束了，到闲置状态
			isIdle = true;
			try {
				pool.repool(this);
				synchronized(this){
					wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			isIdle = false;
		}
	}
	
	public synchronized void setTarget(Runnable newTarget){
		target = newTarget;
		//设置任务保存后，通知run方法，开始执行这个任务
		notifyAll();
	}
	
	public synchronized void shutDown(){
		isShutDown = true;
		notifyAll();
	}

}
