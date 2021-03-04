package com.mashibing.juc;

import java.util.concurrent.TimeUnit;

/*
 * һ��ͬ���������Ե�����һ��ͬ��������һ�������Ѿ�ӵ��ĳ������������ٴ������ʱ����Ȼ��õ��ö������
 * Ҳ����˵synchronized��õ����ǿ������
 */
public class T2 {
	
	synchronized void m1() {
		System.out.println("m1 start");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		m2();
		System.out.println("m1 end");
	}
	
	synchronized void m2() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m2");
	}
	
	public static void main(String[] args) {
		new T2().m1();
	}
	
}