package View;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

import Controller.PatientController;

public class Patientview {
    public static void viewPatient() throws InterruptedException {
        PatientController pc = new PatientController();
        Patients p = new Patients();
        Scanner sc = new Scanner(System.in);
        boolean checkPatient = false;
        System.out.println("*****************Welcome to patient portal***********************");
        int id;
        String pd;
        System.out.print("ID:");
        id = sc.nextInt();
        System.out.print("Password:");
        pd = sc.next();
        boolean flag = pc.checkPatient(id, pd);
        if (flag) {
            p = new Patients();
            while (true) {
                System.out.print(
                        "\t**********************************************************************************************\n");
                System.out.print(
                        "\t*                  1.ViewProfile                                                             *\n");
                System.out.print(
                        "\t*                  2.viewDoctors                                                             *\n");
                System.out.print(
                        "\t*                  3.BookAppointments                                                        *\n");
                System.out.print(
                        "\t*                  4.ViewReport                                                              *\n");
                System.out.print(
                        "\t*                  5.viewAppointments Pending                                                        *\n");
                System.out.print(
                        "\t*                  6.viewCompletedAppointments                                               *\n");
                System.out.print(
                        "\t*                  7.Give FeedBack                                                           *\n");
                System.out.print(
                        "\t*                  8.LOGOUT                                                                  *\n");
                System.out.print(
                        "\t**********************************************************************************************\n");
                System.out.println("Enter your choice- ");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1: {
                        List<DAO.Patient> profile = pc.ShowPatientDetails(id);
                        if (!profile.isEmpty()) {
                            System.out.println("Patient Profile:");
                            for (DAO.Patient pro : profile) {
                                System.out.println(pro);
                            }
                        } else {
                            System.out.println("No Patient profile found.");
                        }
                        break;
                    }
                    case 2: {
                        List<DAO.Doctor> doctors = pc.getAllDoctors();
                        if (!doctors.isEmpty()) {
                            System.out.println("List of Doctors :");
                            for (DAO.Doctor doctor : doctors) {
                                System.out.println(doctor);
                            }
                        } else {
                            System.out.println("No doctors found.");
                        }
                        break;
                    }
                    case 3: {
                        p.BookAppointment(id);
                        break;
                    }
                    case 4: {
                        List<DAO.Reports> prepo = pc.getAllReports(id);
                        if (!prepo.isEmpty()) {
                            System.out.println("Reports :");
                            for (DAO.Reports po : prepo) {
                                System.out.println(po);
                            }
                        } else {
                            System.out.println("No Reports found.");
                        }
                        break;
                    }
                    case 5: {
                        String appoo = "Pending";
                        int t = 0;
                        List<String> viewapp = pc.viewAppo(id, appoo);
                        if (!viewapp.isEmpty()) {
                            System.out.println("Appointments :");
                            for (String ap : viewapp) {
                                t++;
                                System.out.println("*** APPOINTMENT - NUMBER : " + t);
                                System.out.println(ap);
                            }
                        } else {
                            System.out.println("No Appointments found.");
                        }
                        break;
                    }
                    case 6: {
                        String appoo = "Completed";
                        int t = 0;
                        List<String> viewapp = pc.viewAppo(id, appoo);
                        if (!viewapp.isEmpty()) {
                            System.out.println("Appointments :");
                            for (String ap : viewapp) {
                                t++;
                                System.out.println("*** APPOINTMENT - NUMBER : " + t);
                                System.out.println(ap);
                            }
                        } else {
                            System.out.println("No Appointments found.");
                        }
                        break;
                    }
                    case 7:
                    {
                        System.out.println("*********Please Fill The Following Feedback Form*********");
                        int pid=id;
                        System.out.println("Patient Id:"+pid);
                        System.out.println("Please Give points to our services out of 10 :");
                        int points=sc.nextInt();
                        System.out.println("Nature Of The Doctor");
                        String Doc_Nature = sc.next();
                        Doc_Nature +=sc.nextLine();
                        System.out.println("Enter Your Address below");
                        String Location = sc.next();
                        Location +=sc.nextLine();
                        System.out.println("Your Comment:");
                        String YourComment = sc.next();
                        YourComment +=sc.nextLine();
                        if(pc.updateFeedback(pid,points, Doc_Nature, Location,YourComment)){
                            System.out.println("Your Feedback has been updated");
                            System.out.println("-->>Thank You For Visiting Us<<--");
	    	                System.out.println("-->>Your Feedback Meant a lot to Us<<--");
                        }
                        else{
                           System.out.println("Something went wrong");
                        }
                        break;
                    }
                    case 8: {
                        System.out.println("Exiting...");
                        Mainview.main(null);
                        break;
                    }
                    default: {
                        System.out.println("Please Choose An Appropriate Option!!!");
                    }
                }
                if (checkPatient)
                    break;
            }
        } else {
            System.out.println("Invali UserID or password!!!");
        }
    }

    public static void newPatient() {
        Patients p = new Patients();
        int pid = p.addPatient();
        System.out.println("*** Fill the following details ***");
        boolean pp = p.PatientRegistration(pid);
        if (pp) {
            System.out.println("Details Added Successfully");
        } else {
            System.out.println("Something Failed");
        }
    }
}

class Patients extends Person {
    Scanner sc = new Scanner(System.in);
    String BloodGroup;
    PatientController pc = new PatientController();

    public int addPatient() {
        int PatientID = pc.AutoPatientID();
        String password;
        String cpd;
        System.out.println("Patient ID:" + PatientID);
        System.out.println("Enter Password:");
        password = sc.next();
        while (true) {
            System.out.println("Confirm Password");
            cpd = sc.next();
            if (password.compareTo(cpd) == 0)
                break;
            else {
                System.out.println("Your Password is not matching!!!");
                System.out.println("*\tRE-ENTER The Password*");
            }
        }
        boolean add = pc.register(PatientID, password);
        if (add) {
            System.out.println("Registed Successfully");
        } else {
            System.out.println("Something went wrong");
        }
        return PatientID;

    }

    public boolean PatientRegistration(int pid) {
        super.UserInformation();
        System.out.println("BloodGroup:");
        BloodGroup = sc.next();
        return pc.patient_Registration(pid, First_Name, Last_Name, Gender, CN, age, Email_Address, BloodGroup, Address);
    }

    public void BookAppointment(int id) {
        Appointment ap = new Appointment();
        ap.BookAppointment(id);
    }
}
