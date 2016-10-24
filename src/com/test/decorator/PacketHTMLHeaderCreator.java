package com.test.decorator;

/**
 * 具体的装饰者：
 * 		具体实现了装饰的业务逻辑，即实现了被分离的各个增强功能点。
 * 		各个具体装饰者是可以相互叠加的，从而构成一个功能强大的组件对象
 * @author Administrator
 *
 */
public class PacketHTMLHeaderCreator extends PacketDecorator {

	public PacketHTMLHeaderCreator(IPacketCreator pc) {
		super(pc);
	}

	@Override
	public String handlerContent() {
		
		StringBuffer sb =new StringBuffer();
		sb.append("<HTML>\n");
		sb.append("<BODY>\n");
		sb.append(component.handlerContent()+"\n");
		sb.append("</BODY>\n");
		sb.append("</HTML>\n");
		
		return sb.toString();
	}


}
