package com.test.buffer;

import java.awt.Color;
import java.awt.Graphics;

public class BufferedMovingCircle extends NoBufferMovingCircle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4800910484135331103L;
	
	Graphics doubleBuffer = null;//缓冲区
	
	public void init(){
		super.init();
		doubleBuffer = screenImage.getGraphics();
	}

	public void paint(Graphics g){//使用缓冲区优化原来的paint方法
		doubleBuffer.setColor(Color.WHITE);//先在内存中画图
		doubleBuffer.fillRect(0, 0, 200, 100);
		drawCircle(doubleBuffer);
		g.drawImage(screenImage, 0, 0, this);//将buffer一次性展示出来
	}

}
