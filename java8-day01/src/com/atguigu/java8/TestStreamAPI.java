package com.atguigu.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

/*
 * 1.������
 * 
 * 2.�м����
 * 
 * 3.��ֹ����
 * 
 */

public class TestStreamAPI {

	//����Stream��
	@Test
	public void test() {
		//1.����ͨ��Collectionϵ�м����ṩ��stream()������parallelStream()����
		List<String> list = new ArrayList<>();
		Stream<String> strStream = list.stream();
		
		//2.ͨ��Arrays�еľ�̬����stream()��ȡ��
		Employee[] emps = new Employee[10];
		Stream<Employee> streamEmps = Arrays.stream(emps);
		
		//3.ͨ��Stream�еľ�̬����of()��ȡ��
		Stream<String> strStream2 = Stream.of("aa","bb");
		
		//4.������������ʹ��Stream�еľ�̬����iterate()
		Stream<Integer> intStream = Stream.iterate(0, x -> x+2);
		intStream.limit(10).forEach(System.out::println);
	}
	
	
}
