package com.atguigu.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class TestLambda {

	//jdk1.8之前的匿名内部类
	@Test
	public void test01() {
		//创建匿名内部类
		Comparator<Integer> com = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};
		
		TreeSet<Integer> tSet = new TreeSet<>(com);
	}
	
	@Test
	public void test02() {
		//Lambda表达式
		Comparator<Integer> comparator = (x,y)->Integer.compare(x, y);
		TreeSet<Integer> tSet = new TreeSet<>(comparator);
	}
	
	List<Employee> employees = Arrays.asList(
			new Employee(20,"lily",5000),
			new Employee(30,"lucy",7000),
			new Employee(35,"jerry",8000),
			new Employee(40,"Tomy",9000),
			new Employee(38,"Jim",9500)
		);
	
	//过滤方法
	public List<Employee> filterEmployees(List<Employee> list , FilterCondition<Employee> condition){
		List<Employee> emps = new ArrayList<>();
		for (Employee employee : list) {
			if (condition.condition(employee)) {
				emps.add(employee);
			}
		}
		return emps;
	}
	
	//通过Lambda表达式过滤
	@Test
	public void test03() {
		List<Employee> emps = filterEmployees(employees, (e)->e.getSalary()>6000);
		emps.forEach(System.out::println);
	}
	
	//StreamAPI
	@Test
	public void test04() {
		employees.stream()
				 .filter((e)-> e.getSalary()>6000)
				 .forEach(System.out::println);
		System.out.println("----------------------------------");
		employees.stream()
				 .map(Employee::getName)
				 .forEach(System.out::println);
	}
	
	
}
