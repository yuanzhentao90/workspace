package com.mashibing;

import java.text.NumberFormat;
/**
 * ÕÉÄ¸ÄïÌ×Â·Å®Ğö²ÊÀñËã·¨
 * @author Administrator
 *
 */
public class MerryMoney {

	public static void main(String[] args) {
		NumberFormat nf = NumberFormat.getInstance();
		double money = 0.00d;
		for (int i = 0; i < 31; i++) {
			money += 0.01d*Math.pow(2, i);
			System.out.println(nf.format(money));
		}
		System.out.println("********************************************");
		System.out.println(nf.format(money));
	}
}
