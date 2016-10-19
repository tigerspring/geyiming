package com.test.single;
/**
 * 非懒加载单例模式
 * @author Administrator
 *
 */
public class Singleton {

	private Singleton(){
		System.out.println("Singleton is create ");
	}
	
	public static Singleton instace = new Singleton();
	
	
	public static Singleton getInstance(){
		return instace;
	}
	
	public static void createString(){
		System.out.println("creating in Singleton");
	}
	
	public static void main(String args[]){
		Singleton.createString();
	}
}