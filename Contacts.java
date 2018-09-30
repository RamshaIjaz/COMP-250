public abstract class Contacts {

	private String name;
	private String phone;

	public Contacts(String name, String phone) {

		this.name = name;
		this.phone = phone;

	}
	
	//getter method to get Name
	public String getName() {
		return name;
	}
	
	//getter method to get Phone
	public String getPhone() {
		return phone;
	}
}