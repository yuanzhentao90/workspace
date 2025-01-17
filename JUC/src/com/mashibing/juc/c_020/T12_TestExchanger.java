package com.mashibing.juc.c_020;

import java.util.concurrent.Exchanger;

public class T12_TestExchanger {

	//exchanger只能执行在两个线程上
	static Exchanger<String> exchanger = new Exchanger<>();
	
	public static void main(String[] args) {
		new Thread(()->{
			String s = "t1";
			try {
				
				s = exchanger.exchange(s);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" "+s);
		},"T1").start();
		
		new Thread(()->{
			String s = "t2";
			try {
				
				s = exchanger.exchange(s);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" "+s);
		},"T2").start();
	}
	
}
