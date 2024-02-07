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
        List<String> doctorsList = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patients"); // Assuming Doctors table exists
            while (rs.next()) {
                String doctorDetails = "Patient ID: " + rs.getInt("PatientID") + ", First-Name: "
                        + rs.getString("First_Name")
                        + ", Last-Name: " + rs.getString("Last_Name") + ", Gender: " + rs.getString("Gender")
                        + ", PhoneNumber: " + rs.getString("ContactNumber") + ", BloodGroup: "
                        + rs.getString("BloodGroup")
                        + ", Age: " + rs.getString("Age") + ", EmailId: " + rs.getString("EmailId") + ", Address: "
                        + rs.getString("Address");
                doctorsList.add(doctorDetails);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return doctorsList;
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
}
