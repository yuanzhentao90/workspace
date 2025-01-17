package com.mashibing.juc.c_020;

import java.util.concurrent.locks.ReentrantLock;

public class T05_ReentrantLock5 extends Thread{

	private static ReentrantLock lock = new ReentrantLock(true);//参数true表示为公平锁
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName()+"：第"+i+"次获得锁");
			} finally {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		T05_ReentrantLock5 rl = new T05_ReentrantLock5();
		Thread th1 = new Thread(rl,"th1");
		Thread th2 = new Thread(rl,"th2");
		Thread th3 = new Thread(rl,"th3");
		
		th1.start();
		th2.start();
		th3.start();
	}
	
}
