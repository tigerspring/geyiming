package com.test.decorator;

public class TestMain {

	public static void main(String args[]){
		IPacketCreator pc = new PacketHTTPHeaderCreator(new PacketHTMLHeaderCreator(new PacketBodyCreator()));
		System.out.println(pc.handlerContent());;
	}
}
