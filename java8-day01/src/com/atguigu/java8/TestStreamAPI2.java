package com.atguigu.java8;

import java.util.Arrays;
import java.util.LinkedList;
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
public class TestStreamAPI2 {

	List<Employee> employees = Arrays.asList(
			new Employee(20,"lily",5000),
			new Employee(30,"lucy",7000),
			new Employee(35,"jerry",8000),
			new Employee(40,"Tomy",9000),
			new Employee(40,"Tomy",9000),
			new Employee(40,"Tomy",9000),
			new Employee(40,"Tomy",9000),
			new Employee(40,"Tomy",9000),
			new Employee(38,"Jim",9500)
		);
	
	//中间操作
	/*
	 * 筛选与切片
	 * filter 接受lambda，从流中排除某些元素
	 * limit 截断流，使其元素不会超过指定的个数
	 * skip(n) 跳过元素，返回一个扔掉前n个元素的流，如果n>流中元素的个数，返回一个空流，和limit互补。
	 * distinct 通过流所生成元素是hashCode()方法和equals()方法去除重复元素
	 */
	
	/*
	 * 排序
	 * sorted()自然排序 comparable
	 * sorted(Comparator com)定制排序
	 */
	@Test
	public void test6() {
		List<String> strList = Arrays.asList("aa","cc","ddd","bb","eee","fff");
		strList.stream()
				.sorted()
				.forEach(System.out::println);
		
		System.out.println("****************************************************");
		employees.stream()
				.sorted((e1,e2)->{
					if (e1.getAge() == e2.getAge()) {
						return e1.getName().compareTo(e2.getName());
					}else {
						return e1.getAge().compareTo(e2.getAge());
					}
				})
				.distinct()
				.forEach(System.out::println);
	}
	
	
	@Test
	public void test() {
		/*
		 * 多个中间操作可以连接在一起形成一个流水线式操作，如果没有终止操作，则中间操作都不会执行。
		 * 中间操作只会在终止操作时一次性全部处理，称为“惰性求值”。
		 */
		employees.stream()
				 //中间操作
				 .filter( (e) -> {
					System.out.println("StreamAPI 在工作");
					return e.getAge()>35;
				  })
				 //终止操作
				 .forEach(System.out::println);
	}
	
	@Test
	public void test2() {
		employees.stream()
				 .limit(2)
				 .forEach(System.out::println);
	}
	
	@Test
	public void test3() {
		employees.stream()
				 .skip(3)
				 .forEach(System.out::println);
	}
	
	@Test
	public void test4() {
		employees.stream()
				 .distinct()
				 .forEach(System.out::println);
	}
	
	/*
	 * 映射
	 * map——接受Lambda,将元素转换成其他形势或提取信息。
	 * 		接收一个函数接口Function<T, R>作为参数，
	 * 		该函数会被应用到每个元素上，并将其映射成一个新的元素。
	 * flatMap——接收一个函数接口Function<T, R>作为参数，
	 * 		将流中每一个值都换成另一个流，然后把所有流连接成一个流。
	 */
	@Test
	public void test5() {
		List<String> strList = Arrays.asList("aa","bb","cc","ddd","eee","fff");
		strList.stream()
				.map((str)->{
					if (str.length()>2) {
						return str.toUpperCase();	
					}
					return str;
				})
				.forEach(System.out::println);
		System.out.println("*------------------------------------------------------*");
		Stream<Stream<Character>> stream = strList.stream()
				.map(TestStreamAPI2::filterCharacter);
		stream.forEach(sm->sm.forEach(System.out::println));
		System.out.println("--------------------------------------------------------");
		strList.stream()
				.flatMap(TestStreamAPI2::filterCharacter)
				.forEach(System.out::println);
	}
	
	public static Stream<Character> filterCharacter(String str){
		List<Character> charsList = new LinkedList<>();
		for (Character ch : str.toCharArray()) {
			charsList.add(ch);
		}
		return charsList.stream();
	}
}
