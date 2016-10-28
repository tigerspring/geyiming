package com.test.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BufferTest {
	
	static long CIRCLE = 100000;

	public static void main(String args[]){
		testFileWriter();
		
//		testBufferdWirter();
	}
	
	static void testFileWriter(){
		try {
			Writer writer = new FileWriter("C:\\Users\\Administrator\\Desktop\\mongoDB1.txt");
			
			long begin = System.currentTimeMillis();
			
			for(int i = 0 ; i < CIRCLE ; i ++){
				writer.write(i);
			}
			
			writer.close();
			
			System.out.println("testFileWriter spend: "+( System.currentTimeMillis() - begin)+"ms");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void testBufferdWirter(){
		try {
			Writer writer = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\mongoDB2.txt"));
			long begin = System.currentTimeMillis();
			for(int i = 0 ; i < CIRCLE ; i ++){
				writer.write(i);
			}
			writer.close();
			System.out.println("testBufferdWirter spend : "+ (System.currentTimeMillis() - begin)+"ms");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
