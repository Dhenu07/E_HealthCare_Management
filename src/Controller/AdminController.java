package Controller;

import java.util.List;

import Model.AdminModel;

public class AdminController {
    private AdminModel adminModel;

    public AdminController() {
        this.adminModel = new AdminModel();
    }

    public int addDoctor(String email, String password) {
        return adminModel.addDoctor(password);
    }

    public List<String> getAllDoctors() {
        return adminModel.getAllDoctors();
    }

    public List<String> getAllPatients() {
        return adminModel.getAllPatients();
    }

    public void deleteDoctor(int id) {
        adminModel.deleteDoctor(id);
    }
    public List<String> getAllAppointments() {
        return adminModel.getAllAppointments();
    }

    public List<String> getAllFeedbacks() {
        return adminModel.getAllFeedbacks();
    }
    public List<String> getAllReports(){
        return adminModel.getAllReports();
    }
}
