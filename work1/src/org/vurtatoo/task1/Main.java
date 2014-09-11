package org.vurtatoo.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static Scanner scanner;
	private static FileWriter fileWriter;

	//1. Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		try {
			scanner = new Scanner(new File("firsttaskinput.txt"));
			while (scanner.hasNext()) {
				String stringLine = scanner.nextLine();
				System.out.println(stringLine);
				strings.add(stringLine);
			}
			fileWriter = new FileWriter(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator")+ "firstTaskOutput" + System.nanoTime() + ".txt");
			for (int i = strings.size()-1 ; i >-1; i--) {
				String stringLine = strings.get(i);
				fileWriter.write(stringLine + "\n");
			}
			fileWriter.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		

	}

}
