//Program to define Subclass Circle
package oops_polymorphsim.overriding.v1;


class Circle extends Shape {
	private double radius;

	// Constructor for Circle
	public Circle(double radius) {
		this.radius = radius;
	}

	// Override draw method for Circle
	@Override
	public void draw() {
		System.out.println("Drawing a circle with radius " + radius);
	}

	// Override erase method for Circle
	@Override
	public void erase() {
		System.out.println("Erasing a circle with radius " + radius);
	}
}
