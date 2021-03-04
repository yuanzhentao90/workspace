package com.mashibing.juc.c_018_00_AtomicXXX;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * 解决同样问题更高效的方法，使用AtomicXXX类，AtomicXXX类使用CAS保证线程安全
 * AtomicXXX类本身方法都是原子性，但无法保障多个方法连续调用都是原子性的。
 */

public class T01_AtomicInteger {

	AtomicInteger count = new AtomicInteger(0);
	
	void m() {
		for (int i = 0; i < 10000; i++) {
			count.incrementAndGet();
		}
	}
	
	public static void main(String[] args) {
		T01_AtomicInteger t = new T01_AtomicInteger();
		
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(t::m,"thread-"+i));
		}
		
		threads.forEach((o)->o.start());
		threads.forEach((o)->{
			try {
				o.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println(t.count);
	}
	
}
