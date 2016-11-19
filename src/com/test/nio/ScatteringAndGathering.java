package com.test.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

/**
 * nio散射和聚集的学习
 * @author Administrator
 *
 */
public class ScatteringAndGathering {

	/**
	 * 聚集测试
	 */
	@Test
	public void gathering(){
		try {
			ByteBuffer bookbf = ByteBuffer.wrap("java性能优化技巧".getBytes("utf-8"));
			ByteBuffer authbf = ByteBuffer.wrap("葛一鸣".getBytes("utf-8"));
			
			int booklen = bookbf.limit();
			
			int authlen = authbf.limit();
			
			ByteBuffer[] bufs = new ByteBuffer[]{bookbf,authbf};
			File file = new File("c:\\geyiming.txt");
			
			if(file.exists())
				file.createNewFile();
			
			FileOutputStream fos = new FileOutputStream(file);
			FileChannel fc = fos.getChannel();
			fc.write(bufs);
			fos.close();
			fc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 散射测试
	 */
	@Test
	public void scattering(){
		try {
			ByteBuffer bookbf = ByteBuffer.wrap("java性能优化技巧".getBytes("utf-8"));
			ByteBuffer authbf = ByteBuffer.wrap("葛一鸣".getBytes("utf-8"));
			
			int booklen = bookbf.limit();
			
			int authlen = authbf.limit();
			ByteBuffer b1 = ByteBuffer.allocate(booklen);
			ByteBuffer b2 = ByteBuffer.allocate(authlen);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
