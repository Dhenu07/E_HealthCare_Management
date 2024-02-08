package View;

import java.util.*;

import Controller.DoctorController;

public class Doctorview {
    public static void viewDoctor() throws InterruptedException {
        boolean checkDoctor = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("***************Welcome to Doctors portal******************");
        int flag = 0;
        DoctorController doctor = new DoctorController();
        Doctor d=null;
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
                           
                            break;
                        }
                        case 2:
                        {
                            // d=new Doctor();
                            // d.viewAppointment(id);
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

