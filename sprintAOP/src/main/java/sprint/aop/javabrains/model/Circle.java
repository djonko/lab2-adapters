package sprint.aop.javabrains.model;

import sprint.aop.javabrains.aspect.Loggable;


public class Circle {

	private String name;

	@Loggable
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
	}
	
	public String setName3(String name) {
		this.name = name;
		return name;
	}
	
	public void setName4(String name) {
		this.name = name;
		throw new RuntimeException();
	}
}
