package com.mashibing.singlenton;

/*
 * ö�ٵ���ģʽ�̰߳�ȫ��
 * ����ʽ��������߳�ͬ�������ܷ�ֹ�����л�
 */
public enum Manager07 {

	INSTANCE;
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(()->
				System.out.println(INSTANCE.hashCode())
			).start();
		}
	}
}
