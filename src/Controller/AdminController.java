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
        return adminModel.getAllDoctors();
    }

    public void deleteDoctor(int id) {
        adminModel.deleteDoctor(id);
    }
}
