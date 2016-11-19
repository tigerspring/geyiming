package com.test.nio;

import java.nio.ByteBuffer;

/**
 * 缓冲区分片
 * @author Administrator
 *
 */
public class BufferSlice {

	public static void main(String args[]){
		BufferSlice.slice();
	}
	
	public static void slice(){
		ByteBuffer b = ByteBuffer.allocate(15);
		for(int i = 0; i < 10 ; i++){
			b.put((byte)i);
			
		}
		System.out.println(b);
		b.position(2);
		b.limit(6);
		ByteBuffer subBuffer = b.slice();
		
		for(int i = 0; i<subBuffer.capacity() ;i++){
			byte bb = subBuffer.get(i);
			bb*=10;
			subBuffer.put(i,bb);
		}
		
		b.position(0);
		b.limit(b.capacity());
		while(b.hasRemaining()){
			System.out.print(b.get()+"	");
		}
	}
}
