package com.mashibing.juc;

import java.util.concurrent.TimeUnit;

/*
 * 一个同步方法可以调用另一个同步方法，一个对象已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁
 * 也就是说synchronized获得的锁是可重入的
 */
public class T2 {
	
	synchronized void m1() {
		System.out.println("m1 start");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		m2();
		System.out.println("m1 end");
	}
	
	synchronized void m2() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m2");
	}
	
	public static void main(String[] args) {
		new T2().m1();
	}
	
}