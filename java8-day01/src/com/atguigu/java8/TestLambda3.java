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
 * java8�Ĵ����ú��ĺ���ʽ�ӿ�
	Consumer<T>�������ͽӿ�û�з���ֵ
		void accept(T t);
	Supplier<T>�������ͽӿ�
		T get();
	Function<T,R>�������ͽӿ�
		R apply(T t)
	Predicate<T>�������ͽӿ�
		boolean test(T t)
 */

public class TestLambda3 {

	//Consumer<T>�������ͽӿ�û�з���ֵ
	@Test
	public void test1() {
		study(399.99,m -> System.out.println("���ֻ���"+m+"��Ǯ���"));
	}
	
	public void study(Double money,Consumer<Double> con) {
		con.accept(money);
	}
	
	//Supplier<T>�������ͽӿ�
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
	
	//Function<T,R>�������ͽӿ�
	@Test
	public void test3() {
		String newStr = disposeString("�����Ǹ���ɵ��", str -> str.replace("����", "�ϴ�"));
		System.out.println(newStr);
	}
	
	public String disposeString(String source, Function<String, String> fun) {
		return fun.apply(source);
	}
	
	//Predicate<T>�������ͽӿ�
	@Test
	public void test4() {
		List<String> strs = Arrays.asList("������","�Ŵ�ɽ","���޼�","������","����");
		for (String string : strs) {
			if (!filterStr(string, str -> str.startsWith("��"))) {
				System.out.println(string);
			}
		}
	}
	
	public boolean filterStr(String str,Predicate<String> pre) {
		return pre.test(str);
	}
}