package com.atguigu.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

/*
 * 1.创建流
 * 
 * 2.中间操作
 * 
 * 3.终止操作
 * 
 */

public class TestStreamAPI {

	//创建Stream流
	@Test
	public void test() {
		//1.可以通过Collection系列集合提供的stream()方法或parallelStream()方法
		List<String> list = new ArrayList<>();
		Stream<String> strStream = list.stream();
		
		//2.通过Arrays中的静态方法stream()获取流
		Employee[] emps = new Employee[10];
		Stream<Employee> streamEmps = Arrays.stream(emps);
		
		//3.通过Stream中的静态方法of()获取流
		Stream<String> strStream2 = Stream.of("aa","bb");
		
		//4.创建无限流，使用Stream中的静态方法iterate()
		Stream<Integer> intStream = Stream.iterate(0, x -> x+2);
		intStream.limit(10).forEach(System.out::println);
	}
	
	
}
