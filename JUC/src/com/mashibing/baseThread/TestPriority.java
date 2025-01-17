package com.mashibing.baseThread;
/*
 * 线程优先级
 */
public class TestPriority {

	public static void main(String[] args) {
		Thread t1 = new Thread(new T1());
		Thread t2 = new Thread(new T2());
		t1.setPriority(Thread.NORM_PRIORITY+3);
		t1.start();
		t2.start();
		
		Thread t3 = new Thread(()->{
			for (int i = 0; i < 10; i++) {
				System.out.println("***********T3 : "+i);
			}
		});
		
		Thread t4 = new Thread(()->{
			for (int i = 0; i < 10; i++) {
				System.out.println("##########T4 : "+i);
			}
		});
		t3.setPriority(Thread.MIN_PRIORITY);
		t3.start();
		t4.start();
	}
	
}

class T1 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("----------T1 :"+i);
		}
	}
}

class T2 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("T2 :"+i);
		}
	}
}