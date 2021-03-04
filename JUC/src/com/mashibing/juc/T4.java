package com.mashibing.juc;

import java.util.concurrent.TimeUnit;

/*
 * ����ĳ������o�����o�����Է����仯����Ӱ������ʹ��
 * �����o�������һ�����������Ķ������ı�
 * Ӧ�ñ��⽫������������ñ������Ķ���(������һ������ʱ�����ö�������Ϊ���������ⱻ�޸�)
 */
public class T4 {

	final Object o = new Object();
	
	void m() {
		synchronized (o) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		T4 t = new T4();
		new Thread(t::m,"t").start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Thread t2 = new Thread(t::m,"t2");
		t2.start();
		
	}
	
}
