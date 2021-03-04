package com.mashibing.singlenton;

/*
 * 枚举单例模式线程安全的
 * 懒汉式即解决了线程同步，又能防止反序列化
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
