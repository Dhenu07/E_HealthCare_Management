package Controller;

import java.util.List;

import DAO.Appointment;
import DAO.Doctor;
import DAO.Feedback;
import DAO.Patient;
import DAO.Reports;
import Model.AdminModel;

public class AdminController {
    private AdminModel adminModel;

    public AdminController() {
        this.adminModel = new AdminModel();
    }

    public int addDoctor(String email, String password) {
        return adminModel.addDoctor(password);
    }

    public List<Doctor> getAllDoctors() {
        return adminModel.getAllDoctors();
    }

    public List<Patient> getAllPatients() {
        return adminModel.getAllPatients();
    }

    public boolean deleteDoctor(int id) {
        return adminModel.deleteDoctor(id);
    }
    public List<Appointment> getAllAppointments() {
        return adminModel.getAllAppointments();
    }

    public List<Feedback> getAllFeedbacks() {
        return adminModel.getAllFeedbacks();
    }
    public List<Reports> getAllReports(){
        return adminModel.getAllReports();
    }
}
