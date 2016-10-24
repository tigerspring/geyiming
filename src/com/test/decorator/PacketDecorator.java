package com.test.decorator;

/**
 * 装饰者：实现了组件接口并且持有一个具体的被装饰者对象
 * @author Administrator
 *
 */
public abstract class PacketDecorator implements IPacketCreator {
	
	IPacketCreator component = null;
	
	PacketDecorator(IPacketCreator pc){
		component = pc;
	}

	@Override
	public String handlerContent() {
		// TODO Auto-generated method stub
		return null;
	}

}
