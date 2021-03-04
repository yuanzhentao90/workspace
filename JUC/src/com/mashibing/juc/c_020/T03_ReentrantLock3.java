package com.mashibing.juc.c_020;
/*
 * ReentrantLock用于替换synchronized
 * 由于m1锁定this，只有m1执行完毕的时候，m2才执行
 * 
 * 使用ReentrantLock可以完成synchronized相同的功能
 * synchronized在程序遇到异常的时候会自动释放锁，ReentrantLock不会自动释放锁，必须手动解锁
 * 需要注意的是，必须手动上锁、手动解锁为防止程序执行出现异常，应讲解锁代码放到finally代码块中
 * 
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T03_ReentrantLock3 {

	Lock lock = new ReentrantLock();
	
	void m1() {
		try {
			lock.lock();
			for (int i = 0; i < 10; i++) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	/*
	 * 使用tryLock进行尝试锁定，不管锁定与否，方法都将继续执行
	 * 根据tryLock的返回值来判断是否锁定
	 * 也可以指定tryLock的时间，由于tryLock抛出异常，所以要注意unlock
	 */
	void m2() {
		boolean locked = false;
		try {
			locked = lock.tryLock(5,TimeUnit.SECONDS);
			System.out.println("m2..."+locked);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			if (locked) lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		T03_ReentrantLock3 rl = new T03_ReentrantLock3();
		new Thread(rl::m1).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(rl::m2).start();
	}
}
