package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorModel {
	public boolean checkDoctor(int id, String pass) {
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from Users");
			while (rs.next()) {
				if (rs.getInt(1) == id && rs.getString(2).compareTo("Doctor") == 0
						&& (rs.getString(3).compareTo(pass) == 0)) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;

	}

	public void doctor_Registration(int docid, String fn, String ln, String G, String cn, int age, int ec, String Q,
			String dt, String ed) {
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO Doctors VALUES ('" + docid + "','" + fn + "','" + ln + "','" + G + "','" + cn
					+ "','" + age + "','" + ec + "','" + Q + "','" + dt + "','" + ed + "')");
			System.out.println("Doctor Added Successully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<String> getProfile(int id) {
		List<String> profile = new ArrayList<>();
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"Select DoctorID,First_Name,Last_Name,Age,Doctor_Type,Qualification,Email_Id,ContactNumber from doctors where DoctorID="
							+ id);
			while (rs.next()) {
				String pro = "Doctor Id: " + rs.getInt("DoctorID") + ", First Name: "
						+ rs.getString("First_Name")
						+ ", Last Name: " + rs.getString("Last_Name") + ", Age: " + rs.getString("Age")
						+ ", Department: " + rs.getString("Doctor_Type")
						+ ", Qulification: "
						+ rs.getString("Qualification") + ",Email Id: "
						+ rs.getString("Email_Id") + ",Phone Number: "
						+ rs.getString("ContactNumber");
				profile.add(pro);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "hey");
		}
		return profile;
	}

	public List<String> getAppoint(int id) {
		List<String> appo = new ArrayList<>();
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from  Appointments where DoctorID=" + id
					+ " AND PaymentStatus IN('Payed') AND Appointment_Status In('Pending')");
			while (rs.next()) {
				String aro = "Appointment Id : " + rs.getInt("AppointmentID") + ", Problem : "
						+ rs.getString("Problem")
						+ ", PatientId : " + rs.getString("PatientId") + ", DoctorFees : " + rs.getString("DoctorFees")
						+ ", PaymentStatus : " + rs.getString("PaymentStatus");
				appo.add(aro);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return appo;
	}
}
