package Controller;

import java.util.List;

import DAO.Appointment;
import DAO.Doctor;
import DAO.Reports;
import Model.AppointmentDAO;
import Model.DoctorDAO;
import Model.PatientDAO;
import Model.ReportDAO;
import Model.UserDAO;

public class DoctorController{
    private DoctorDAO doctorModel;
    private UserDAO user;
    private AppointmentDAO app;
    private PatientDAO po;
    private ReportDAO report;
    public DoctorController() {
        this.doctorModel = new DoctorDAO();
        this.user = new UserDAO();
        this.app = new AppointmentDAO();
        this.po = new PatientDAO();
        this.report = new ReportDAO();
    }
    
    public  boolean checkDoctor(int id, String password) {
        return user.checkDoctor(id, password);
    }

    public boolean addDoctor(int docid,String fn,String ln,String G,String cn,int age,int ec,String Q,String dt,String ed){
        return doctorModel.doctor_Registration(docid,fn,ln,G,cn,age,ec,Q,dt,ed);
    }
   public List<Doctor> getProfile(int id){
       return doctorModel.getProfile(id);
   }
   public List<Appointment> getAppo(int id){
       return app.getAppoint(id);
   }

   public boolean Appointment_checker(int appid,int id){
      return app.cheackAppointment_checker(appid,id);
   }
    
   public int GetPatientID(int apid){
    return po.GetPatientID(apid);
   }

   public int AutoReportID(){
    return report.AutoReportID();
   }

   public boolean GenerateReport(int RepId,int appid,int pid,int docid,String MedicinePrescribed,String DoctorsComment){
    return report.GenerateReport(RepId,appid,pid,docid,MedicinePrescribed,DoctorsComment);
   }
   public List<Reports> ShowReport(int RepId){
    return report.ReportShowReport(RepId);
   }
}
