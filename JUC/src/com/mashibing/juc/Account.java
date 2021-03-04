package com.mashibing.juc;

import java.util.concurrent.TimeUnit;

/*
 * 模拟银行业务
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 这样容易造成脏读，解决方式：在读的方法上也加上synchronized关键字
 * 加锁之后的效率会大幅下降
 */
public class Account {

	private String name;
	
	private double balance;
	
	public synchronized void set(String name,double balance) {
		this.name = name;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.balance = balance;
	}
	
	public /*synchronized*/ double getBalance(String name) {
		return this.balance;
	}
	
	public static void main(String[] args) {
		Account a = new Account();
		new Thread(()->a.set("张三", 100.0)).start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(a.getBalance("张三"));
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(a.getBalance("张三"));	
	}
	
}
