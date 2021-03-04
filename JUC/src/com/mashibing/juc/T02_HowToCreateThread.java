package com.mashibing.juc;

public class T02_HowToCreateThread {

	static class MyThread extends Thread{
		@Override
		public void run() {
			System.out.println("My thread.");
		}
	}
	
	static class MyRun implements Runnable{
		@Override
		public void run() {
			System.out.println("My runnable.");
		}
	}
	
	public static void main(String[] args) {
		new MyThread().start();
		new Thread(new MyRun()).start();
		new Thread(()->System.out.println("My runnable by Lambda.")).start();
	}
}
