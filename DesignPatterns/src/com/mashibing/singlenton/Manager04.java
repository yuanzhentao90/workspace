package com.mashibing.singlenton;
/*
 * 懒汉式加锁的同时提高效率
 * 
 */
public class Manager04 {

	private static Manager04 INSTANCE;
	
	private Manager04() {
		
	}
	
	public static Manager04 getInstance() {
		if (INSTANCE == null) {
			//试图在需要的时候加锁，然而无法保证线程安全
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
