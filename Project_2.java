/** This program takes Imperial measurements as input, then converts them and outputs them as Metric measurements.
 * @author Logan Murphy
 * @version 1.0
 */
//imports
import java.util.Scanner;
import java.text.DecimalFormat;

public class Project_2 {
	public static void main(String[] args) {
		//new scanner and new decimal format variables
		Scanner scnr = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");
		DecimalFormat df0 = new DecimalFormat("0.00");
		
		//starting message
		System.out.println("Welcome to Imperial to Metric Conversion Calculator");
		
		//Fahrenheit-Celsius Conversion
		System.out.println("Please enter the temperature in degree Fahrenheit:");
		double degreesFahrenheit = scnr.nextDouble();
		double degreesCelsius = (degreesFahrenheit - 32) * (5.0/9.0);
		System.out.println("The temperature in degree Celsius is " + df.format(degreesCelsius) + " C");
		
		//Fluid Ounces-Liters Conversion
		System.out.println("Please enter the volume of liquid in fluid ounces:");
		double volumeOunces = scnr.nextDouble();
		double volumeLiter = (volumeOunces * 29.5735) / 1000;
		System.out.println("The volume of the liquid in Liters is " + df.format(volumeLiter) + " L");
		
		//Pounds-Kilograms Conversion
		System.out.println("Please enter the weight of an object in pounds:");
		double weightPounds = scnr.nextDouble();
		double weightKilograms = (weightPounds * 454) / 1000.0;
		System.out.println("The weight of an object in kilograms is " + df0.format(weightKilograms) + " Kg");
		
		//Miles-Kilometers Conversion
		System.out.println("Please enter the distance to a city in miles:");
		double distanceMiles = scnr.nextDouble();
		double distanceKilometers = (distanceMiles * 1.609);
		System.out.println("The distance to a city in kilometers is " + df.format(distanceKilometers) + " Km");
	}

}
