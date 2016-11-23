package com.test.thread.futrue;

public class RealData implements Data{

	protected final String result;
	
	/*
	 * RealData构造速度很慢
	 */
	public RealData(String queryStr) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 10 ; i++){
			sb.append(queryStr);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		result = sb.toString();
	}
	

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return result;
	}
	
}
