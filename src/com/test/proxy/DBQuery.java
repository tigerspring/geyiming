package com.test.proxy;

/**
 * 目标类继承需要对外暴露的接口
 * 
 * @author Administrator
 *
 */
public class DBQuery implements IDBQuery {
	
	public DBQuery() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String request() {
		return "request string";
	}

}
