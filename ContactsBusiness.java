public class ContactsBusiness extends Contacts {

	private String address;
	private String buisnessName;

	public ContactsBusiness(String name, String phone, String address, String buisnessName) {

		super(name, phone);
		this.address = address;
		this.buisnessName = buisnessName;
	}
	
	//getter method to get Address
	public String getAddress() {
		return address;
	}
	
	//getter method to get BuisnessName
	public String getbuisnessName() {
		return buisnessName;
	}
	
	// overriding toString method; this method prints Business contact details
	// i.e. Name, Phone, Address and BusinessName
	@Override
	public String toString() {
		return "\n" + this.getName() + "\n" + this.getPhone() + "\n" + this.getAddress() + "\n" + this.getbuisnessName() + "\n";

	}

}
