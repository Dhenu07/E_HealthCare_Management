package View;
import java.util.List;
import java.util.Scanner;

import Controller.PatientController;

public class Appointments {
    private int Apid;
    private int pid;
    private String Problem;
    private int Doctor_id;
    private String Doctor_Name;
    private String Doctor_Type;
    private String Doctor_Qualification;
    private int docFees;
    private String Appointment_Status = "Pending";
    private String payment_status;
    Scanner sc = new Scanner(System.in);
    PatientController pc = new PatientController();

    public void BookAppointment(int id) {
        Apid = pc.AutoAppointmentID();
        System.out.println("Appointment ID:" + Apid);
        pid = id;
        System.out.println("Patient ID:" + pid);
        System.out.println("Enter your Problem:");
        Problem = sc.nextLine();
        Doctor_id = ChooseDoctor();
        while (Doctor_id == 0) {
            System.out.println("** PLEASE CHOOSE AN APPROPRIATE OPTION **");
            Doctor_id = ChooseDoctor();
        }
        Doctor_Name = pc.GetDoctorName(Doctor_id);
        docFees = pc.GetDoctorFees(Doctor_id);
        Doctor_Qualification = pc.GetDoctorQualification(Doctor_id);
        int d;
        System.out.println("\t** Enter 1 to confirm **");
        d = sc.nextInt();
        if (d == 1) {
            ConfirmAppointment();
        }
    }

    private int ChooseDoctor() {
        System.out.println("*** Choose Doctor Type According to your problem!! ***");
        System.out.print(
                "\t----------------------------------------------------------------------------------------------\n");
        System.out.print(
                "\t|                                                                                            |\n");
        System.out.print(
                "\t|                  1.Eyes_Specialist                                                         |\n");
        System.out.print(
                "\t|                  2.EAR_Specialist                                                          |\n");
        System.out.print(
                "\t|                  3.Heart_Specialist                                                        |\n");
        System.out.print(
                "\t|                  4.Bones_Specialist                                                        |\n");
        System.out.print(
                "\t|                  5.Lungs_Specialist                                                        |\n");
        System.out.print(
                "\t|                  6.Kidney_Specialist                                                       |\n");
        System.out.print(
                "\t|                  7.General_Physicist                                                       |\n");
        System.out.print(
                "\t|                                                                                            |\n");
        System.out.print(
                "\t----------------------------------------------------------------------------------------------\n");
        int ch = sc.nextInt();
        switch (ch) {
            case 1: {
                Doctor_Type = "Eyes";
                break;
            }
            case 2: {
                Doctor_Type = "Ears";
                break;
            }
            case 3: {
                Doctor_Type = "Heart";
                break;
            }
            case 4: {
                Doctor_Type = "Bones";
                break;
            }
            case 5: {
                Doctor_Type = "Lungs";
            }
            case 6: {
                Doctor_Type = "Kidney";
                break;
            }
            case 7: {
                Doctor_Type = "General";
            }
            default: {
                return 0;
            }
        }
        List<DAO.Doctor> profile = pc.DoctorType(Doctor_Type);
        if (!profile.isEmpty()) {
            System.out.println("Doctor Profile:");
            for (DAO.Doctor pro : profile) {
                System.out.println(pro);
            }
        } else {
            System.out.println("No Doctor profile found.");
        }
        System.out.println("\t*** Enter the doctor-id which you want to choose ***");
        int choosedID = sc.nextInt();
        return choosedID;
    }
    public String billpayment(int fee)
    {
        System.out.println("Doctor-Fees:" + fee);
        System.out.println("------------------Credit Card Details-----------------------");
        String Status;
		System.out.println("\t\tCARD-HOLDER Name: ");
		String cardHolderName=sc.next();
		System.out.println("\t\tCARD-NUMBER : ");
		String card_no=sc.next();
		System.out.println("\t\tEXPIRY DATE : ");
		String ExpiryDate=sc.next();
		System.out.println("\t\tCVC number: ");
		int cvc=sc.nextInt();
		System.out.println("Please Enter 1 to confirm Payment---");
		int x=sc.nextInt();
		if(x==1)
		{
			System.out.println("Your Payment is confirmed");
			return "Payed";
		}
		else
		{
			System.out.println("Your Payment is cancelled,and Appointments Not yet Confirmed");
			return "NotPayed";
		}
    }

    public void ConfirmAppointment(){
        payment_status = billpayment(docFees);
        boolean confirm=pc.CheckAppointment(Apid,Problem,pid,Doctor_id,payment_status,Appointment_Status);
        if(confirm){
            System.out.println("ThankYou For visiting us your Appointment Has Been confirmed!!!");
        }
        else{
            System.out.println("Appointment Cancelled");
        }

    }}