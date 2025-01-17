package com.mashibing.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class T13_TestLockSupport {

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			
			for (int i = 0; i < 10; i++) {
				if (i == 5) {
					LockSupport.park();
				}
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i);
			}
			
		});
		
		t.start();
//		try {
//			TimeUnit.SECONDS.sleep(15);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		LockSupport.unpark(t);
	}
	
}
