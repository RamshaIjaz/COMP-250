public class ContactsFriend extends Contacts {

	private String address;
	private String birthdate;

	public ContactsFriend(String name, String phone, String address, String birthday) {
		super(name, phone);

		this.address = address;
		this.birthdate = birthday;

	}
	
	//getter method to get Address
	public String getAddress() {
		return address;
	}
	
	//getter method to get Birthdate
	public String getBirthdate() {
		return birthdate;
	}
	
	// overriding toString method; this method prints Acquaintance contact details
	// i.e. Name, Phone, Address and Birthdate
	@Override
	public String toString() {
		return "\n" + this.getName() + "\n" + this.getPhone() + "\n" + this.getAddress() + "\n" + this.getBirthdate() + "\n";

	}

}
