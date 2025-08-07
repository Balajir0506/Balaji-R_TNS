//Program to define Subclass Triangle
package oops_polymorphsim.overriding.v1;

public class Triangle extends Shape {
	private double base;
	private double height;

	// Constructor for Triangle
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	// Override draw method for Triangle
	@Override
	public void draw() {
		System.out.println("Drawing a triangle with base " + base + " and height " + height);
	}

	// Override erase method for Triangle
	@Override
	public void erase() {
		System.out.println("Erasing a triangle with base " + base + " and height " + height);
	}
}
