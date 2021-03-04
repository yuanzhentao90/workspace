package com.mashibing.singlenton;

/* 单例模式
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用。可以使用多线程进行访问
 * 唯一缺点：不管是否使用，类加载时就完成实例化（占内存）
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
