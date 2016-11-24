package com.test.thread.master_worker.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	//任务队列
	protected Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();
	//worker进程队列
	protected Map<String,Thread> threadMap = new HashMap<String,Thread>();
	//子任务处理结果集
	protected Map<String,Object> resultMap = new HashMap<String,Object>();
	//是否多有的子任务都结束了
	public boolean isComplete(){
		for(Map.Entry<String, Thread> entry : threadMap.entrySet()){
			if(entry.getValue().getState() != Thread.State.TERMINATED){
				return false;
			}
		}
		return true;
	}
	//master的构造,需要一个worker进程逻辑和需要的worker数量
	public Master(Worker worker,int countWorker){
		//TODO:构造方法没有完成
		worker.setWorkQueue(workQueue);
		worker.setResultMap(resultMap);
		
		for(int i = 0 ; i < countWorker ; i++){
			threadMap.put(Integer.toString(i), new Thread(worker,Integer.toString(i)));
		}
	}
	//提交一个任务
	public void submit(Object job){
		workQueue.add(job);
	}
	//返回任务结果集
	public Map<String,Object> getResultMap(){
		return resultMap;
	}
	
	//开始执行所有的worker进程,进行处理
	public void execute(){
		for(Map.Entry<String, Thread> entry : threadMap.entrySet()){
			entry.getValue().start();
		}
	}
}
