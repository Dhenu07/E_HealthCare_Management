package Controller;
import java.util.List;
import Model.DoctorModel;

public class DoctorController{
    private DoctorModel doctorModel;
    
    public DoctorController() {
        this.doctorModel = new DoctorModel();
    }
    
    public  boolean checkDoctor(int id, String password) {
        return doctorModel.checkDoctor(id, password);
    }

    public void addDoctor(int docid,String fn,String ln,String G,String cn,int age,int ec,String Q,String dt,String ed){
        doctorModel.doctor_Registration(docid,fn,ln,G,cn,age,ec,Q,dt,ed);
    }
   public List<String> getProfile(int id){
       return doctorModel.getProfile(id);
   }
   public List<String> getAppo(int id){
       return doctorModel.getAppoint(id);
   }

   public boolean Appointment_checker(int appid,int id){
      return doctorModel.cheackAppointment_checker(appid,id);
   }
    
   public  int GetPatientID(int apid){
    return doctorModel.GetPatientID(apid);
   }

   public int AutoReportID(){
    return doctorModel.AutoReportID();
   }

   public boolean GenerateReport(int RepId,int appid,int pid,int docid,String MedicinePrescribed,String DoctorsComment){
    return doctorModel.GenerateReport(RepId,appid,pid,docid,MedicinePrescribed,DoctorsComment);
   }
   public List<String> ShowReport(int RepId){
    return doctorModel.ReportShowReport(RepId);
   }
}

