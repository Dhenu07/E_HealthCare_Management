package View;
import java.util.List;
import java.util.Scanner;
import Controller.AdminController;

public class Adminview {
    public static void viewAdmin() throws InterruptedException {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************Welcome to Admins portal***********************");
        String un;
        String pd;
        Doctor d=null;
        AdminController control = new AdminController();
        System.out.print("USERNAME-->");
        un = sc.next();
        System.out.print("Password-->");
        pd = sc.next();
        if ((un.compareTo("abc") == 0 && pd.compareTo("1234") == 0)
                || (un.compareTo("xyz") == 0 && pd.compareTo("1234") == 0)) {
            while (true) {
                System.out.println(
                        "\t**********************************************************************************************");
                System.out.println(
                        "\t*                  1.DoctorsList                                                             *");
                System.out.println(
                        "\t*                  2.PatientsList.                                                           *");
                System.out.println(
                        "\t*                  3.AddDoctor                                                               *");
                System.out.println(
                        "\t*                  4.RemoveDoctor                                                            *");
                System.out.println(
                        "\t*                  5.AppointmentsDetail                                                      *");
                System.out.println(
                        "\t*                  6.ViewFeedbacks                                                           *");
                System.out.println(
                        "\t*                  7.ViewReports                                                             *");
                System.out.println(
                        "\t*                  8.LOGOUT                                                                  *");
                System.out.println(
                        "\t**********************************************************************************************");
                System.out.print("Select Your Option: ");
                int ch = sc.nextInt();
                System.out.println();
                switch (ch) {
                    case 1: {
                        List<String> doctors = control.getAllDoctors();
                        if (!doctors.isEmpty()) {
                            System.out.println("List of Doctors :");
                            for (String doctor : doctors) {
                                System.out.println(doctor);
                            }
                        } else {
                            System.out.println("No doctors found.");
                        }
                        break;
                    }
                    case 2: {
                        List<String> patients = control.getAllPatients();
                        if (!patients.isEmpty()) {
                            System.out.println("List of Patients :");
                            for (String doctor : patients) {
                                System.out.println(doctor);
                            }
                        } else {
                            System.out.println("No Patients found.");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Enter Doctor Email:");
                        String email = sc.next();
                        System.out.println("Enter Doctor Password:");
                        String password = sc.next();
                        int id = control.addDoctor(email, password);
                        System.out.println("New doctor ID generated: " + id);
                        d=new Doctor();
                        d.DoctorRegistration(id);
                        break;
                    }
                    case 4: {
                        System.out.println("Enter Doctor Id to Delete : ");
                        int id = sc.nextInt();
                        control.deleteDoctor(id);
                        break;
                    }
                    case 5:{
                        List<String> Appo = control.getAllAppointments();
                        if (!Appo.isEmpty()) {
                            System.out.println("List of Appointments :");
                            for (String appo : Appo) {
                                System.out.println(appo);
                            }
                        } else {
                            System.out.println("No Appointments found.");
                        }
                        break;
                    }
                    case 6:{
                        List<String> feed = control.getAllFeedbacks();
                        if (!feed.isEmpty()) {
                            System.out.println("List of Feedbacks :");
                            for (String fee : feed) {
                                System.out.println(fee);
                            }
                        } else {
                            System.out.println("No Feedbacks found.");
                        }
                        break;
                    }
                    case 7:{
                        List<String> reports = control.getAllReports();
                        if (!reports.isEmpty()) {
                            System.out.println("List of Reports :");
                            for (String repo : reports) {
                                System.out.println(repo);
                            }
                        } else {
                            System.out.println("No Reports found.");
                        }
                        break;
                    }
                    case 8:
		    				{
                                System.out.println("Exiting...");
                                Mainview.main(null);
                                break;
		    				}
                    default: {
                        System.out.println("Please Choose An Appropriate Option!!!");
                    }
                }// end of switch
            } // end of while
        } else {
            System.out.println("Invalid Username or Password");
        }
    }
}
