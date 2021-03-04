package com.mashibing.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T04_NotifyFreeLock {

	volatile List lists = new ArrayList<>();

	public void add(Object o) {
		lists.add(o);
	}

	public int size() {
		return lists.size();
	}

	public static void main(String[] args) {

		T04_NotifyFreeLock c = new T04_NotifyFreeLock();
		final Object lock = new Object();

		new Thread(() -> {
			synchronized (lock) {
				if (c.size() != 5) {
					System.out.println("t2����");
					try {
						lock.wait();// wait���ó���
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t2����");
//					lock.notify();
				}
			}
		}).start();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new Thread(()->{
			System.out.println("t1����");
			synchronized (lock) {
				for (int i = 0; i < 10; i++) {
					c.add(new Object());
					System.out.println("add "+i);
					if (c.size() == 5) {
						lock.notify();//notifyֻ�����Ѳ��ͷ���
						try {
							lock.wait();//�ͷ���
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		},"t1").start();
	}

}