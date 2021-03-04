package com.mashibing.juc;

import java.util.concurrent.TimeUnit;
/*
 * ������д���෽�������ø��෽�������ϵ���ͬһ������
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
 