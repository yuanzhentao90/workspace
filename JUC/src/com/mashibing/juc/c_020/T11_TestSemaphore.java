package com.mashibing.juc.c_020;

import java.util.concurrent.Semaphore;

public class T11_TestSemaphore {

	public static void main(String[] args) {
//		Semaphore s = new Semaphore(2);//允许多少个线程同时执行，用于限流
		Semaphore s = new Semaphore(2, true);//秒杀时不能用公平锁，因为公平锁是先进先出后进后出
		
		new Thread(()->{
			try {
				s.acquire();
				System.out.println("t1 running");
				Thread.sleep(200);
				System.out.println("t1 running");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				s.release();
			}
		}).start();
		
		new Thread(()->{
			try {
				s.acquire();
				System.out.println("t2 running");
				Thread.sleep(200);
				System.out.println("t2 running");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				s.release();
			}
		}).start();
	}
	
}
