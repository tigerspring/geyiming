package com.test.thread.productor_consumer;

/**
 * 不变模式
 * @author Administrator
 *
 */
public final class PCData {

	private final int intData;
	
	public PCData(int intData){
		this.intData =  intData;
	}

	public int getIntData() {
		return intData;
	}
	
	@Override
	public String toString() {
		return "data:"+intData;
	}
}
