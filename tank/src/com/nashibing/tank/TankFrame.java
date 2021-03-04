package com.nashibing.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

	int x=375 , y=275;
	
	public TankFrame() {
		setSize(800, 600);
		setResizable(false);
		setTitle("Tank war");
		setVisible(true);
		
		//添加键盘监听
		addKeyListener(new MyKeyListener());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	//窗口重新绘制的时候会调用该方法
	@Override
	public void paint(Graphics g) {
		g.fillRect(x, y, 50, 50);
	}
	
	//键盘监听处理类
	class MyKeyListener extends KeyAdapter{
		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;
		//键被按下的时候调用
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;

			default:
				break;
			}
			repaint();
		}
		
		//键被抬起来的时候调用
		@Override
		public void keyReleased(KeyEvent e) {
//			System.out.println("key released");
		}
		
	}
	
}
