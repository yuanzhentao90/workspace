package com.mashibing.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class T06_LockSupport {

	volatile List lists = new ArrayList<>();

	public void add(Object o) {
		lists.add(o);
	}

	public int size() {
		return lists.size();
	}
	
	public static void main(String[] args) {
	
		T06_LockSupport c = new T06_LockSupport();
		
		Thread t2 = new Thread(()->{
			System.out.println("t2 ����");
			if (c.size() != 5) {
				LockSupport.park();
			}
			System.out.println("t2 ����");
		},"t2");
		
		t2.start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(()->{
			System.out.println("t1 ����");
			
			for (int i = 0; i < 10; i++) {
				c.add(new Object());
				System.out.println("add "+i);
				if (c.size() == 5) {
					LockSupport.unpark(t2);
				}
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("t1 ����");
		},"t1").start();
	}
	
}
