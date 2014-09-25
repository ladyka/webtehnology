package org.vurtatoo.task6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("6. Создать объект класса Звездная система, \n"
				+ "используя классы Планета, Звезда, Луна. Методы:  \n"
				+ "вывести на консоль количество планет в звездной системе, \n"
				+ "название звезды,  \n"
				+ "добавление планеты в систему. \n");
		
		
		Star star = new Star("Солнце");
		List<Planet> planets = new ArrayList<Planet>();
		
		planets.add(new Planet("Меркурий", null));
		
		planets.add(new Planet("Венера", null));
		
		List<Moon> moonsLand = new LinkedList<Moon>();
		Moon landMoon = new Moon("Луна");
		moonsLand.add(landMoon);
		Planet planetLand = new Planet("Земля", moonsLand);
		planets.add(planetLand);
		
		List<Moon> moonsMars = new LinkedList<Moon>();
		moonsMars.add(new Moon("Фобос"));
		moonsMars.add(new Moon("Деймос"));
		Planet planetMars = new Planet("Марс", moonsMars);
		planets.add(planetMars);
		
		
		StarSystem starSystem = new StarSystem("Моя маленькая Солнечная система", star, planets);
		System.out.println(starSystem);
		System.out.println("Количество планет в звездной системе : " + starSystem.getCountPlanets());
		System.out.println("Hазвание звезды : " + starSystem.getStarName()); 
	}

}
