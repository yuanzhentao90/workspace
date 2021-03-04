package com.mashibing.juc.c_000;

import java.util.concurrent.TimeUnit;

public class T01_WhatIsThread {

	static class MyRun implements Runnable{
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					TimeUnit.MICROSECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("run");
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("===============方法调用===============");
		new MyRun().run();//单线程
		for (int i = 0; i < 10; i++) {
			try {
				TimeUnit.MICROSECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("main");
		}
		System.out.println("===============多线程===============");
		new Thread(new MyRun()).start();//多线程
		for (int i = 0; i < 10; i++) {
			try {
				TimeUnit.MICROSECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("main");
		}
	}
}
