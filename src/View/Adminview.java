package View;

import java.util.List;
import java.util.Scanner;
import Controller.AdminController;
import DAO.Feedback;

public class Adminview {
    public static void viewAdmin() throws InterruptedException {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------Welcome Admin-------------------");
        String un;
        String pd;
        Doctor d = null;
        AdminController control = new AdminController();
        System.out.print("USERNAME-->");
        un = sc.next();
        System.out.print("Password-->");
        pd = sc.next();
        if ((un.compareTo("Dhenu") == 0 && pd.compareTo("1234") == 0)
                || (un.compareTo("xyz") == 0 && pd.compareTo("1234") == 0)) {
            while (true) {
                System.out.println(
                        "\t---------------------------------------------------------------------------------------------");
                System.out.println(
                        "\t|                  1.Doctor List                                                             |");
                System.out.println(
                        "\t|                  2.Patient List.                                                           |");
                System.out.println(
                        "\t|                  3.Add Doctor                                                              |");
                System.out.println(
                        "\t|                  4.Remove Doctor                                                           |");
                System.out.println(
                        "\t|                  5.Appointment Details                                                     |");
                System.out.println(
                        "\t|                  6.View Feedbacks                                                          |");
                System.out.println(
                        "\t|                  7.View Reports                                                            |");
                System.out.println(
                        "\t|                  8.Logout                                                                  |");
                System.out.println(
                        "\t----------------------------------------------------------------------------------------------");
                System.out.print("Select Your Option: ");
                int ch = sc.nextInt();
                System.out.println();
                switch (ch) {
                    case 1: {
                        List<DAO.Doctor> doctors = control.getAllDoctors();
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
                    case 2: {
                        List<DAO.Patient> patients = control.getAllPatients();
                        if (!patients.isEmpty()) {
                            System.out.println("List of Patients :");
                            for (DAO.Patient p : patients) {
                                System.out.println(p);
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
                        d = new Doctor();
                        d.DoctorRegistration(id);
                        break;
                    }
                    case 4: {
                        System.out.println("Enter Doctor Id to Delete : ");
                        int id = sc.nextInt();
                        if (control.deleteDoctor(id)) {
                            System.out.println("Doctor Deleted successfully!");
                        } else {
                            System.out.println("Some Error occurred");
                        }
                        break;
                    }
                    case 5: {
                        List<DAO.Appointment> Appo = control.getAllAppointments();
                        if (!Appo.isEmpty()) {
                            System.out.println("List of Appointments :");
                            for (DAO.Appointment appo : Appo) {
                                System.out.println(appo);
                            }
                        } else {
                            System.out.println("No Appointments found.");
                        }
                        break;
                    }
                    case 6: {
                        List<DAO.Feedback> feed = control.getAllFeedbacks();
                        if (!feed.isEmpty()) {
                            System.out.println("List of Feedbacks :");
                            for (DAO.Feedback fee : feed) {
                                System.out.println(fee);
                            }
                        } else {
                            System.out.println("No Feedbacks found.");
                        }
                        break;
                    }
                    case 7: {
                        List<DAO.Reports> reports = control.getAllReports();
                        if (!reports.isEmpty()) {
                            System.out.println("List of Reports :");
                            for (DAO.Reports repo : reports) {
                                System.out.println(repo);
                            }
                        } else {
                            System.out.println("No Reports found.");
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
                }// end of switch
            } // end of while
        } else {
            System.out.println("Invalid Username or Password");
        }
    }
}
