package com.mashibing.baseThread;

public class TestYild {

	public static void main(String[] args) {
		MyThread3 t1 = new MyThread3("t1");
		MyThread3 t2 = new MyThread3("t2");
		t1.start();
		t2.start();
	}
}

class MyThread3 extends Thread{
	MyThread3(String s){
		super(s);
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(getName()+":"+i);
			if (i%10 == 0) {
				yield();
			}
		}
	}
}