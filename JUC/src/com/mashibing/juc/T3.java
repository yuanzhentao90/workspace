package com.mashibing.juc;

import java.util.concurrent.TimeUnit;

/*
 * ������ִ�й�������������쳣��Ĭ��������ᱻ�ͷţ����������̵߳õ�����������������
 * �ڴ�������쳣�ĵط�һ��Ҫtry����catch
 */
public class T3 {

	int count = 0;
	
	synchronized void m() {
		System.out.println(Thread.currentThread().getName()+" start");
		while (true) {
			count++;
			System.out.println(Thread.currentThread().getName()+" count :"+count);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (count == 5) {
				try {
					int i = count/0;
					System.out.println(i);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		T3 t3 = new T3();
		new Thread(t3::m,"t1").start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(()->t3.m(),"t2").start();
	}
	
}
