package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.Appointment;
import DAO.Doctor;
import DAO.Feedback;
import DAO.Patient;
import DAO.Reports;
import View.Report;

public class AdminModel {
    public int addDoctor(String password) {
        int doctorId = generateDoctorId();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO Users VALUES ('" + doctorId + "', 'Doctor', '" + password + "')");
            System.out.println("Doctor registered successfully!");
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return doctorId;
    }

    private int generateDoctorId() {
        int docId = 0;
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(UserID) AS NextUserID FROM Users WHERE userType='Doctor'");
            rs.next();
            docId = rs.getInt("NextUserID");
            if (rs.wasNull()) {
                docId = 1;
            } else {
                docId++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return docId;
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctorsList = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Doctors");
            while (rs.next()) {
                Doctor doc = new Doctor(rs.getInt("DoctorID"), rs.getString("First_Name"), rs.getString("Last_Name"),
                        rs.getString("Gender"), rs.getString("ContactNumber"), rs.getInt("Age"),
                        rs.getInt("Entry_Charge"), rs.getString("Qualification"), rs.getString("Doctor_Type"),
                        rs.getString("Email_Id"));
                doctorsList.add(doc);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return doctorsList;
    }

    public List<Patient> getAllPatients() {
        List<Patient> PatientList = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patients"); // Assuming Doctors table exists
            while (rs.next()) {
                Patient p = new Patient(rs.getInt("PatientID"), rs.getString("First_Name"), rs.getString("Last_Name"),
                        rs.getString("Gender"), rs.getString("ContactNumber"), rs.getInt("Age"),
                        rs.getString("BloodGroup"), rs.getString("Address"), rs.getString("EmailId"));
                PatientList.add(p);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return PatientList;
    }

    public boolean deleteDoctor(int id) {
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM Doctors WHERE DoctorID = " + id);
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> AppoList = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT a.AppointmentID,a.Problem,a.PatientId,a.DoctorId,b.First_Name,b.Doctor_Type,b.Qualification,b.Entry_Charge,a.PaymentStatus,a.Appointment_Status FROM appointments a,doctors b WHERE a.DoctorId = b.DoctorId;");
            while (rs.next()) {
                Appointment a = new Appointment(rs.getInt("AppointmentID"), rs.getString("Problem"),
                        rs.getInt("PatientId"), rs.getInt("DoctorId"), rs.getString("First_Name"),
                        rs.getString("Qualification"), rs.getInt("Entry_Charge"), rs.getString("Doctor_Type"),
                        rs.getString("PaymentStatus"), rs.getString("Appointment_Status"));
                AppoList.add(a);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return AppoList;
    }

    public List<Feedback> getAllFeedbacks() {
        List<Feedback> FeedList = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM feedback");
            while (rs.next()) {
                Feedback fee = new Feedback(rs.getInt("PatientID"),rs.getInt("Points"),rs.getString("Doc_Nature"),rs.getString("Location"),rs.getString("PatientComment"));
                FeedList.add(fee);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return FeedList;
    }

    public List<Reports> getAllReports() {
        List<Reports> Reports = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM reports"); 
            while (rs.next()) {
                Reports report = new Reports( rs.getInt("ReportID"),rs.getInt("appointmentID"), rs.getInt("patientID"),rs.getInt("DoctorID"),rs.getString("MedicinePrescribed"),rs.getString("DoctorComment"));
                Reports.add(report);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Reports;
    }
}
