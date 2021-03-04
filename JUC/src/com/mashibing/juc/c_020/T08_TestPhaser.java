package com.mashibing.juc.c_020;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class T08_TestPhaser {

	static Random r = new Random();
	static MarriagePhaser phaser = new MarriagePhaser();
	
	static void milliSleep(int milli) {
		try {
			TimeUnit.SECONDS.sleep(milli);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static class MarriagePhaser extends Phaser{
		@Override
		protected boolean onAdvance(int phase, int registeredParties) {
			switch (phase) {
			case 0:
				System.out.println("�����˵����ˣ�");
				return false;
			case 1:
				System.out.println("�����˳�����");
				return false;
			case 2:
				System.out.println("�������뿪��");
				System.out.println("�������");
				return true;
			default:
				return true;
			}
		}
	}
	
	static class Person{
		String name;
		
		public Person(String name) {
			this.name = name;
		}
		
		public void arrive() {
			milliSleep(r.nextInt(1000));
			System.out.printf("%s �����ֳ���\n ",name);
		}
		
		public void eat() {
			milliSleep(r.nextInt(1000));
			System.out.printf("%s ���꣡\n ",name);
		}
		
		public void leave() {
			milliSleep(r.nextInt(1000));
			System.out.printf("%s �뿪��\n ",name);
		}
	}
}
