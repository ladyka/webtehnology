package org.vurtatoo.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

	//3. Сложить два многочлена заданной степени, если коэффициенты многочленов хранятся в объекте HashMap.
	public static void main(String[] args) {
		Main main = new Main();
		int count = 10;
		Map<Integer, Integer> mapPolinomOne = main.getRandomPolinom(count);
		System.out.println(mapPolinomOne);
		Map<Integer, Integer> mapPolinomTwo = main.getRandomPolinom(count);
		System.out.println(mapPolinomTwo);
		Map<Integer, Integer> mapPolinomRezult = main.add(mapPolinomOne,mapPolinomTwo,count);
		System.out.println(mapPolinomRezult);

	}
	
	
	private Map<Integer, Integer> add(Map<Integer, Integer> mapPolinomOne,
			Map<Integer, Integer> mapPolinomTwo, int count) {
		Map<Integer, Integer> maprezult = new HashMap<Integer, Integer>();
		for (int j = 0; j < count; j++) {
			Integer firstK = mapPolinomOne.get(j);
			Integer secondK = mapPolinomTwo.get(j);
			maprezult.put(j, firstK+secondK);
		}
		return maprezult;
	}
	
	private Map<Integer, Integer> getRandomPolinom(int i) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int degree = 0 ; degree< i ; degree++) {
			map.put(degree, (new Random(System.nanoTime()).nextInt(1000)-500));
		}
		return map;
	}

}
