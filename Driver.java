package project_5;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		//Priming read 
		System.out.println("Select a type from 1 for Circle, 2 for Rectangle, 3 for Triangle or 4 to Quit to exit ");
		int shapeID = keyboard.nextInt();
				
		//This loop will run until user enter quit
		while (shapeID != 4) {
			//User is trying to calculate the area of the circle
			if (shapeID == 1) {
				isCircle(keyboard);
			} else if (shapeID == 2) {
				isRectangle(keyboard);
			} else if (shapeID == 3) {
				isTriangle(keyboard);
			}
			//System.out.println("Enter the shape for which you want to calculate area:");
			System.out.println("Select a type from 1 for Circle, 2 for Rectangle, 3 for Triangle or 4 to Quit to exit ");
		    shapeID = keyboard.nextInt();
		}
		System.out.println("Goodbye!");

	}
	
	//This method will compute the area of circle
	public static void isCircle(Scanner keyboard) {
		System.out.println("Please enter radius of the circle: ");
		int radius = keyboard.nextInt();
		keyboard.nextLine();
		if (radius >= 0) {
				
			//object of Shape class is created to define the dimensions for circle 
			Shape shapeOne = new Shape(radius);
			
			// compute the area of the circle
			// complete the code here

			//ToString method in Shape class display the information is specific format
			System.out.println(shapeOne.toString());
				
			//Check if dimensions need to be updated
			System.out.println("Do you want to compute the area with different dimensions: ");
			String answer = keyboard.nextLine();

			if (answer.equalsIgnoreCase("yes")) {

				System.out.println("Please enter the updated parameter: ");
				int param = keyboard.nextInt();
				keyboard.nextLine();
				//Calling update parameter method to set the new dimensions
				updatedParameter(shapeOne, param);
				//toString method in Shape class display the information is specific format
				System.out.println(shapeOne.toString());
			}
		} else {
			System.out.println("Value of radius is invalid, please try again ");
		}
		
	}
	
	//This method will compute the area of Rectangle
	public static void isRectangle(Scanner keyboard) {
		System.out.println("Please enter sideA of a rectangle: ");
		int sideA = keyboard.nextInt();
		System.out.println("Please enter sideB of a rectangle: ");
		int sideB = keyboard.nextInt();
		keyboard.nextLine();
		
		if(sideA >= 0 && sideB >= 0) {
		
			//object of Shape class to define the dimensions of a rectangle
			Shape shapeTwo = new Shape(sideA, sideB);
			
			//compute and print the area of the rectangle
			System.out.println(shapeTwo.toString());
			
			//check if dimensions need to be updated
			System.out.println("Do you want to compute the area with different dimensions: ");
			String answer = keyboard.nextLine();
			
			if (answer.equalsIgnoreCase("yes")) {
				System.out.println("Please enter the updated parameter: ");
				int param = keyboard.nextInt();
				keyboard.nextLine();
				//calling update parameter method to set the new dimensions
				updatedParameter(shapeTwo, param);
				
				//calculate and print new area
				System.out.println(shapeTwo.toString());
			}
		} else {
			System.out.println("Value of side is invalid, please try again ");
		}
		
	}
	
	//This method will compute the area of triangle
	public static void isTriangle(Scanner keyboard) {
		System.out.println("Please enter sideA of a triangle: ");
		int sideA = keyboard.nextInt();
		System.out.println("Please enter sideB of a triangle: ");
		int sideB = keyboard.nextInt();
		System.out.println("Please enter sideC of a triangle: ");
		int sideC = keyboard.nextInt();
		keyboard.nextLine();
		
		if(sideA >= 0 && sideB >= 0 && sideC >= 0) {
			
			//object of Shape class to define the dimensions of a triangle
			Shape shapeThree = new Shape(sideA, sideB);
			
			//compute and print the area of the triangle
			System.out.println(shapeThree.toString());
			
			//check if dimensions need to be updated
			System.out.println("Do you want to compute the area with different dimensions: ");
			String answer = keyboard.nextLine();
			
			if (answer.equalsIgnoreCase("yes")) {
				System.out.println("Please enter the updated parameter: ");
				int param = keyboard.nextInt();
				keyboard.nextLine();
				//calling update parameter method to set the new dimensions
				updatedParameter(shapeThree, param);
				
				//calculate and print new area
				System.out.println(shapeThree.toString());
			}
		} else {
			System.out.println("Value of side is invalid, please try again ");
		}
	}
	
	// ToDo: Write this method to update first parameter of the triangle, circle or rectangle
	public static void updatedParameter(Shape shapeToUpdate, int param) {
		//updates the first side of the shape
		shapeToUpdate.setSideA(param);
		
		// computes the area
		shapeToUpdate.getArea();
	}
}
