package com.test.decorator;

/**
 * 具体的组件：实现了核心接口的核心方法，完成某一具体的业务逻辑。也是被装饰着的对象
 * @author Administrator
 *
 */
public class PacketBodyCreator implements IPacketCreator {

	@Override
	public String handlerContent() {
		return "content of packet";
	}

}
