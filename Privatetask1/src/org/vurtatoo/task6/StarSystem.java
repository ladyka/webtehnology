package org.vurtatoo.task6;

import java.util.List;

public class StarSystem {

	private String name;
	private Star star;
	private List<Planet> planets;

	public StarSystem(String name, Star star, List<Planet> planets) {
		super();
		this.name = name;
		this.star = star;
		this.planets = planets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}

	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}

	public Integer getCountPlanets() {
		return planets.size();
	}

	public void addPlanets(Planet planet) {
		this.planets.add(planet);
	}

	@Override
	public String toString() {
		return "StarSystem [name=" + name + ", star=" + star + ", planets="
				+ planets + "]";
	}

	public String getStarName() {
		return getStar().getName();
	}

}
