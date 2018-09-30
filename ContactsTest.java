public class ContactsTest {

	public static void main(String[] args) {

		// Creating objects of each class
		Contacts acquaintance2 = new ContactsAcquaintance("Wu", "561-967-2222");
		Contacts buisness2 = new ContactsBusiness("Marley", "111-222-9898", "89-EastSide, Ottawa", "Marley");
		Contacts friend2 = new ContactsFriend("Serah", "666-889-2828", "3445- Hutchison, Montreal, QC", "16-06-1995");
		ContactsAcquaintance acquaintance1 = new ContactsAcquaintance("Bob", "541-000-900");
		ContactsBusiness buisness1 = new ContactsBusiness("Liz", "538-856-9640", "786-Durocher Montreal, QC", "Elizabeth");
		ContactsFriend friend1 = new ContactsFriend("John", "438-975-2129", "967-Pickering, Toronto, BC", "6-02-1998");

		// Testing methods of Abstract Contact Class on each subclass that it inherits
		System.out.println("Tesing Abstract Contact Class on subclass Acquaintance.");
		System.out.println("Name: " + acquaintance2.getName());
		System.out.println("Phone: " + acquaintance2.getPhone() + "\n");

		System.out.println("Tesing Abstract Contact Class on subclass Business.");
		System.out.println("Name: " + buisness2.getName());
		System.out.println("Phone: " + buisness2.getPhone() + "\n");

		System.out.println("Tesing Abstract Contact Class on subclass Friend.");
		System.out.println("Name: " + friend2.getName());
		System.out.println("Phone: " + friend2.getPhone() + "\n");

		// Testing methods of Acquaintance class
		System.out.println("Testing Acquaintance Class.");
		System.out.println("Name: " + acquaintance1.getName());
		System.out.println("Phone: " + acquaintance1.getPhone() + "\n");
		System.out.println("Testing toString() method in Acquaintance.");
		System.out.println(acquaintance1.toString() + "\n");

		// Testing methods of Business Class
		System.out.println("Testing Business Class.");
		System.out.println("Name: " + buisness1.getName());
		System.out.println("Phone: " + buisness1.getPhone());
		System.out.println("Address: " + buisness1.getAddress());
		System.out.println("BuisnessName: " + buisness1.getbuisnessName() + "\n");
		System.out.println("Testing toString() in Business.");
		System.out.println(buisness1.toString() + "\n");

		// Testing methods of Friend Class
		System.out.println("Testing Friend Class.");
		System.out.println("Name: " + friend1.getName());
		System.out.println("Phone: " + friend1.getPhone());
		System.out.println("Birthday: " + friend1.getBirthdate() + "\n");
		System.out.println("Testing toString() in Friend.");
		System.out.println(friend1.toString());

	}

}
