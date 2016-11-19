package com.test.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class MappedByteBufferTest {

	@Test
	public void mappedByteBufferTest(){
		try {
			RandomAccessFile raf = new RandomAccessFile(new File("C:\\cctvbiaojiegou.sql"), "rw");
			
			FileChannel fc = raf.getChannel();
			
			MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, raf.length());
			
			while(mbb.hasRemaining()){
				System.out.print((char)mbb.get());
			}
			
			mbb.put(0,(byte)98);
			raf.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
