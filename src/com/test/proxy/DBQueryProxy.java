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
		//懒加载代码块儿,用到request请求时DBQuery才会进行加载
		if(realQuery == null){
			realQuery = new DBQuery();
		}
		return realQuery.request();
	}
	
	
}
