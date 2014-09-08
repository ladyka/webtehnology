package org.vurtatoo.task8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static Scanner scannerFile;
	private static Scanner scannerConsole;
	//8. Ввести строки из файла, записать в список ArrayList. 
	//Выполнить сортировку строк, используя метод sort() из класса Collections.
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
		List<String> strings = new ArrayList<String>(0);
		while (scannerFile.hasNext()) {
			String string = scannerFile.nextLine();
			strings.add(string);
		}
		Collections.sort(strings);
		System.out.println(strings);
	}
}
