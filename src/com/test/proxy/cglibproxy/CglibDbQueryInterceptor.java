package com.test.proxy.cglibproxy;

import java.lang.reflect.Method;

import com.test.proxy.DBQuery;
import com.test.proxy.IDBQuery;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibDbQueryInterceptor implements MethodInterceptor{
	
	IDBQuery real = null;

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		if(real == null){
			real = new DBQuery();
		}
		return real.request();
	}
	
	public static IDBQuery createCglibProxy(){
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(new CglibDbQueryInterceptor());
		enhancer.setInterfaces(new Class[]{IDBQuery.class});
		IDBQuery cglibproxy = (IDBQuery) enhancer.create();
		return cglibproxy;
	}

}
