package com.mashibing.baseThread;

public class TestJoin {
	public static void main(String[] args) {
		Thread thread = new MyThread2("thread2");
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("I am main thread");
		}
	}
}

class MyThread2 extends Thread{
	public MyThread2(String s) {
		super(s);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("I am "+getName());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				return;	
			}
		}
	}
}