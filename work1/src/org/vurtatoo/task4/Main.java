package org.vurtatoo.task4;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	//4. Создать список из элементов каталога и его подкаталогов.
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String folder = scanner.nextLine();
		scanner.close();
		File file = new File(folder);
		if (file.isDirectory()) {
			Map<String, Object> map = getMap(file);
			System.out.println(map);
		} else {
			System.err.println("IS NOT DIRECTORY");
		}
		

	}

	private static Map<String, Object> getMap(File fileSource) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> files = new ArrayList<String>();
		for (String fileString : fileSource.list()) {
			File file  = new File(fileSource.getAbsolutePath() + System.getProperty("file.separator") +fileString);
			//System.out.println(file.getAbsolutePath());
			if (file.isDirectory()) {
				map.put(fileString, getMap(file));
			} else {
				files.add(fileString);
			}
		}
		map.put("files", files);
		return map;
	}

}
