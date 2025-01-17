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
 * 终止操作
 */
public class TestStreamAPI3 {

	List<Employee> employees = Arrays.asList(new Employee(20, "lily", 5000, Status.FREE),
			new Employee(30, "lucy", 7000, Status.BUSY), new Employee(35, "jerry", 8000, Status.VOCATION),
			new Employee(35, "jerry", 8000, Status.VOCATION), new Employee(35, "jerry", 8000, Status.VOCATION),
			new Employee(40, "Tomy", 9000, Status.FREE), new Employee(38, "Jim", 9500, Status.BUSY));

	/*
	 * 查找与匹配 allMatch —— 检查是否匹配所有元素 anyMatch —— 检查是否匹配至少一个元素 noneMatch ——
	 * 检查是否没有匹配所有元素 findFirst —— 返回第一个元素 findAny —— 返回当前流中的任意元素 count —— 返回流中元素的总个数
	 * max —— 返回流中最大值 min —— 返回流中最小值
	 */

	@Test
	public void test2() {
		long count = employees.stream().count();
		System.out.println(count);

		Optional<Double> salary = employees.stream().map(Employee::getSalary).max(Double::compare);
		System.out.println("最高工资：" + salary);

		Optional<Employee> empMax = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println("工资最高的人：" + empMax);

		Optional<Double> minSalary = employees.stream().map(Employee::getSalary).min(Double::compare);
		System.out.println(minSalary);

		Optional<Employee> empMin = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println(empMin);
	}

	@Test
	public void test() {
		// allMatch —— 检查是否匹配所有元素
		boolean b1 = employees.stream().allMatch(e -> e.getStatus().equals(Status.BUSY));
		System.out.println(b1);

		// anyMatch —— 检查是否匹配至少一个元素
		boolean b2 = employees.stream().anyMatch(e -> e.getStatus().equals(Status.BUSY));
		System.out.println(b2);

		// noneMatch —— 检查是否没有匹配所有元素
		boolean b3 = employees.stream().noneMatch(e -> e.getAge() == 28);
		System.out.println(b3);

		// findFirst —— 返回第一个元素
		Optional<Employee> optional = employees.stream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
				.findFirst();
		System.out.println(optional);

		// findAny —— 返回当前流中的任意元素
		Optional<Employee> op = employees.parallelStream().filter(e -> e.getStatus().equals(Status.FREE)).findAny();
		System.out.println(op);
	}

	/*
	 * 归约 reduce(T identity,BinaryOperator) /reduce(BinaryOperator) ——
	 * 可以将流中元素反复结合起来，得到一个值
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
	 * 收集 collect —— 将流转换为其他形式。接收一个Collector接口的实现，用于给stream中元素做汇总的方法
	 */
	@Test
	public void test4() {
		// 转成List
		List<String> nameList = employees.stream().map(Employee::getName).collect(Collectors.toList());
		System.out.println(nameList);

		System.out.println("***********************************************");
		// 转成HashSet
		HashSet<String> hs = employees.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
		System.out.println(hs);
	}

	@Test
	public void test5() {
		// 平均
		Double avg = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(avg);
		// 总和
		double sum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sum);
		// 最大值
		Optional<Double> opMax = employees.stream()
				.collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())))
				.map(Employee::getSalary);
		System.out.println(opMax);
		// 最小值
		Optional<Double> opMin = employees.stream()
				.collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())))
				.map(Employee::getSalary);
		System.out.println(opMin);
	}

	//分组
	@Test
	public void test6() {
		Map<Status, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
		for (Map.Entry<Status, List<Employee>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	//多级分组
	@Test
	public void test7() {
		Map<Status, Map<String, List<Employee>>> map = employees.stream()
				.collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
					if (e.getAge() <= 35) {
						return "青年";
					}
					if (e.getAge() <= 50) {
						return "中年";
					} else {
						return "老年";
					}
				})));
		System.out.println(map);
	}

	//分区
	@Test
	public void test8() {
		Map<Boolean,List<Employee>> map = employees.stream()
				 .collect(Collectors.partitioningBy(e -> e.getSalary()>6000));
		System.out.println(map);
	}
	
}
