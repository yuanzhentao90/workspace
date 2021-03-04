package com.mashibing.juc.c01;

import java.util.concurrent.TimeUnit;

public class T {

	volatile boolean running = true;
	
	void m() {
		System.out.println(Thread.currentThread().getName()+"'s m method start");
		while(running) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"'s m method end");
	}
	
	public static void main(String[] args) {
		T t = new T();
		new Thread(t::m,"t1").start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.running = false;
	}
}
