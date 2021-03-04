package com.mashibing.singlenton;
/*
 * 懒汉式
 * 非线程安全
 */
public class Manager02 {

	private static Manager02 INSTANCE;
	
	private Manager02() {
		
	}
	
	public static Manager02 getInstance() {
		if (INSTANCE == null) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			INSTANCE = new Manager02();
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
