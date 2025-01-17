package com.mashibing.juc.c_020;

import java.util.concurrent.TimeUnit;

/**
 * 可重入锁1
 * 可重入锁：当前线程两次申请同一把锁
 * @author Administrator
 *
 */
public class T01_ReentrantLock1 {

	synchronized void m1() {
		for (int i = 0; i < 10; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
			if (i == 5) m2();
		}
	}
	
	synchronized void m2() {
		System.out.println("m2");
	}
	
	public static void main(String[] args) {
		T01_ReentrantLock1 rl = new T01_ReentrantLock1();
		new Thread(rl::m1).start();
	}
}
