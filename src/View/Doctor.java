package View;
import java.util.Scanner;

import Controller.DoctorController;
public class Doctor extends Person
{
    DoctorController doctor = new DoctorController();
	int docid;
	String Doctor_Type;
	String Qualification;
	int Entry_Charge;
	Scanner sc=new Scanner(System.in);
	/***********************************************************************************************/ 
	@SuppressWarnings("static-access")
    public void DoctorRegistration(int docid)
	{
		System.out.println("Enter the following Details");
		this.docid=docid;
		System.out.println("Doctor ID "+docid);
		super.UserInformation();
    	System.out.println("EntryFee");
    	Entry_Charge=sc.nextInt();
    	System.out.println("Qualification:");
    	Qualification=sc.next();
    	System.out.println("Doctor_Type:");
    	System.out.println("1.Eyes\n 2.EAR.\n3.Heart\n4.Bone\n5.Lungs\n6.Kidney\n7.General_Physicist");
    	int ch=sc.nextInt();
    	switch(ch)
		{
			case 1:
			{
				Doctor_Type="Eyes";
				break;
			}
			case 2:
			{
				Doctor_Type="Ear";
				break;
			}
			case 3:
			{
				Doctor_Type="Heart";
				break;
			}
			case 4:
			{
				Doctor_Type="Bone";
				break;
			}

			case 5:
			{
				Doctor_Type="Lungs";
				break;
			}
			case 6:
			{
				Doctor_Type="Kidney";
				break;
			}
			case 7:
			{
				Doctor_Type="General Physicist";
				break;
			}
			default:
			{
				System.out.println("Select Appropriate option");
			}
				
		}
    	 doctor.addDoctor(docid,First_Name,Last_Name,Gender,CN,age,Entry_Charge,Qualification,Doctor_Type,Email_Address);
	}
}

