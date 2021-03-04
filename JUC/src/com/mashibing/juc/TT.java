package com.mashibing.juc;

import java.util.concurrent.TimeUnit;
/*
 * 子类重写父类方法并调用父类方法，锁上的是同一个对象。
 */
public class TT {

	synchronized void m() {
		System.out.println("parent's m start!");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("parent's m end!");
	}
	
	public static void main(String[] args) {
		new TTT().m();
	}
	
}

class TTT extends TT{
	
	synchronized void m() {
		System.out.println("child's m start!");
		super.m();
		System.out.println("child's m end!");
	}
	
}
 