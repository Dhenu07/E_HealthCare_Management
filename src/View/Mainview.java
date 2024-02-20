package View;

import java.util.*;

public class Mainview {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(
				"\n\t------------------------------Welcome to Appolo Healthcare------------------------------\n");
		boolean check = false;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print(
					"\t----------------------------------------------------------------------------------------------\n");
			System.out.print(
					"\t|                  1. ADMIN    -  LOGIN                                                       |\n");
			System.out.print(
					"\t|                  2. PATIENT  -  LOGIN                                                       |\n");
			System.out.print(
					"\t|                  3. DOCTOR   -  LOGIN                                                       |\n");
			System.out.print(
					"\t|                  4. PATIENT  -  SIGN UP                                                     |\n");
			System.out.print(
					"\t|                  5. EXIT                                                                    |\n");
			System.out.print(
					"\t----------------------------------------------------------------------------------------------\n");
			System.out.print("Enter Your Role : ");
			int choice = sc.nextInt();
			System.out.println();
			switch (choice) {
				case 1: {
					Adminview.viewAdmin();
					break;
				}
				case 2: {
					Patientview.viewPatient();
					break;
				}
				case 3: {
					Doctorview.viewDoctor();
					break;
				}
				case 4: {
					Patientview.newPatient();
					break;
				}
				case 5: {
					System.out.println("Exiting...");
					System.exit(5);
					break;
				}
			}
		}
	}
}