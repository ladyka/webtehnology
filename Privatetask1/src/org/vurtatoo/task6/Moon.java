package org.vurtatoo.task6;

public class Moon {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Moon(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Moon [name=" + name + "]";
	}

}
