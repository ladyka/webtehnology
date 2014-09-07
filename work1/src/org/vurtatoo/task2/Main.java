package org.vurtatoo.task2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	private static Scanner scanner;

	//2. Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		String value = scanner.nextLine();
		System.out.println(value);
		Stack<Character> bytes = new Stack<Character>();
		for (int i = 0; i < value.length(); i++) {
			Character character = value.charAt(i);
			if (Character.isDigit(character)) {
				bytes.add(character);
			} else {
				System.err.println("THIS IN NOT NUMBER");
				return;
			}
			System.out.println(value.charAt(i));
		}
		
		
		for (int i = bytes.size() -1; i > -1; --i) {
			Character c = bytes.get(i);
			System.out.print(c);
			
		}
		scanner.close();
		
	}

}
