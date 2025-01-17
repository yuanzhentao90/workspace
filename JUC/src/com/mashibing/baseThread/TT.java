package com.mashibing.baseThread;
/*
 * m2没有加锁时，m1虽然被锁定，但是b变量仍然可以在m2中被修改，并且在m1方法中生效。
 */
public class TT implements Runnable{

	int b = 100;
	
	public synchronized void m1() {
		b = 1000;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" b = "+b);
	}
	
	public synchronized void m2() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		b = 2000;
		System.out.println(Thread.currentThread().getName()+b);
	}
	
	public static void main(String[] args) {
		TT tt = new TT();
		Thread t = new Thread(tt,"tt");
		t.start();
		
		tt.m2();
		System.out.println(tt.b);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		m1();
	}
}
