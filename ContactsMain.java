import java.util.HashMap;
import java.util.Scanner;

public class ContactsMain {

	public static void main(String[] args) {

		String name, phone, address, buisnessName, birthday, response; // declaring variables

		HashMap<String, Contacts> phoneBook = new HashMap<String, Contacts>(); // Instantiating a hashMap

		Scanner ask = new Scanner(System.in);

		System.out.println("1. New Contact\n" + "2. Find Contact\n" + "3. List All\n" + "4. Quit");

		response = ask.nextLine();

		// loops until user enters Quit
		while (!response.equals("Quit")) {

			// creates a new contact in the HashMap; loops if the type entered is incorrect
			if (response.equals("New Contact")) {

				System.out.println("\nAcquaintance, Business, Friend");
				response = ask.nextLine();

				// saving an entry for Acquaintance
				if (response.equals("Acquaintance")) {
					System.out.println("\nEnter a name.");
					name = ask.nextLine();
					System.out.println("Enter a phone number.");
					phone = ask.nextLine();

					phoneBook.put(name, new ContactsAcquaintance(name, phone));

					System.out.println();
				}

				// saving an entry for Business
				else if (response.equals("Business")) {
					System.out.println("\nEnter a name.");
					name = ask.nextLine();
					System.out.println("Enter a phone number.");
					phone = ask.nextLine();
					System.out.println("Enter an address.");
					address = ask.nextLine();
					System.out.println("Enter a buisness name.");
					buisnessName = ask.nextLine();

					phoneBook.put(name, new ContactsBusiness(name, phone, address, buisnessName));

					System.out.println();
				}

				// saving an entry for Friend
				else if (response.equals("Friend")) {
					System.out.println("\nEnter a name.");
					name = ask.nextLine();
					System.out.println("Enter a phone number.");
					phone = ask.nextLine();
					System.out.println("Enter an address.");
					address = ask.nextLine();
					System.out.println("Enter a birthday.");
					birthday = ask.nextLine();

					phoneBook.put(name, new ContactsFriend(name, phone, address, birthday));

					System.out.println();
				}

				else {
					System.out.println("Invalid type.");
				}

			}

			// Finds a contact if its in the HashMap
			if (response.equals("Find Contact")) {

				System.out.println("\nEnter a name.");
				name = ask.nextLine();

				Contacts value = phoneBook.get(name);

				// If there is no entry in the HashMap
				if (value == null) {
					System.out.println("Contact not found.\n");
				}

				else {

					// prints contact details if the type is Acquaintance
					if (value.getClass().getName().equals("Acquaintance")) {
						System.out.println(((ContactsAcquaintance) value).toString());

					}

					// prints contact details if the type is Business
					else if (value.getClass().getName().equals("Business")) {
						System.out.println(((ContactsBusiness) value).toString());

					}

					// prints contact details if the type is Friend
					else {
						System.out.println(((ContactsFriend) value).toString());
					}
				}
			}

			// lists all of the entries in the HashMap
			else if (response.equals("List All")) {

				System.out.println(
						"\nTYPE                          NAME                          PHONE                         ADDRESS                       BuisnessName                  BirthDate");

				// Enhanced For loop goes through all the keys and prints out their respective
				// object's contents in a table format
				for (String key : phoneBook.keySet()) {

					Contacts entry = phoneBook.get(key);

					if (entry.getClass().getName().equals("Acquaintance")) {
						System.out.print("Acquaintance");
						formatString("Acquaintance");
						System.out.print(((ContactsAcquaintance) entry).getName());
						formatString(((ContactsAcquaintance) entry).getName());
						System.out.println(((ContactsAcquaintance) entry).getPhone());

					}

					else if (entry.getClass().getName().equals("Business")) {
						System.out.print("Business");
						formatString("Business");
						System.out.print(((ContactsBusiness) entry).getName());
						formatString(((ContactsBusiness) entry).getName());
						System.out.print(((ContactsBusiness) entry).getPhone());
						formatString(((ContactsBusiness) entry).getPhone());
						System.out.print(((ContactsBusiness) entry).getAddress());
						formatString(((ContactsBusiness) entry).getAddress());
						System.out.println(((ContactsBusiness) entry).getbuisnessName());

					}

					else {
						System.out.print("Friend");
						formatString("Friend");
						System.out.print(((ContactsFriend) entry).getName());
						formatString(((ContactsFriend) entry).getName());
						System.out.print(((ContactsFriend) entry).getPhone());
						formatString(((ContactsFriend) entry).getPhone());
						System.out.print(((ContactsFriend) entry).getAddress());
						formatString(((ContactsFriend) entry).getAddress());
						formatString("");
						System.out.println(((ContactsFriend) entry).getBirthdate());

					}
				}

			}

			System.out.println("\n1. New Contact\n" + "2. Find Contact\n" + "3. List All\n" + "4. Quit");

			response = ask.nextLine();

		}
		ask.close();

	}

	// method pads empty spaces in order to align contact details in the table;
	// 30 is the ballpark value for contact entries's size
	private static void formatString(String string) {
		int space;

		// if an empty string is passed or if the length of the string is one then
		// advance to next column
		if (string.length() == 1) {
			space = 29;
		}

		else {
			space = 29 - string.length();
		}

		// printing empty spaces
		for (int i = 0; i <= space; i++) {
			System.out.print(" ");
		}

	}

}
