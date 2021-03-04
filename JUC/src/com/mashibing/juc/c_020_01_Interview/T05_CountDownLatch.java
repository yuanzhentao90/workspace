package com.mashibing.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;

public class T05_CountDownLatch {

	volatile List lists = new ArrayList<>();

	public void add(Object o) {
		lists.add(o);
	}

	public int size() {
		return lists.size();
	}
	
	public static void main(String[] args) {
		
	}
	
}
