package com.test.thread.futrue;

public class Client {

	public FutrueData requestData(final String queryStr){
		final FutrueData futrue = new FutrueData();
		/**
		 * realdata创建很慢
		 * 所以在单独的线程中执行
		 */
		new Thread(){
			public void run() {
				RealData realData = new RealData(queryStr);
				futrue.setRealData(realData);
			};
		}.start();
		return futrue;//futruedata立即别返回
	}
}
