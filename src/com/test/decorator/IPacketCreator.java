package com.test.decorator;

/**
 * 装饰模式
 * 
 * 此组件是装饰者和别装饰着的接口，也可以定义为两者的父类。
 * 定义了被装饰者的核心功能和装饰者需要加强的功能点
 * @author Administrator
 *
 */
public interface IPacketCreator {

	/**
	 * 被装饰者的核心功能;
	 * 装饰者的需要增强的功能点
	 * @return
	 */
	public String handlerContent();
}
