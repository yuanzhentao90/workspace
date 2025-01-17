package com.mashibing.baseThread;
/*
 * ����
 */
public class TestDeadLock implements Runnable{

	public int flag = 1;
	static Object o1 = new Object() , o2 = new Object();
	@Override
	public void run() {
		System.out.println("flag="+flag);
		if (flag == 1) {
			synchronized (o1) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println("1");	
				}
			}
		}
		
		if (flag == 0) {
			synchronized (o2) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println("0");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TestDeadLock td1 = new TestDeadLock();
		TestDeadLock td2 = new TestDeadLock();
		td1.flag = 1;
		td2.flag = 2;
		Thread t1 = new Thread(td1);
		Thread t2 = new Thread(td2);
		t1.start();
		t2.start();
	}

}
