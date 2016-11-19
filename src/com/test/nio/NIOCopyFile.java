package com.test.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOCopyFile {

	public static void main(String args[]){
		try {
//			NIOCopyFile.copyFile("C:\\Users\\Administrator\\Desktop\\金雪峰-目标管理评估表套表(定稿).xlsx", "C:\\金雪峰-目标管理评估表套表(定稿).xlsx");
//			NIOCopyFile.readWriteModelTest();
			NIOCopyFile.duplicateBuffer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 文本复制
	 * @param resource
	 * @param destination
	 * @throws IOException
	 */
	public static void copyFile(String resource ,String destination) throws IOException{
		FileInputStream fis = new FileInputStream(resource);
		FileOutputStream fos = new FileOutputStream(destination);
		
		FileChannel readChannel = fis.getChannel();
		FileChannel writeChannel = fos.getChannel();
		
		//使用buffer
		ByteBuffer bbf = ByteBuffer.allocate(1024);
		
		while(true){
			bbf.clear();
			int len = readChannel.read(bbf);
			if(len == -1){
				break;
			}
			bbf.flip();
			writeChannel.write(bbf);
		}
		readChannel.close();
		writeChannel.close();
		
	}
	
	public static void readWriteModelTest(){
		ByteBuffer b = ByteBuffer.allocate(12);
		System.out.println("limit:"+b.limit()+"	capacity:"+b.capacity()+"	position:"+b.position());
		for(int i = 0 ; i < 10; i++){
			b.put((byte)i);
		}
		System.out.println("limit:"+b.limit()+"	capacity:"+b.capacity()+"	position:"+b.position());
		b.flip();
		System.out.println("limit:"+b.limit()+"	capacity:"+b.capacity()+"	position:"+b.position());
		for(int i = 0 ; i < 5 ; i++){
			System.out.println(b.get());
		}
		System.out.println("limit:"+b.limit()+"	capacity:"+b.capacity()+"	position:"+b.position());
		b.flip();
		System.out.println("limit:"+b.limit()+"	capacity:"+b.capacity()+"	position:"+b.position());
		
		for(int i = 0; i < 10 ;i++){
			b.put((byte)(i));
		}
		System.out.println("limit:"+b.limit()+"	capacity:"+b.capacity()+"	position:"+b.position());
	}
	
	public static void duplicateBuffer(){
		ByteBuffer b = ByteBuffer.allocate(15);
		for(int i=0 ; i < 10;	i++){
			b.put((byte)i);
		}
		ByteBuffer c = b.duplicate();
		System.out.println("after duplicate b ");
		System.out.println("b:"+b);
		System.out.println("c:"+c);
		c.flip();
		System.out.println("after c.flip");
		System.out.println("b:"+b);
		System.out.println("c:"+c);
		
		c.put((byte)100);
		System.out.println("after c.put(byte 100)");
		System.out.println("b:"+b);
		System.out.println("c:"+c);
		System.out.println("b.get(0):"+b.get(0));
		System.out.println("c.get(0):"+c.get(0));
	}
}
