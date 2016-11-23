package com.test.thread.futrue;

/**
 * 封装了RealData
 * @author Administrator
 *
 */
public class FutrueData implements Data{

	protected RealData realData = null;
	protected Boolean isReady = false;
	public synchronized void setRealData(RealData realData) {
		if(isReady){
			return;
		}
		this.realData = realData;
		isReady = true;
		notifyAll();//RealData已经注入,通知getResult()
	}
	
	/**
	 * getResult会等待RealData构造完成
	 */
	@Override
	public synchronized String getResult() {
		while(!isReady){
			try {
				wait();//一直等待直到RealData被注入
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realData.result;
	}
}
