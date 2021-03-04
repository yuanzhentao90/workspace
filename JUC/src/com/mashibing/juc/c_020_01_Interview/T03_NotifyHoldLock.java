package com.mashibing.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T03_NotifyHoldLock {

	volatile List lists = new ArrayList<>();
	
	public void add(Object o) {
		lists.add(o);
	}
	
	public int size() {
		return lists.size();
	}
	
	public static void main(String[] args) {
		T03_NotifyHoldLock c = new T03_NotifyHoldLock();
		
		final Object lock = new Object();
		
		new Thread(()->{
			synchronized (lock) {
				if (c.size() != 5) {
					System.out.println("t2����");
					try {
						lock.wait();//wait���ó���
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t2����");
				}
			}
		}).start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(()->{
			System.out.println("t1����");
			synchronized (lock) {
				for (int i = 0; i < 10; i++) {
					c.add(new Object());
					System.out.println("add "+i);
					if (c.size() == 5) {
						lock.notify();//notify���ͷ���
					}
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		},"t1").start();
	}
}