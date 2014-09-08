package org.vurtatoo.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	// 10. С использованием множества выполнить попарное
	// суммирование произвольного конечного ряда чисел по следующим правилам:
	// на первом этапе суммируются попарно рядом стоящие числа,
	// на втором этапе суммируются результаты
	// первого этапа и т.д. до тех пор, пока не останется одно число.
	public static void main(String[] args) {
		 List<Integer> integers = getRandomArray(1234);
		 System.out.println(integers);
		 List<Integer> integers2 = plus(integers);

		 System.out.println(integers2);
	}
	
	private static List<Integer> plus(List<Integer> integers) {
		if (integers.size() == 1) {
			return integers;
		}
		
		int size = 0;
		if ((integers.size() % 2 != 0)) {
			size = ((int) (integers.size()/2) )+1;
		} else {
			size = (integers.size()/2);
		}
		List<Integer> integers2 = new ArrayList<Integer>(size);
		
		for (int i = 0; i < size;i++) {
			if ((2*i+1) <integers.size()) {
				integers2.add(integers.get(2*i) + integers.get(2*i +1));
			} else {
				integers2.add(integers.get(2*i));
			}
			

		}
		System.out.println(integers2);
		return plus(integers2);
	}

	private static List<Integer> getRandomArray(int i) {
		List<Integer> list = new ArrayList<Integer>();
		for (int j = 0; j < i; j++) {
			list.add(new Random().nextInt(1000) - 500);
		}
		return list;
	}

}
