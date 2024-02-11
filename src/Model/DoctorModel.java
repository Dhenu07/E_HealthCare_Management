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
					+ " AND PaymentStatus IN('Payed') AND Appointment_Status In('Pending'  )");
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

	public boolean cheackAppointment_checker(int appid, int id) {
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from Appointments where DoctorID=" + id);
			while (rs.next()) {
				if (rs.getInt(1) == appid)
					return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public int GetPatientID(int apid) {
		int pid = 0;
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Appointments where AppointmentID=" + apid);
			while (rs.next()) {
				pid = rs.getInt(3);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pid;
	}

	public int AutoReportID() {
		int repID = 0;
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select MAX(ReportId) as NextUserID from Reports");
			rs.next();
			repID = rs.getInt(1);
			if (rs.wasNull()) {
				return 1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return repID + 1;
	}

	public boolean GenerateReport(int RepId, int appid, int pid, int docid, String MedicinePrescribed,
			String DoctorsComment) {
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO Reports VALUES ('" + RepId + "','" + appid + "','" + pid + "','" + docid
					+ "','" + MedicinePrescribed + "','" + DoctorsComment + "')");
			ChangeStatus(appid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private void ChangeStatus(int appid) {
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			st.executeUpdate("UPDATE Appointments SET Appointment_Status='Completed' WHERE AppointmentID=" + appid);
		} catch (Exception e) {
			System.out.println("e.getMessage()");
		}
	}

	public List<String> ReportShowReport(int rid) {
		List<String> report = new ArrayList<>();
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"Select patientID,DoctorID,MedicinePrescribed,DoctorComment from reports where ReportId="
							+ rid);
							if (rs.next()) {
								String ro = "";
								ro = "Doctor Name: " + dochecker(con, rs.getInt("DoctorId")) + "  Patient Name: " + pahecker(con, rs.getInt("patientId")) + "  MedicinePrescribed: " + rs.getString("MedicinePrescribed") + "  DoctorComment:  " + rs.getString("DoctorComment");
								report.add(ro);
							}
							
		} catch (Exception e) {
			System.out.println(e.getMessage() + " hey");
		}
		return report;
	}

	public String dochecker(Connection con, int did) {
		try {
			Statement st = con.createStatement();
			ResultSet name = st.executeQuery("Select First_Name from doctors where DoctorId=" + did);
			if (name.next()) { 
				String result = name.getString("First_Name");
				return result;
			} else {
				return "Sorry no Doctor Name";
			}
		} catch (Exception e) {
			return "Sorry no Doctor Name";
		}
	}
	
	public String pahecker(Connection con, int pid) {
		try {
			Statement st = con.createStatement();
			ResultSet name = st.executeQuery("Select First_Name from patients where patientId=" + pid);
			if (name.next()) { 
				String result = name.getString("First_Name");
				return result;
			} else {
				return "Sorry no Patient Name";
			}
		} catch (Exception e) {
			return "Sorry no Patient Name";
		}
	}
	

}
