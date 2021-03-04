package com.atguigu.java8;

public class StudyLambdaUtil {

	public static Integer operation(Integer num,MyFun fun) {
		return fun.getValue(num);
	}
	
}
