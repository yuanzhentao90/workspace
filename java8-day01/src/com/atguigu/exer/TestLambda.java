package com.atguigu.exer;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.atguigu.java8.Employee;

public class TestLambda {

	List<Employee> employees = Arrays.asList(
			new Employee(20,"lily",5000),
			new Employee(30,"lucy",7000),
			new Employee(35,"jerry",8000),
			new Employee(40,"Tomy",9000),
			new Employee(39,"张三",10000),
			new Employee(39,"李四",10000),
			new Employee(38,"Jim",9500)
	);
	
	@Test
	public void test() {
		Collections.sort(employees, (e1,e2)->{
			if (e1.getAge() == e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			}else {
				return -Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
	@Test
	public void test2() {
		String value = getValue("   abcdefg   ", (str) -> str.toUpperCase().trim().substring(2, 5));
		System.out.println(value);
	}
	
	public String getValue(String str,MyFunInterface mf) {
		return mf.getString(str);
	}
	
	@Test
	public void test3() {
		op(100L, 200L, (x,y) -> x+y);
		op(200L, 300L, (x,y) -> x*y);
		op(300L, 500L, (x,y) -> x/y);
	}
	
	public void op(Long l1,Long l2 ,MyFunLong<Long, Long> mfl) {
		System.out.println(mfl.getValue(l1, l2));
	}
}
