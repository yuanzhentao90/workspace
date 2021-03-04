package com.mashibing.juc;

public class T03_Sleep_Yield_Join {

	//当前线程睡眠多少毫秒
	static void testSleep() {
		new Thread(()->{
			for (int i = 0; i < 100; i++) {
				System.out.println("sleep"+i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	//当前线程让出CPU资源给其他线程，当前线程也会与其他线程抢占CPU资源，至于谁能抢到是随机的
	static void testYield() {
		new Thread(()->{
			for (int i = 0; i < 100; i++) {
				System.out.println("yield"+i);
				if (1%10==0) Thread.yield();
			}
		}).start();
		
		new Thread(()->{
			for (int i = 0; i < 100; i++) {
				System.out.println("----yield"+i+"----");
				if (i%10==0) Thread.yield();
			}
		}).start();
	}
	
	//当前线程t2在执行，调用t1.join，当前线程t2等待t1执行完之后再执行
	//join方法可以保证线程的执行顺序
	static void testJoin() {
		Thread t1 = new Thread(()->{
			for (int i = 0; i < 100; i++) {
				System.out.println("t1"+i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(()->{
			try {
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
	}
}
