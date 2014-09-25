package org.vurtatoo.task6;

import java.util.LinkedList;
import java.util.List;

public class Planet {

	private String name;
	private List<Moon> moons;

	public Planet(String name, List<Moon> moons) {
		super();
		this.name = name;
		if (moons != null) {
			this.moons = moons;
		} else {
			this.moons = new LinkedList<Moon>();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Moon> getMoons() {
		return moons;
	}

	public void setMoons(List<Moon> moons) {
		this.moons = moons;
	}

	@Override
	public String toString() {
		return "Planet [name=" + name + ", moons=" + moons + "]";
	}

}
