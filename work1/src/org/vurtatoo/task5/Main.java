package org.vurtatoo.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	//5. Не используя вспомогательных объектов, 
	//переставить отрицательные элементы в конец данного списка в конец, а положитель­ные – в начало этого списка.
	public static void main(String[] args) {
		int a = 123;
		List<Integer> integers = getRandomArray(a);
		List<Integer> integersPlus = new ArrayList<Integer>(a);
		List<Integer> integersMinus = new ArrayList<Integer>(a);
		List<Integer> integersZero = new ArrayList<Integer>(a); 
		for (Integer integer : integers) {
			if (integer > 0) { 
				integersPlus.add(integer);
			} else if (integer < 0) {
				integersMinus.add(integer);
			} else {
				integersZero.add(integer);
			}
		}
		List<Integer> integerRezult = new ArrayList<Integer>();
		integerRezult.addAll(integersPlus);
		integerRezult.addAll(integersZero);
		integerRezult.addAll(integersMinus);
		System.out.println(integerRezult);
	}

	private static List<Integer> getRandomArray(int i) {
		List<Integer> list = new ArrayList<Integer>();
		for (int j = 0; j < i; j++) {
			list.add(new Random().nextInt(1000) - 500);
		}
		return list;
	}
}
