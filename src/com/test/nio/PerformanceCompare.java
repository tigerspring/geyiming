package com.test.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

/**
 * NIO性能比较
 * @author Administrator
 *
 */
public class PerformanceCompare {
	int numOfInts = 40000000;
	String PATH = "c:\\temp_stream";
	String NIOPATH = "c:\\nio_temp_stream";
	String NIOMAPPEDPATH = "c:\\nio_mapped_temp_stream";
	
	@Test
	public void streamTest(){
		long beginTime = System.currentTimeMillis();
		try {
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(PATH))));
			for(int i = 0 ; i < numOfInts ; i++){
				dos.writeInt(i);
			}
			if(dos!=null){
				dos.close();
			}
			System.out.println("写入时间："+(System.currentTimeMillis()-beginTime));
			
			beginTime = System.currentTimeMillis();
			DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(PATH))));
			for(int i = 0 ; i < numOfInts ; i++){
				dis.readInt();
			}
			if(dis!=null){
				dis.close();
			}
			System.out.println("读取时间："+(System.currentTimeMillis()-beginTime));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void nioTest(){
		try {
			long beginTime = System.currentTimeMillis();
			//代开文件输出流
			FileOutputStream fos = new FileOutputStream(new File(NIOPATH));
			//通过文件流打开通道
			FileChannel fc = fos.getChannel();
			//创建buffer
			ByteBuffer bbf = ByteBuffer.allocate(numOfInts*4);
			//向buffer写入数据
			for(int i = 0 ; i < numOfInts ; i ++){
				bbf.put(PerformanceCompare.int2bte(i));
			}
			bbf.flip();
			//通道把buffer里的内容写入到文件
			fc.write(bbf);
			System.out.println("nio写入时间："+(System.currentTimeMillis()-beginTime));
			
			beginTime = System.currentTimeMillis();
			FileInputStream fis = new FileInputStream(new File(NIOPATH));
			FileChannel fic = fis.getChannel();
			ByteBuffer bbif = ByteBuffer.allocate(numOfInts*4);
			fic.read(bbif);
			fic.close();
			bbif.flip();
			while(bbif.hasRemaining()){
				byte2int(bbif.get(),bbif.get(),bbif.get(),bbif.get());
			}
			System.out.println("nio读取时间："+(System.currentTimeMillis()-beginTime));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void mappedByteBuffer(){
		try {
			long beginTime = System.currentTimeMillis();
			FileChannel fc = new RandomAccessFile(new File(NIOMAPPEDPATH), "rw").getChannel();
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, numOfInts*4).asIntBuffer();
			for(int i = 0 ; i < numOfInts ; i++){
				ib.put(i);
			}
			if(fc != null){
				fc.close();
			}
			System.out.println("mapped nio写入时间："+(System.currentTimeMillis()-beginTime));
			
			beginTime = System.currentTimeMillis();
			FileChannel fcread = new RandomAccessFile(new File(NIOMAPPEDPATH), "rw").getChannel();
			IntBuffer ibreader = fcread.map(FileChannel.MapMode.READ_ONLY, 0, fcread.size()).asIntBuffer();
			while(ibreader.hasRemaining()){
				ibreader.get();
			}
			if(fcread != null){
				fcread.close();
			}
			System.out.println("mapped nio读取时间："+(System.currentTimeMillis()-beginTime));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static byte[] int2bte(int res){
		byte[] targets = new byte[4];
		targets[3] = (byte) (res & 0xff);
		targets[2] = (byte) ((res >> 8) & 0xff);
		targets[1] = (byte) ((res >> 16) & 0xff);
		targets[3] = (byte) (res >>> 24);
		return targets;
	}
	 	 	
	public static int byte2int(byte b1,byte b2,byte b3,byte b4){
		
		return (((b1 & 0xff)<<24)|((b2 & 0xff)<<16)|((b3 & 0xff)<<8)|(b4 & 0xff));
	}
	
}
