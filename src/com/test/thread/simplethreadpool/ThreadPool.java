package com.test.thread.simplethreadpool;

import java.util.List;
import java.util.Vector;

public class ThreadPool {

	private static ThreadPool instance = null;
	//空闲线程队列
	private List<PThread> idleThreads;
	//已有线程数
	private int threadCounter;
	private boolean isShutdown = false;
	
	private ThreadPool(){
		this.idleThreads = new Vector<PThread>(5);
		this.threadCounter = 0;
	}
	
	public int getCreatedThreadCount(){
		return this.threadCounter;
	}
	
	//获取线程池实例
	public synchronized static ThreadPool getInstance(){
		if(instance == null){
			instance = new ThreadPool();
		}
		return instance;
	}
	
	//讲线程放入线程池中
	public synchronized void repool(PThread repoolingThread){
		if(!isShutdown){
			idleThreads.add(repoolingThread);
		}else{
			repoolingThread.shutDown();
		}
	}
	//停止线程中的所有线程
	public synchronized void shutDown(){
		isShutdown = true;
		for(int threadIndex = 0 ; threadIndex < idleThreads.size() ; threadIndex++){
			PThread pThread = (PThread)idleThreads.get(threadIndex);
			pThread.shutDown();
		}
	}
	//执行任务
	public synchronized void start(Runnable target){
		PThread pthread = null;
		if(idleThreads.size() > 0){
			int lastIndex = idleThreads.size() - 1;
			pthread = idleThreads.get(lastIndex);
			idleThreads.remove(lastIndex);
			pthread.setTarget(target);
		}
		//没有线程就创建一个线程
		else{
			threadCounter++;
			pthread = new PThread(target,"PThrad #"+threadCounter,this);
			pthread.start();
		}
	}
}
