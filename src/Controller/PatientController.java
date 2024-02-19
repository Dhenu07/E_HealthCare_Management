package Controller;

import java.util.List;

import DAO.Doctor;
import DAO.Patient;
import DAO.Reports;
import Model.PatientModel;

public class PatientController {
    private PatientModel pm = new PatientModel();

    public int AutoPatientID() {
        return pm.AutopatientId();
    }

    public boolean register(int pid, String pass) {
        return pm.register(pid, pass);
    }

    public boolean patient_Registration(int pid, String fn, String ln, String G, String cn, int age, String Eid,
            String BloodGroup, String Address) {
        return pm.patient_Registration(pid, fn, ln, G, cn, age, Eid, BloodGroup, Address);
    }

    public boolean checkPatient(int pid, String pass) {
        return pm.checkPatient(pid, pass);
    }

    public List<Patient> ShowPatientDetails(int id) {
        return pm.getProfile(id);
    }

    public List<Doctor> getAllDoctors() {
        return pm.getAllDoctors();
    }

    public int AutoAppointmentID() {
        return pm.AutoAppo();
    }

    public List<String> DoctorType(String doc) {
        return pm.getDoctorType(doc);
    }

    public String GetDoctorName(int did) {
        return pm.getDoctorName(did);
    }

    public int GetDoctorFees(int did) {
        return pm.getDoctorFees(did);
    }

    public String GetDoctorQualification(int did) {
        return pm.getDoctorQualification(did);
    }

    public boolean CheckAppointment(int Apid, String Problem, int pid,  int docFees, String payment_status,
            String Appointment_Status) {
        return pm.CheckAppointment(Apid, Problem, pid, 
                docFees, payment_status, Appointment_Status);
    }

    public List<Reports> getAllReports(int id) {
        return pm.getAllReports(id);
    }

    public List<String> viewAppo(int id, String appoo) {
        return pm.viewAppo(id, appoo);
    }

    public boolean updateFeedback(int id, int points, String Doc_Nature, String Location, String YourComment) {
        return pm.updateFeedback(id,
                points, Doc_Nature, Location, YourComment);
    }
}
