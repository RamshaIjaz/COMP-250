public class ContactsAcquaintance extends Contacts {

	public ContactsAcquaintance(String name, String phone) {
		super(name, phone);								//passing name and phone to Contact class
	}
	
	
	// overriding toString method; this method prints Acquaintance contact details
	// i.e. Name and Phone
	@Override
	public String toString() {
		return "\n" + this.getName() + "\n" + this.getPhone() + "\n";

	}

}
