package com.test.cache;

import java.io.Serializable;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 动态代理类拦截的目标方法并且在intercept做了缓存的相关操作,
 * 屏蔽了客户端的缓存操作
 * 因此客户端使用目标方法是无需关心缓存相关的操作
 * @author Administrator
 *
 */
public class CglibHeavyMethodInterceptor implements MethodInterceptor {

	HeavyMethodDemo real = new HeavyMethodDemo();
	/**
	 * 被屏蔽的缓存相关操作
	 */
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		//查询缓存
		String v = (String) EHCacheUtils.get("cache1", (Serializable) arg2[0]);
		if(v == null){
			v = real.heayMethod((Integer)arg2[0]);//缓存中未找到结果
			EHCacheUtils.put("cache1", (Serializable) arg2[0], v);//保存计算结果
		}
		return v;
	}

	/**
	 * 带有缓存功能的类
	 * @return
	 */
	public static HeavyMethodDemo newCacheHeavyMethod(){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(HeavyMethodDemo.class);
		enhancer.setCallback(new CglibHeavyMethodInterceptor());//设置缓存逻辑
		HeavyMethodDemo cglibProxy = (HeavyMethodDemo) enhancer.create();
		return cglibProxy;
	}
	/**
	 * 不带有缓存的类
	 * @return
	 */
	public static HeavyMethodDemo newHeavyMethod(){
		return new HeavyMethodDemo();
	}
	
	public static void main(String args[]){
		HeavyMethodDemo m = newCacheHeavyMethod();
		long begin = System.currentTimeMillis();
		for(int i = 0 ; i < 1000000 ; i ++){
			m.heayMethod(2147483646);
		}
//		System.out.println(m.heayMethod(2147483646));
		System.out.println("cache method spend : "+ (System.currentTimeMillis() - begin)+"ms");
		
		m = newHeavyMethod();
		begin = System.currentTimeMillis();
		for(int i = 0 ; i < 1000000 ; i++){
			m.heayMethod(2147483646);
		}
//		System.out.println(m.heayMethod(2147483646));
		System.out.println("no cache method spend : "+ (System.currentTimeMillis() - begin)+"ms");
	}
}
