package com.test.subject.swing;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestMain {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton btn = new JButton("Click Me");
		btn.addActionListener(new BtnListener());
		
		frame.add(btn);
		frame.pack();
		frame.setVisible(true);
	}
}
