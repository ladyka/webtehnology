package org.vurtatoo.task6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static Scanner scanner;

	//6. Занести стихотворения одного автора в список. Провести сортировку по возрастанию длин строк.
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		List<String> strings = new ArrayList<String>(0);
		while (scanner.hasNext()) {
			String string = scanner.nextLine();
			if (string.compareTo("end") == 0) {
				scanner.close();
				break;
			}
			strings.add(string);
		}
		Collections.sort(strings);
		System.out.println(strings);

	}

}
