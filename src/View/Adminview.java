package View;

import java.util.List;
import java.util.Scanner;
import Controller.AdminController;

public class Adminview {
    public static void viewAdmin() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************Welcome to Admins portal***********************");
        String un;
        String pd;
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
                            System.out.println("List of Doctors :");
                            for (String doctor : patients) {
                                System.out.println(doctor);
                            }
                        } else {
                            System.out.println("No doctors found.");
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
                        break;
                    }
                    case 4: {
                        System.out.println("Enter Doctor Id to Delete : ");
                        int id = sc.nextInt();
                        control.deleteDoctor(id);
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
