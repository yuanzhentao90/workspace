package com.mashibing.singlenton;

/* ����ģʽ
 * ����ʽ
 * ����ص��ڴ�󣬾�ʵ����һ��������JVM��֤�̰߳�ȫ
 * ��ʵ�ã��Ƽ�ʹ�á�����ʹ�ö��߳̽��з���
 * Ψһȱ�㣺�����Ƿ�ʹ�ã������ʱ�����ʵ������ռ�ڴ棩
 */

public class Manager01 {

	private static final Manager01 INSTANCE = new Manager01();
	
	private Manager01() {
		
	}
	
	public static Manager01 getInstance() {
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		Manager01 m1 = getInstance();
		Manager01 m2 = getInstance();
		System.out.println(m1 == m2);
	}
	
}
