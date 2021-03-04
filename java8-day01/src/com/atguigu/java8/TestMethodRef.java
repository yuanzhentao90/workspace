package com.atguigu.java8;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * �������ã���һ����lambda���ʽ��
 * ����::ʵ��������
 * ��::��̬������
 * ��::ʵ��������
 * 
 * ����������
 * ����::new
 * 
 */
public class TestMethodRef {

	//����::ʵ��������
	@Test
	public void test() {
		Consumer<String> con = System.out::println;
		con.accept("abcdefg");
	}
	
	@Test
	public void test2() {
		Employee employee = new Employee(25,"Jerry",6000.00);
		Supplier<String> sup = employee::getName;
		String name = sup.get();
		System.out.println(name);
	}
	
	//��::��̬������
	@Test
	public void test3() {
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
		System.out.println(com.compare(2, 2));
		Comparator<Integer> com2 = Integer::compare;
		System.out.println(com2.compare(1, 2));
	}
	
	//��::ʵ��������
	@Test
	public void test4() {
		BiPredicate<String,String> pre = String::equals;
		System.out.println(pre.test("hello", "hello"));
	}
	
	//���������� ����::new
	@Test
	public void test5() {
		Function<Integer, Employee> fun = (x) -> new Employee(x);
		System.out.println(fun.apply(30));
		Function<Integer, Employee> fun2 = Employee::new;
		System.out.println(fun2.apply(45));
	}
	
}
