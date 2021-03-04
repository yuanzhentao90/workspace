package com.mashibing.juc;

import java.util.concurrent.TimeUnit;

/*
 * 锁优化
 * synchronized代码块的语句越少越好
 * 当业务逻辑中锁的细化过于频繁，可以在方法上把锁粗化
 */
public class FineCoarseLock {

	int count = 0;
	
	//粗化锁
	synchronized void m1() {
		//模拟业务逻辑
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count ++;
		//模拟业务逻辑
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void m2() {
		//模拟业务逻辑
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//细化锁
		synchronized (this) {
			count++;
		}
		
		//模拟业务逻辑
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
