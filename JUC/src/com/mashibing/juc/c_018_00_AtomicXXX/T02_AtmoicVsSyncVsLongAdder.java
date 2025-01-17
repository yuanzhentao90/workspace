package com.mashibing.juc.c_018_00_AtomicXXX;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
/*
 * CAS、synchronize、LongAdder三种不同加锁方式的效率
 */
public class T02_AtmoicVsSyncVsLongAdder {

	static long count2 = 0L;
	static AtomicLong count1 = new AtomicLong(0L);
	static LongAdder count3 = new LongAdder();
	
	public static void main(String[] args) throws InterruptedException {
		/*=================Atmoic Cas锁=================*/
		Thread[] threads = new Thread[1000];
		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(()->{
				for (int j = 0; j < 100000; j++) count1.incrementAndGet();
			});
		}
		
		long start = System.currentTimeMillis();
		for (Thread t : threads) t.start();
		for (Thread t : threads) t.join();
		long end = System.currentTimeMillis();
		System.out.println("Atomic: "+count1.get()+" time "+(end-start));
		/*=======================sync加锁=====================*/
		Object lock = new Object();
		for (int i = 0; i < threads.length; i++) {
//			threads[i] = new Thread(new Runnable() {
//				@Override
//				public void run() {
//					for(int k=0;k<100000;k++) {
//						synchronized (lock) {
//							count2++;
//						}
//					}
//				}
//			});
			threads[i] = new Thread(()->{
				for (int j = 0; j < 100000; j++) {
					synchronized (lock) {
						count2++;
					}
				}
			});
		}
		
		start = System.currentTimeMillis();
		for (Thread t : threads) t.start();
		for (Thread t : threads) t.join();
		end = System.currentTimeMillis();
		System.out.println("sync: "+count2+" time "+(end-start));
		/*================================================*/
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(()->{
				for (int j = 0; j < 100000; j++) {
					count3.increment();
				}
			});
		}
		start = System.currentTimeMillis();
		for (Thread t : threads) t.start();
		for (Thread t : threads) t.join();
		end = System.currentTimeMillis();
		System.out.println("LongAdder: "+count3.longValue()+" time "+(end-start));
	}
	
}
