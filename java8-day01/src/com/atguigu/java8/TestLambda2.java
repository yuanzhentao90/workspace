package com.atguigu.java8;
/*
 * 一、lambda表达式的基础语法:java8中引入了一个新的操作符->
 * 		箭头操作符将lambda表达式拆分成两部分
 * 		左边是参数列表
 * 		右边是需要执行的功能，即lambda体
 * 
 * 语法格式一：无参数、无返回值
 * 		()->System.out.println("Hello word!");
 * 语法格式二：有一个参数、无返回值
 * 		(x)->System.out.println(x);
 * 语法格式三：有两个及以上参数，有返回值，并且lambda体中有多条语句
 * 		Comparator<Integer> com = (x,y) -> {
			return Integer.compare(x, y);
		};		
 * 语法格式四：有两个及以上参数，有返回值，并且lambda体中只有一条语句（return和{}都可以省略）
 * 		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
 * 
 * 
 */

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

public class TestLambda2 {

	@Test
	public void test() {
		int num = 1; 
		Runnable runnable = ()-> System.out.println("Hello Lambda" + num);
		runnable.run();
	}
	
	@Test
	public void test2() {
		Consumer<String> consumer = x-> {
			x = x.replace("爷", "哥");
			System.out.println(x);
		};
		consumer.accept("你大爷还是你大爷");
	}
	
	@Test
	public void test3() {
		Comparator<Integer> com = (x,y) -> {
			return Integer.compare(x, y);
		};
		com.compare(1, 2);
	}
	
	@Test
	public void test4() {
		Integer product = StudyLambdaUtil.operation(100, (x)-> x*x);
		System.out.println(product);
	}
}
