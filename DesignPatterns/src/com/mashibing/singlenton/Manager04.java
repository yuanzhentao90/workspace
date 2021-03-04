package com.mashibing.singlenton;
/*
 * ����ʽ������ͬʱ���Ч��
 * 
 */
public class Manager04 {

	private static Manager04 INSTANCE;
	
	private Manager04() {
		
	}
	
	public static Manager04 getInstance() {
		if (INSTANCE == null) {
			//��ͼ����Ҫ��ʱ�������Ȼ���޷���֤�̰߳�ȫ
			synchronized (Manager04.class) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				INSTANCE = new Manager04();
			}
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			new Thread(()->
				System.out.println(getInstance().hashCode())
			).start();
		}
	}
	
}
