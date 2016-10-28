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
		/*
		 *	代理类的内部逻辑 
		 */
		if(real == null){
			real = new DBQuery();
		}
		return real.request(); 
	}
	
	public static IDBQuery createCglibProxy(){
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(new CglibDbQueryInterceptor());//指定切入器,定义代理逻辑类
		enhancer.setInterfaces(new Class[]{IDBQuery.class});//指定实现的接口
		IDBQuery cglibproxy = (IDBQuery) enhancer.create();//生成代理类的实例
		return cglibproxy;
	}

}
