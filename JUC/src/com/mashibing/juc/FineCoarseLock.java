package com.mashibing.juc;

import java.util.concurrent.TimeUnit;

/*
 * ���Ż�
 * synchronized���������Խ��Խ��
 * ��ҵ���߼�������ϸ������Ƶ���������ڷ����ϰ����ֻ�
 */
public class FineCoarseLock {

	int count = 0;
	
	//�ֻ���
	synchronized void m1() {
		//ģ��ҵ���߼�
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count ++;
		//ģ��ҵ���߼�
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void m2() {
		//ģ��ҵ���߼�
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//ϸ����
		synchronized (this) {
			count++;
		}
		
		//ģ��ҵ���߼�
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
