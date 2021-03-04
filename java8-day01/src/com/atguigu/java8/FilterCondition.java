package com.atguigu.java8;

@FunctionalInterface
public interface FilterCondition<T> {

	boolean condition(T t);
}
