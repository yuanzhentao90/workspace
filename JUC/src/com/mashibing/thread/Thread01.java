package com.mashibing.thread;

public class Thread01 {

	
	public static void main(String[] args) {
		RunnableImpl runnableImpl = new RunnableImpl();
		Thread thread = new Thread(runnableImpl);
		thread.start();
		for (int i = 0; i < 100; i++) {
			System.out.println("main"+i);
		}
	}
	
	
}

class RunnableImpl implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("runnable impl :"+i);
		}
	}
	
}
