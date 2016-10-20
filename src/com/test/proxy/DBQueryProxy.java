package com.test.proxy;

/**
 * 代理类继承和目标类一样的接口,目的是为了对外暴露目标类的接口
 * @author Administrator
 *
 */
public class DBQueryProxy implements IDBQuery {
	
	private DBQuery realQuery = null;
	
	@Override
	public String request() {
		if(realQuery == null){
			realQuery = new DBQuery();
		}
		return realQuery.request();
	}
	
	
}
