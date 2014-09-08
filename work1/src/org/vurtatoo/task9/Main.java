package org.vurtatoo.task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	private static Scanner scannerFile;
	private static Scanner scannerConsole;
	//9. 9. Задан файл с текстом на английском языке. 
	//Выделить все различные слова. Слова, отличающиеся только регистром букв,
	//считать одинаковыми. Использовать класс HashSet.
	public static void main(String[] args) {
		scannerConsole = new Scanner(System.in);
		String pathname = scannerConsole.nextLine();
		scannerConsole.close();
		try {
			scannerFile = new Scanner(new FileReader(new File(pathname)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		Set<String> strings = new HashSet<String>();
		while (scannerFile.hasNext()) {
			String string = scannerFile.nextLine();
			strings.add(string.toLowerCase());
		}

		System.out.println(strings);
	}

}
