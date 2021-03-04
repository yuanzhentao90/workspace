package com.mashibing.singlenton;
/*
 * ����ʽ����
 * ���Խ���̲߳���ȫ���⣬����Ҳ�����������½�
 */
public class Manager03 {

	private static Manager03 INSTANCE;
	
	private Manager03() {
		
	}
	
	public static synchronized Manager03 getInstance() {
		if (INSTANCE == null) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			INSTANCE = new Manager03();
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(()->{
				System.out.println(getInstance().hashCode());
			}).start();
		}
	}
	
}
