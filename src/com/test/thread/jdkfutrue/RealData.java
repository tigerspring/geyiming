package com.test.thread.jdkfutrue;

import java.util.concurrent.Callable;

public class RealData implements Callable<String>{

	private String para;
	
	public RealData(String para) {
		this.para = para;
	}

	@Override
	public String call() throws Exception {
		StringBuffer sbf = new StringBuffer();
		
		sbf.append(para);
		for(int i = 0 ; i < 10 ; i++){
			Thread.sleep(100);
		}
		return sbf.toString();
	}

}
