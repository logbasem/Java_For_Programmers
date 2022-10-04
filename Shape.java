package project_5;
import java.lang.Math;

/**A class for defining a shape (circle, rectangle, or triangle) being able to find that shape's area or a given side.
 * @version 1.0
 * @author logan
 *
 */
public class Shape {
	//data variables
	
	private String name;
	private int sideA;
	private int sideB;
	private int sideC;
	
	//constructors
	
	//constructor for circle
	public Shape(int sideA) {
		name = "circle";
		this.sideA = sideA;
		sideB = -1;
		sideC = -1;
	}
	
	//constructor for rectangle
	public Shape(int sideA, int sideB) {
		name = "rectangle";
		this.sideA = sideA;
		this.sideB = sideB;
		sideC = -1;
	}
	
	//constructor for triangle
	public Shape(int sideA, int sideB, int sideC) {
		name = "triangle";
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}
	
	//methods
	
	//method for returning the area of a given circle, rectangle, or triangle shape
	public double getArea() {
		if(name.equals("circle")) {
			return Math.PI * (sideA * sideA);
		}
		else if(name.equals("rectangle")) {
			return sideA * sideB;
		}
		else {
			double s = (sideA + sideB + sideC)/2;
			return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
		}
	}
	
	//methods to update the parameters of an existing shape
	//update one side of the shape
	public boolean setSideA(int i) {
		sideA = i;
		return true;
	}
	
	//update second side (for rectanagle or triangle)
	public boolean setSideB(int j) {
		if(name.equals("circle")) {
			return false;
		} else {
			sideB = j;
			return true;
		}
	}
	
	//update third side (for triangles only)
	public boolean setSideC(int k) {
		if(name.equals("triangle")) {
			sideC = k;
			return true;
		} else {
			return false;
		}
	}
	
	//toString override for Shape
	@Override
	public String toString() {
		if(name.equals("circle")) {
			return  "Area of Circle: " + getArea();
		}
		else if(name.equals("rectangle")) {
			return "Area of Rectangle: " + getArea();
		}
		else {
			return "Area of Triangle: " + getArea();
		}
	}
	
}
