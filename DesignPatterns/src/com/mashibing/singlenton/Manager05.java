package com.mashibing.singlenton;

public class Manager05 {

	private Manager05() {}
	
	private static volatile Manager05 INSTANCE;//JIT优化
	
	public static Manager05 getInstance() {
		if (INSTANCE == null) {
			synchronized (Manager05.class) {
				//双重检查最完美的单例模式写法
				if (INSTANCE == null) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					INSTANCE = new Manager05();
				}
			}
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(()->
				System.out.println(getInstance().hashCode())
			).start();
		}
	}
	
}
