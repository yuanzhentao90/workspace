package com.mashibing.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T01_WithoutVolatitle {

	List lists = new ArrayList();
	
	public void add(Object o) {
		lists.add(o);
	}
	
	public int size() {
		return lists.size();
	}
	
	public static void main(String[] args) {
		T01_WithoutVolatitle c = new T01_WithoutVolatitle();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				Object o = new Object();
				c.add(o);
				System.out.println("add"+i);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t1").start();
		
		new Thread(()->{
			while (true) {
				if (c.size() == 5) {
					break;
				}
			}
			System.out.println("t2 ����");
		},"t2").start();
	}
	
}
