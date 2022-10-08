import java.util.Scanner;

/**Main class, contains menu for user that allows a variety of donation and campaign options.
 * 
 * @author logan
 * @version 1.0
 */
public class Election {

	//These constants are used for a menu system
	private static final int ADD_DONOR = 1;
	private static final int DONATION = 2;
	private static final int SUM_DONATIONS = 3;
	private static final int SINGLE_DONOR_DETAILS = 4;
	private static final int QUIT = 5;
	
	//main function
	public static void main(String[] args) {
		Campaign candidate = new Campaign("Mickey Mouse");
		Scanner keyboard = new Scanner(System.in);
		
		int menuChoice = 0;
		//run different methods depending on user choices
		while (menuChoice != QUIT)
		{
			menuChoice = menu(keyboard);
			
			if (menuChoice == ADD_DONOR)
				addDonor(keyboard, candidate);
			else if (menuChoice == DONATION)
				addDonation(keyboard, candidate);
			else if (menuChoice == SUM_DONATIONS)
				sumDonations(candidate);
			else if (menuChoice == SINGLE_DONOR_DETAILS)
				singleDonorDetails(keyboard, candidate);
			else if (menuChoice == QUIT)
				System.out.println("Goodbye");
			else
				System.out.println("Unanticipated case");
		}
	}
	
	//allows for user-entered menu choice using recursion
	private static final int menu(Scanner keyboard)
	{
		System.out.println("Enter your choice below");
		System.out.println(ADD_DONOR + ": add new donor");
		System.out.println(DONATION + ": make donation");
		System.out.println(SUM_DONATIONS + ": find total donations");
		System.out.println(SINGLE_DONOR_DETAILS + ": single donor details");
		System.out.println(QUIT + ": quit");
		
		int value = keyboard.nextInt();
		keyboard.nextLine();
		if (value < ADD_DONOR || value > QUIT)
		{
			System.out.println(value + " is not in the legal range. Please re-enter");
			return menu(keyboard); // this is a cool trick called recursion
		}
		else // it was legal
		{
			return value;
		}
	}
	
	//method to add a new donor to the campaign
	private static void addDonor(Scanner keyboard, Campaign candidate)
	{
		System.out.println("Enter the name of the donor");
		String  name = keyboard.nextLine();
		candidate.addDonor(name);
	}
	
	//method to add a new donation to a donor
	private static void addDonation(Scanner keyboard, Campaign candidate)
	{
		System.out.println("Enter the name of the donor");
		String name = keyboard.nextLine();
		System.out.println("Enter the donation amount");
		double donation = keyboard.nextDouble();		
		
		candidate.addDonation(name, donation);
	}
	
	//method to sum the donations of a given candidate
	private static void sumDonations(Campaign candidate)
	{
		System.out.println(candidate.getCandidateName() + " has $" + candidate.getAllDonations()
				+ " of donations");
	}
	
	//method to give the details of a specific campaign donor
	private static void singleDonorDetails(Scanner keyboard, Campaign candidate)
	{
		System.out.println("Enter the name of the donor");
		String name = keyboard.nextLine();
		double donation = candidate.getDonation(name);
		
		System.out.println("The name of the donor is " + name + " and the amount donated is $" + donation);

	}

}
