package com.mashibing.juc;

import java.util.ArrayList;
import java.util.List;

/*
 * volatile只能保证线程的可见性不能保证原子性
 * volatile不能保证多个线程共同修改running变量时带来的不一致问题，
 * 也就是说volatile不能代替synchronize
 */
public class TestVolatile {

	volatile int count = 0;
	void m() {
		for (int i = 0; i < 10000; i++) {
			count ++;
		}
	}
	
	public static void main(String[] args) {
		TestVolatile t = new TestVolatile();
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
