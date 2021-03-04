package com.mashibing.baseThread;

/*
 * Í£Ö¹Ïß³Ì
 */
public class TestStopThread {

	public static void main(String[] args) {
		MyRunnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
		for (int i = 0; i < 1000; i++) {
			System.out.println("in thread main i = "+i);
		}
		System.out.println("Thread main over");
		r.shutdown();
	}
	
}

class MyRunnable implements Runnable{
	
	private boolean flag = true;
	
	@Override
	public void run() {
		int i = 0;
		while (flag) {
			System.out.println(" "+i++);
		}
	}
	
	public void shutdown() {
		this.flag = false;
	}
}