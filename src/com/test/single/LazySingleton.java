package com.test.single;
/**
 * 懒加载单利模式
 * @author Administrator
 *
 */
public class LazySingleton {

	private LazySingleton(){
		System.out.println("LazySingleton is created");
	}
	
	private static LazySingleton instance=null;
	
	/**
	 * 懒加载单例模式，加载单例方法必须是同步的，避免多线程环境下创建多个实例
	 */
	public static synchronized LazySingleton getInstance(){
		if(instance == null){
			instance = new LazySingleton();
		}
		return instance;
	}
	
	public static void createString(){
		System.out.println("createString in LazySingleton!");
	}
	
	public static void main(String args[]){
		LazySingleton.createString();
	}
}