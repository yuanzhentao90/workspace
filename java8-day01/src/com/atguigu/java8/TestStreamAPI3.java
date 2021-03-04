package com.atguigu.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

import com.atguigu.java8.Employee.Status;

/*
 * ��ֹ����
 */
public class TestStreamAPI3 {

	List<Employee> employees = Arrays.asList(new Employee(20, "lily", 5000, Status.FREE),
			new Employee(30, "lucy", 7000, Status.BUSY), new Employee(35, "jerry", 8000, Status.VOCATION),
			new Employee(35, "jerry", 8000, Status.VOCATION), new Employee(35, "jerry", 8000, Status.VOCATION),
			new Employee(40, "Tomy", 9000, Status.FREE), new Employee(38, "Jim", 9500, Status.BUSY));

	/*
	 * ������ƥ�� allMatch ���� ����Ƿ�ƥ������Ԫ�� anyMatch ���� ����Ƿ�ƥ������һ��Ԫ�� noneMatch ����
	 * ����Ƿ�û��ƥ������Ԫ�� findFirst ���� ���ص�һ��Ԫ�� findAny ���� ���ص�ǰ���е�����Ԫ�� count ���� ��������Ԫ�ص��ܸ���
	 * max ���� �����������ֵ min ���� ����������Сֵ
	 */

	@Test
	public void test2() {
		long count = employees.stream().count();
		System.out.println(count);

		Optional<Double> salary = employees.stream().map(Employee::getSalary).max(Double::compare);
		System.out.println("��߹��ʣ�" + salary);

		Optional<Employee> empMax = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println("������ߵ��ˣ�" + empMax);

		Optional<Double> minSalary = employees.stream().map(Employee::getSalary).min(Double::compare);
		System.out.println(minSalary);

		Optional<Employee> empMin = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println(empMin);
	}

	@Test
	public void test() {
		// allMatch ���� ����Ƿ�ƥ������Ԫ��
		boolean b1 = employees.stream().allMatch(e -> e.getStatus().equals(Status.BUSY));
		System.out.println(b1);

		// anyMatch ���� ����Ƿ�ƥ������һ��Ԫ��
		boolean b2 = employees.stream().anyMatch(e -> e.getStatus().equals(Status.BUSY));
		System.out.println(b2);

		// noneMatch ���� ����Ƿ�û��ƥ������Ԫ��
		boolean b3 = employees.stream().noneMatch(e -> e.getAge() == 28);
		System.out.println(b3);

		// findFirst ���� ���ص�һ��Ԫ��
		Optional<Employee> optional = employees.stream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
				.findFirst();
		System.out.println(optional);

		// findAny ���� ���ص�ǰ���е�����Ԫ��
		Optional<Employee> op = employees.parallelStream().filter(e -> e.getStatus().equals(Status.FREE)).findAny();
		System.out.println(op);
	}

	/*
	 * ��Լ reduce(T identity,BinaryOperator) /reduce(BinaryOperator) ����
	 * ���Խ�����Ԫ�ط�������������õ�һ��ֵ
	 */
	@Test
	public void test3() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println(sum);

		Optional<Double> sumSaraly = employees.stream().map(Employee::getSalary).reduce(Double::sum);
		System.out.println(sumSaraly);
	}

	/*
	 * �ռ� collect ���� ����ת��Ϊ������ʽ������һ��Collector�ӿڵ�ʵ�֣����ڸ�stream��Ԫ�������ܵķ���
	 */
	@Test
	public void test4() {
		// ת��List
		List<String> nameList = employees.stream().map(Employee::getName).collect(Collectors.toList());
		System.out.println(nameList);

		System.out.println("***********************************************");
		// ת��HashSet
		HashSet<String> hs = employees.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
		System.out.println(hs);
	}

	@Test
	public void test5() {
		// ƽ��
		Double avg = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(avg);
		// �ܺ�
		double sum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sum);
		// ���ֵ
		Optional<Double> opMax = employees.stream()
				.collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())))
				.map(Employee::getSalary);
		System.out.println(opMax);
		// ��Сֵ
		Optional<Double> opMin = employees.stream()
				.collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())))
				.map(Employee::getSalary);
		System.out.println(opMin);
	}

	//����
	@Test
	public void test6() {
		Map<Status, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
		for (Map.Entry<Status, List<Employee>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	//�༶����
	@Test
	public void test7() {
		Map<Status, Map<String, List<Employee>>> map = employees.stream()
				.collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
					if (e.getAge() <= 35) {
						return "����";
					}
					if (e.getAge() <= 50) {
						return "����";
					} else {
						return "����";
					}
				})));
		System.out.println(map);
	}

	//����
	@Test
	public void test8() {
		Map<Boolean,List<Employee>> map = employees.stream()
				 .collect(Collectors.partitioningBy(e -> e.getSalary()>6000));
		System.out.println(map);
	}
	
}