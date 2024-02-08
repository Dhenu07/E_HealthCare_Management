package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public List<String> getAllDoctors() {
        List<String> doctorsList = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Doctors"); // Assuming Doctors table exists
            while (rs.next()) {
                String doctorDetails = "ID: " + rs.getInt("DoctorID") + ", First-Name: " + rs.getString("First_Name")
                        + ", Last-Name: " + rs.getString("Last_Name") + ", Gender: " + rs.getString("Gender")
                        + ", Age: " + rs.getString("Age")
                        + ", PhoneNumber: " + rs.getString("ContactNumber") + ", DoctorFees: "
                        + rs.getString("Entry_Charge") + ", Qualification: " + rs.getString("Qualification")
                        + ", DoctorType: " + rs.getString("Doctor_Type") + ", EmailId: " + rs.getString("Email_Id");
                doctorsList.add(doctorDetails);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return doctorsList;
    }

    public List<String> getAllPatients() {
        List<String> PatientList = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patients"); // Assuming Doctors table exists
            while (rs.next()) {
                String PatientDetails = "Patient ID: " + rs.getInt("PatientID") + ", First-Name: "
                        + rs.getString("First_Name")
                        + ", Last-Name: " + rs.getString("Last_Name") + ", Gender: " + rs.getString("Gender")
                        + ", PhoneNumber: " + rs.getString("ContactNumber") + ", BloodGroup: "
                        + rs.getString("BloodGroup")
                        + ", Age: " + rs.getString("Age") + ", EmailId: " + rs.getString("EmailId") + ", Address: "
                        + rs.getString("Address");
                PatientList.add(PatientDetails);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return PatientList;
    }

    public void deleteDoctor(int id) {
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM Doctors WHERE DoctorID = " + id);
            System.out.println("Doctor Deleted successfully!");
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<String> getAllAppointments() {
        List<String> AppoList = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM appointments"); // Assuming Doctors table exists
            while (rs.next()) {
                String AppoDetails = "Appointment ID: " + rs.getInt("AppointmentID") + ", Problem: "
                        + rs.getString("Problem")
                        + ", Patient Id: " + rs.getInt("PatientId") + ", Doctor Name: " + rs.getString("DoctorName")
                        + ", Doctor Id: " + rs.getInt("DoctorId") + ", Doctor Type: "
                        + rs.getString("DoctorType")
                        + ", Qualification: " + rs.getString("Qualification") + ", DoctorFees: "
                        + rs.getInt("DoctorFees") + ", PaymentStatus: "
                        + rs.getString("PaymentStatus") + "Appointment Status: " + rs.getString("Appointment_Status");
                AppoList.add(AppoDetails);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return AppoList;
    }

    public List<String> getAllFeedbacks() {
        List<String> FeedList = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM feedback"); // Assuming Doctors table exists
            while (rs.next()) {
                String FeeDetails = "Patient ID: " + rs.getInt("PatientID") + ", Points: "
                        + rs.getInt("Points")
                        + ", Docor Nature: " + rs.getString("Doc_Nature") + ", Location: " + rs.getString("Location")
                        + ", Patient Comment: "
                        + rs.getString("PatientComment");
                FeedList.add(FeeDetails);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return FeedList;
    }

    public List<String> getAllReports() {
        List<String> Reports = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM reports"); // Assuming Doctors table exists
            while (rs.next()) {
                String reports = "Report Id: " + rs.getInt("ReportID") + ", Appointment ID: "
                        + rs.getInt("appointmentID")
                        + ", Patient ID: " + rs.getInt("patientID") + ", Doctor ID: " + rs.getInt("DoctorID")
                        + ", MedicinePrescribed: "
                        + rs.getString("MedicinePrescribed") + ", Doctor Comment: "
                        + rs.getString("DoctorComment");
                Reports.add(reports);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Reports;
    }
}
