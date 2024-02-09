package View;

import java.util.*;

import Controller.DoctorController;

public class Doctorview {
    public static void viewDoctor() throws InterruptedException {
        boolean checkDoctor = false;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("***************Welcome to Doctors portal******************");
        DoctorController doctor = new DoctorController();
        int id;
        String pd;
        System.out.print("DOCTOR - ID : ");
        id = sc.nextInt();
        System.out.print("Password : ");
        pd = sc.next();
        if (doctor.checkDoctor(id, pd)) {
                while(true)
                {
                    System.out.print("\t**********************************************************************************************\n");
                    System.out.print("\t*                                                                                            *\n");
                    System.out.print("\t*                  1.view_DOCTOR_Profile                                                     *\n");
                    System.out.print("\t*                  2.viewAppointments                                                        *\n");
                    System.out.print("\t*                  3.DiagonistPatient                                                        *\n");
                    System.out.print("\t*                  4.LOGOUT                                                                  *\n");
                    System.out.print("\t*                                                                                            *\n");
                    System.out.print("\t**********************************************************************************************\n");	
                    int ch=sc.nextInt();
                    switch(ch)
                    {
                        case 1:
                        {
                           List<String> profile = doctor.getProfile(id);
                           if (!profile.isEmpty()) {
                            System.out.println("Doctor Profile:");
                            for (String pro : profile) {
                                System.out.println(pro);
                            }
                        } else {
                            System.out.println("No doctor profile found.");
                        }
                        break;
                        }
                        case 2:
                        { 
                            List<String> appo = doctor.getAppo(id);
                           if (!appo.isEmpty()) {
                            System.out.println("Appointments:");
                            for (String aro : appo) {
                                System.out.println(aro);
                            }
                        } else {
                            System.out.println("No Appointments found.");
                        }
                            break;
                        }
                        case 3:
                        {
                            // d=new Doctor();
                            // d.DiagonistPatient(id);
                            break;
                        }
                        case 4:
                        {
                            System.out.println("Exiting...");
                            Mainview.main(null);
                            break;
                        }
                        default:
                        {
                            System.out.println("Select Approprate option");
                        }
                    }//end of switch.
                    if(checkDoctor)
                        break;
                    }
            }
            else{
                System.out.println("Not Yet Registered");
             }
        }
    }

