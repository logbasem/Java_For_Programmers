import java.util.ArrayList;

/**Java class to hold information for a Donor of a political campaign.
 * 
 * @author logan
 * @version 1.0
 */
public class Donor {
	//data variables
	private String name;
	private ArrayList<Double> donations = new ArrayList<Double>();
	
	//constructors
	public Donor() {
		name = "";
	}
	
	public Donor(String name) {
		this.name = name;
	}
	
	public Donor(String name, double donation) {
		this.name = name;
		donations.add(donation);
	}
	
	//methods
	public String getName() {
		return name;
	}
	
	public double getTotalDonations() {
		double total = 0;
		for(int i = 0; i < donations.size(); i++) {
			total += donations.get(i);
		}
		return total;
	}
	
	@Override
	public String toString() {
		return "The name of the donor is " + name + " and the amount donated is $" + getTotalDonations();
	}
	
	public void addDonation(double donation) {
		donations.add(donation);
	}
}
