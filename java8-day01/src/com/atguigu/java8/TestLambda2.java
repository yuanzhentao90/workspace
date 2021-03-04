package com.atguigu.java8;
/*
 * һ��lambda���ʽ�Ļ����﷨:java8��������һ���µĲ�����->
 * 		��ͷ��������lambda���ʽ��ֳ�������
 * 		����ǲ����б�
 * 		�ұ�����Ҫִ�еĹ��ܣ���lambda��
 * 
 * �﷨��ʽһ���޲������޷���ֵ
 * 		()->System.out.println("Hello word!");
 * �﷨��ʽ������һ���������޷���ֵ
 * 		(x)->System.out.println(x);
 * �﷨��ʽ���������������ϲ������з���ֵ������lambda�����ж������
 * 		Comparator<Integer> com = (x,y) -> {
			return Integer.compare(x, y);
		};		
 * �﷨��ʽ�ģ������������ϲ������з���ֵ������lambda����ֻ��һ����䣨return��{}������ʡ�ԣ�
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
			x = x.replace("ү", "��");
			System.out.println(x);
		};
		consumer.accept("���ү�������ү");
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
