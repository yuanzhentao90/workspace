package com.mashibing.juc;

public class T03_Sleep_Yield_Join {

	//��ǰ�߳�˯�߶��ٺ���
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
	
	//��ǰ�߳��ó�CPU��Դ�������̣߳���ǰ�߳�Ҳ���������߳���ռCPU��Դ������˭�������������
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
	
	//��ǰ�߳�t2��ִ�У�����t1.join����ǰ�߳�t2�ȴ�t1ִ����֮����ִ��
	//join�������Ա�֤�̵߳�ִ��˳��
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
