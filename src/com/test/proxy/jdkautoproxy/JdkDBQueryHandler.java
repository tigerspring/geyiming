package com.test.proxy.jdkautoproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.test.proxy.DBQuery;
import com.test.proxy.IDBQuery;
/**
 * 这部分代码主要讲述怎么通过动态代理实现延迟加载	
 * @author Administrator
 *
 */
public class JdkDBQueryHandler implements InvocationHandler {

	IDBQuery real = null;
	
	/**
	 * 通过invoke方法实现延迟加载
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//延迟加载代码
		if(real == null){
			real = new DBQuery();
		}
		return real.request();
	}

	public static IDBQuery createJDKProxy(){
		//动态代理返回实现了IDBQuery的对象：newProxyInstance返回了实现了IDBQuery实例
		IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IDBQuery.class}, new JdkDBQueryHandler());
		return jdkProxy;
	}

}
