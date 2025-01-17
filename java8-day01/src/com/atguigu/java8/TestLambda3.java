package com.atguigu.java8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/* 
 * java8四大内置核心函数式接口
	Consumer<T>：消费型接口没有返回值
		void accept(T t);
	Supplier<T>：供给型接口
		T get();
	Function<T,R>：函数型接口
		R apply(T t)
	Predicate<T>：断言型接口
		boolean test(T t)
 */

public class TestLambda3 {

	//Consumer<T>：消费型接口没有返回值
	@Test
	public void test1() {
		study(399.99,m -> System.out.println("我又花了"+m+"块钱买课"));
	}
	
	public void study(Double money,Consumer<Double> con) {
		con.accept(money);
	}
	
	//Supplier<T>：供给型接口
	@Test
	public void test2() {
		List<Integer> numList = getNum(10, ()-> (int)(Math.random()*100));
		for (Integer integer : numList) {
			System.out.println(integer);
		}
	}
	
	public List<Integer> getNum(int count,Supplier<Integer> sup){
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < count; i++) {
			list.add(sup.get());
		}
		return list;
	}
	
	//Function<T,R>：函数型接口
	@Test
	public void test3() {
		String newStr = disposeString("老三是个大傻子", str -> str.replace("老三", "老大"));
		System.out.println(newStr);
	}
	
	public String disposeString(String source, Function<String, String> fun) {
		return fun.apply(source);
	}
	
	//Predicate<T>：断言型接口
	@Test
	public void test4() {
		List<String> strs = Arrays.asList("张三丰","张翠山","张无忌","殷素素","赵敏");
		for (String string : strs) {
			if (!filterStr(string, str -> str.startsWith("张"))) {
				System.out.println(string);
			}
		}
	}
	
	public boolean filterStr(String str,Predicate<String> pre) {
		return pre.test(str);
	}
}
