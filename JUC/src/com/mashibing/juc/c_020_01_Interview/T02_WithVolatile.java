package com.mashibing.juc.c_020_01_Interview;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/*
 * 保证线程之间的可见性
 */
public class T02_WithVolatile {

	volatile List lists = Collections.synchronizedList(new LinkedList<>());
	
	public void add(Object o) {
		lists.add(o);
	}
	
	public int size() {
		return lists.size();
	}
	
	public static void main(String[] args) {
		T02_WithVolatile c = new T02_WithVolatile();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				Object o = new Object();
				c.add(o);
				System.out.println("add"+i);
//				try {
//					TimeUnit.SECONDS.sleep(1);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
		},"t1").start();
		
		new Thread(()->{
			while (true) {
				if (c.size() == 5) {
					break;
				}
			}
			System.out.println("t2 结束");
		},"t2").start();
	}
}
