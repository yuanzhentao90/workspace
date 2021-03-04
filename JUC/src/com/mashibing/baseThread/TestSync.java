package com.mashibing.baseThread;
/*
 * �߳�ͬ������
 * ʹ��synchronized (this) {}����飬������ǰ����
 */
public class TestSync implements Runnable{
	Timer timer = new Timer();
	public static void main(String[] args) {
		TestSync sync = new TestSync();
		Thread t1 = new Thread(sync);
		Thread t2 = new Thread(sync);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}
	
	@Override
	public void run() {
		timer.add(Thread.currentThread().getName());
	}
}

class Timer{
	private static int num = 0;
	
	public void add(String name) {
		synchronized (this) {
			num++;
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(name+"�����ǵڣ�"+num+" ��ʹ��timer���̡߳�");
		}
	}
}