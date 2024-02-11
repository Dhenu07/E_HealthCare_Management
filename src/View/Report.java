package View;
import java.util.List;
import java.util.Scanner;
import Controller.DoctorController;
public class Report {
    Scanner input=new Scanner(System.in);  
    int RepId=0;
    private String MedicinePrescribed;
	private String DoctorsComment;
    DoctorController doctor=new DoctorController();
	public void DiagonistReport(int pid,int appid,int docid)
	{
        RepId=doctor.AutoReportID();
		System.out.println("ReportID--"+RepId);
		System.out.println("PatientID--"+pid);
		System.out.println("AppointmentID--"+appid);
		System.out.println("DoctorID--"+docid);
		System.out.println("Prescribed medicine to patient--");
		MedicinePrescribed=input.nextLine();
		System.out.println("Additional Information--");
		DoctorsComment=input.nextLine();
		System.out.println("Enter 1 to Generate Report--");
		int x=input.nextInt();
		if(x==1)
		{
            boolean o=doctor.GenerateReport(RepId,appid,pid,docid,MedicinePrescribed,DoctorsComment);
            if(o){
               System.out.println("Report Generated Succesfully!!!");
               List<String> report = doctor.ShowReport(RepId);
                            if (!report.isEmpty()) {
                                System.out.println("Report:");
                                for (String re : report) {
                                    System.out.println(re);
                                }
                            } else {
                                System.out.println("No Reports.");
                            }
            }
		}
		else
		{
			System.out.println("** Enter Appropriate Details Please **");	
		}
	}
}
