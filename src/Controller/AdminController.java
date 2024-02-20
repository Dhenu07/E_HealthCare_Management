package Controller;

import java.util.List;

import DAO.Appointment;
import DAO.Doctor;
import DAO.Feedback;
import DAO.Patient;
import DAO.Reports;
import Model.AppointmentDAO;
import Model.DoctorDAO;
import Model.FeedbackDAO;
import Model.PatientDAO;
import Model.ReportDAO;

public class AdminController {
    private DoctorDAO ddao;
    private PatientDAO pdao;
    private AppointmentDAO adao;
    private FeedbackDAO feedback;
    private ReportDAO reportDAO;
    public AdminController() {
        this.ddao = new DoctorDAO();
        this.pdao = new PatientDAO();
        this.adao = new AppointmentDAO();
        this.feedback = new FeedbackDAO();
        this.reportDAO = new ReportDAO();
    }

    public int addDoctor(String email, String password) {
        return ddao.addDoctor(password);
    }

    public List<Doctor> getAllDoctors() {
        return ddao.getAllDoctors();
    }

    public List<Patient> getAllPatients() {
        return pdao.getAllPatients();
    }

    public boolean deleteDoctor(int id) {
        return ddao.deleteDoctor(id);
    }
    public List<Appointment> getAllAppointments() {
        return adao.getAllAppointments();
    }

    public List<Feedback> getAllFeedbacks() {
        return feedback.getAllFeedbacks();
    }
    public List<Reports> getAllReports(){
        return reportDAO.getAllReports();
    }
}
