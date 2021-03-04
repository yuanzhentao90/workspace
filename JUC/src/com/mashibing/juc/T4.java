package com.mashibing.juc;

import java.util.concurrent.TimeUnit;

/*
 * 锁定某个对象o，如果o的属性发生变化，不影响锁的使用
 * 但如果o变成另外一个对象，则锁的对象发生改变
 * 应该避免将锁定对象的引用变成另外的对象。(在锁定一个对象时，将该对象声明为常量，避免被修改)
 */
public class T4 {

	final Object o = new Object();
	
	void m() {
		synchronized (o) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		T4 t = new T4();
		new Thread(t::m,"t").start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Thread t2 = new Thread(t::m,"t2");
		t2.start();
		
	}
	
}
