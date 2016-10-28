package com.test.cache;

import java.io.Serializable;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EHCacheUtils {

	static CacheManager cacheManger = null;
	static{
		System.out.println(EHCacheUtils.class.getClassLoader().getResource("cacheConf.xml"));
		cacheManger = CacheManager.create(EHCacheUtils.class.getClassLoader().getResourceAsStream("cacheConf.xml"));
	}
	
	public static void put(String cachename,Serializable key ,Serializable value){
		cacheManger.getCache(cachename).put(new Element(key, value));
	}
	
	public static Serializable get(String cachename,Serializable key){
		Element e = cacheManger.getCache(cachename).get(key);
		if(e == null) return null;
		return e.getValue();
	}
}
