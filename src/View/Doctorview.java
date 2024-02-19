    package View;

    import java.sql.Connection;
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
                        System.out.print("\t*                  1.View Doctor Profile                                                     *\n");
                        System.out.print("\t*                  2.View Appointments                                                        *\n");
                        System.out.print("\t*                  3.Diagonist Patient                                                        *\n");
                        System.out.print("\t*                  4.Logout                                                                  *\n");
                        System.out.print("\t*                                                                                            *\n");
                        System.out.print("\t**********************************************************************************************\n");	
                        int ch=sc.nextInt();
                        switch(ch)
                        {
                            case 1:
                            {
                            List<DAO.Doctor> profile = doctor.getProfile(id);
                            if (!profile.isEmpty()) {
                                System.out.println("Doctor Profile:");
                                for (DAO.Doctor pro : profile) {
                                    System.out.println(pro);
                                }
                            } else {
                                System.out.println("No doctor profile found.");
                            }
                            break;
                            }
                            case 2:
                            { 
                            List<DAO.Appointment> appo = doctor.getAppo(id);
                            if (!appo.isEmpty()) {
                                System.out.println("Appointments:");
                                for (DAO.Appointment aro : appo) {
                                    System.out.println(aro);
                                }
                            } else {
                                System.out.println("No Appointments found.");
                            }
                                break;
                            }
                            case 3:
                            {
                                List<DAO.Appointment> appo = doctor.getAppo(id);
                            if (!appo.isEmpty()) {
                                System.out.println("Appointments:");
                                for (DAO.Appointment aro : appo) {
                                    System.out.println(aro);
                                }
                            } else {
                                System.out.println("No Appointments found.");
                            }
                                System.out.println("Enter Appointment_Id of the patient which you want to check!!");
                                int appid=sc.nextInt();
                                boolean f=doctor.Appointment_checker(appid,id);
                                if(f)
                                {
                                        int pid=doctor.GetPatientID(appid);
                                        Report rp=new Report();
                                        rp.DiagonistReport(pid,appid,id);
                                    break;
                                }
                                else
                                {
                                    System.out.println("******Wrong appointmentID****");
                                    System.out.println("Enter 1 to leave!!!");
                                    if(sc.nextInt()==1)
                                        break;
                            }
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

