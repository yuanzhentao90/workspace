package com.mashibing.baseThread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestInterrupt {
	public static void main(String[] args) {
		Thread t = new MyThread();
		t.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//���˯��
		t.interrupt();
	}
}

class MyThread extends Thread{
	@Override
	public void run() {
		while (true) {
			System.out.println(getName()+"******======"+new SimpleDateFormat().format(new Date()));
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(getName()+"����");
				return;
			}
		}
	}
}