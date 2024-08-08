package Controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import DAO.Appointment;
import DAO.Doctor;
import DAO.Patient;
import DAO.Reports;
import Model.AppointmentDAO;
import Model.DoctorDAO;
import Model.FeedbackDAO;
import Model.PatientDAO;
import Model.ReportDAO;
import Model.UserDAO;

public class PatientController {
    private UserDAO userDAO;
    private PatientDAO pao;
    private DoctorDAO doctorDAO;
    private AppointmentDAO apd;
    private ReportDAO re;
    private FeedbackDAO fd;

    public PatientController(){
        this.userDAO = new UserDAO();
        this.pao = new PatientDAO();
        this.doctorDAO = new DoctorDAO();
        this.apd = new AppointmentDAO();
        this.re =new ReportDAO();
        this.fd = new FeedbackDAO();
    }

    public int AutoPatientID() {
        return userDAO.AutopatientId();
    }

    public boolean register(int pid, String pass) {
        return userDAO.register(pid, pass);
    }

    public boolean patient_Registration(int pid, String fn, String ln, String G, String cn, int age, String Eid, 
                                        String BloodGroup, String Address) {
        return pao.patient_Registration(pid, fn, ln, G, cn, age, Eid, BloodGroup, Address);
    }

    public boolean checkPatient(int pid, String pass) {
        return pao.checkPatient(pid, pass);
    }

    public List<Patient> ShowPatientDetails(int id) {
        return pao.getProfile(id);
    }

    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctor();
    }

    public int AutoAppointmentID() {
        return apd.AutoAppo();
    }

    public List<Doctor> DoctorType(String doc) {
        return doctorDAO.getDoctorType(doc);
    }

    public String GetDoctorName(int did) {
        return doctorDAO.getDoctorName(did);
    }

    public int GetDoctorFees(int did) {
        return doctorDAO.getDoctorFees(did);
    }

    public String GetDoctorQualification(int did) {
        return doctorDAO.getDoctorQualification(did);
    }

    public boolean CheckAppointment(int Apid, String Problem, int pid,  int docFees, String payment_status, 
                                    String Appointment_Status) {
        return apd.CheckAppointment(Apid, Problem, pid, docFees, payment_status, Appointment_Status);
    }

    public List<Reports> getAllReports(int id) {
        return re.getAllReports(id);
    }

    public List<Appointment> viewAppo(int id, String appoo) {
        return apd.viewAppo(id, appoo);
    }

    public List<String> getAvailableSlots(int doctorId, java.util.Date date) {
        return apd.getAvailableSlots(doctorId, date);
    }
    public boolean updateFeedback(int id, int points, String Doc_Nature, String Location, String YourComment) {
        return fd.updateFeedback(id, points, Doc_Nature, Location, YourComment);
    }

    public boolean bookAppointment(int appointmentID, String problem, int patientId, int doctorID,String paymentStatus, 
                                   String appointmentStatus, Timestamp appointmentTime) {
        return apd.bookAppointment(appointmentID, problem, patientId, doctorID, paymentStatus, appointmentStatus, appointmentTime);
    }
}
