package View;

import java.util.Date;
import java.util.Scanner;

public class Person {
	protected String First_Name;
	protected String Last_Name;
	protected String Email_Address;
	protected String Gender;
	protected int age;
	protected Date DOB;
	protected String CN;
	protected String city;
	protected String state;
	protected String Country;
	protected String Address;
	protected Date RegistrationDate;
	Scanner sc = new Scanner(System.in);

	protected void UserInformation() {

		System.out.print("First Name: ");
		First_Name = sc.nextLine();
		System.out.print("Last Name: ");
		Last_Name = sc.nextLine();
		System.out.print("Email Address: ");
		Email_Address = sc.nextLine();
		System.out.println("Gender: ");
		Gender = sc.nextLine();
		System.out.print("Age: ");
		age = sc.nextInt();
		sc.nextLine();
		System.out.print("Contact Number: ");
		CN = sc.nextLine();
		System.out.print("City: ");
		city = sc.nextLine();
		System.out.print("State:");
		state = sc.nextLine();
		System.out.print("Country: ");
		Country = sc.nextLine();
		System.out.print("Address: ");
		Address = sc.nextLine();
	}
}
