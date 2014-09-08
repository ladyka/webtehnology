package org.vurtatoo.task7;

import java.util.Stack;

public class Main {

	//7. Задать два стека, поменять информацию местами.
	public static void main(String[] args) {
		Stack<String> objects1 = new Stack<String>();
		objects1.add("asdasd1");
		objects1.add("asdasd2");
		objects1.add("asdasd3");
		objects1.add("asdasd4");
		objects1.add("asdasd5");
		objects1.add("asdasd6");
		Stack<String> objects2 = new Stack<String>();
		objects2.add("lololo1");
		objects2.add("lololo2");
		objects2.add("lololo3");
		objects2.add("lololo4");
		objects2.add("lololo5");
		System.out.println(objects1);
		System.out.println(objects2);
		System.out.println("=============================");
		swap(objects1,objects2);
		System.out.println(objects1);
		System.out.println(objects2);
	}

	private static void swap(Stack<String> objects1, Stack<String> objects2) {
		Stack<String> objectsTemp = new Stack<String>();
		for (String string : objects2) {
			objectsTemp.add(string);
		}
		objects2.clear();
		for (String string : objects1) {
			objects2.add(string);
		}
		objects1.clear();
		for (String string : objectsTemp) {
			objects1.add(string);
		}
	}

}
