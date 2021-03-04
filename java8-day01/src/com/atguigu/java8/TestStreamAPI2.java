package com.atguigu.java8;

import java.util.Arrays;
import java.util.LinkedList;
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
	
	//�м����
	/*
	 * ɸѡ����Ƭ
	 * filter ����lambda���������ų�ĳЩԪ��
	 * limit �ض�����ʹ��Ԫ�ز��ᳬ��ָ���ĸ���
	 * skip(n) ����Ԫ�أ�����һ���ӵ�ǰn��Ԫ�ص��������n>����Ԫ�صĸ���������һ����������limit������
	 * distinct ͨ����������Ԫ����hashCode()������equals()����ȥ���ظ�Ԫ��
	 */
	
	/*
	 * ����
	 * sorted()��Ȼ���� comparable
	 * sorted(Comparator com)��������
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
		 * ����м��������������һ���γ�һ����ˮ��ʽ���������û����ֹ���������м����������ִ�С�
		 * �м����ֻ������ֹ����ʱһ����ȫ����������Ϊ��������ֵ����
		 */
		employees.stream()
				 //�м����
				 .filter( (e) -> {
					System.out.println("StreamAPI �ڹ���");
					return e.getAge()>35;
				  })
				 //��ֹ����
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
	 * ӳ��
	 * map��������Lambda,��Ԫ��ת�����������ƻ���ȡ��Ϣ��
	 * 		����һ�������ӿ�Function<T, R>��Ϊ������
	 * 		�ú����ᱻӦ�õ�ÿ��Ԫ���ϣ�������ӳ���һ���µ�Ԫ�ء�
	 * flatMap��������һ�������ӿ�Function<T, R>��Ϊ������
	 * 		������ÿһ��ֵ��������һ������Ȼ������������ӳ�һ������
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