import java.util.ArrayList;
/**Class to hold campaign information for a political campaign.
 * 
 * @author logan
 * @version 1.0
 */
public class Campaign {
	//data variables
	private String candidateName;
	private ArrayList<Donor> donors = new ArrayList<Donor>();
	
	//constructors
	public Campaign(String name) {
		candidateName = name;
	}
	
	//methods
	public String getCandidateName() {
		return candidateName;
	}
	
	public String getDonors() {
		String result = candidateName + "\n";
		result += donors.toString();
		
		return result;
	}
	
	public double getAllDonations() {
		double total = 0;
		for(int i = 0; i < donors.size(); i++) {
			total += donors.get(i).getTotalDonations();
		}
		return total;
	}
	
	public void addDonor(String name) {
		Donor newDonor = new Donor(name);
		donors.add(newDonor);
	}
	
	
	//This method searches for the donor in the donors list
	//If the donor is found, returns the donation amount, if not, returns -1
	public double getDonation(String donor) {
		for(int i = 0; i < donors.size(); i++) {
			Donor currentDonor = donors.get(i);
			if(currentDonor.getName().equals(donor)) {
				return currentDonor.getTotalDonations();
			}
		}
		
		return -1;
	}
	
	public String getDonationList(String donor)
	{
		for (int i=0; i<donors.size(); ++i)
		{
			Donor d = donors.get(i);
			if (d.getName().equals(donor))
			{
				return d.toString();
			}
		}

		return "No donor with that name was found";
	}
	
	public void addDonation(String donorName, double donation) {
		boolean donorFound = false;
		for(int i = 0; i < donors.size(); i++) {
			Donor currentDonor = donors.get(i);
			if(currentDonor.getName().equals(donorName)) {
				donorFound = true;
				currentDonor.addDonation(donation);
			}
		}
		if(!donorFound) {
			Donor newDonor = new Donor(donorName, donation);
			donors.add(newDonor);
		}
	}
}
