package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.Appointment;
import DAO.Doctor;
import DAO.Patient;
import DAO.Reports;
import DAO.User;

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

	public List<Doctor> getProfile(int id) {
		List<Doctor> profile = new ArrayList<>();
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"Select DoctorID,First_Name,Last_Name,Age,Doctor_Type,Qualification,Email_Id,ContactNumber from doctors where DoctorID="
							+ id);
			while (rs.next()) {
				Doctor doc = new Doctor(rs.getInt("DoctorID"), rs.getString("First_Name"), rs.getString("Last_Name"),
                        rs.getString("Gender"), rs.getString("ContactNumber"), rs.getInt("Age"),
                        rs.getInt("Entry_Charge"), rs.getString("Qualification"), rs.getString("Doctor_Type"),
                        rs.getString("Email_Id"));
				profile.add(doc);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "hey");
		}
		return profile;
	}

	public List<Appointment> getAppoint(int id) {
		List<Appointment> appo = new ArrayList<>();
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			Appointment ap=new Appointment(id);
			ResultSet rs = st.executeQuery("Select * from  Appointments where DoctorID=" + ap.getDoctorID()
					+ " AND PaymentStatus IN('Payed') AND Appointment_Status In('Pending')");
			while (rs.next()) {
				Appointment ap1=new Appointment(rs.getInt("AppointmentID"),rs.getString("Problem"),rs.getInt("PatientId"),rs.getInt("DoctorFees"),rs.getString("PaymentStatus"));
				appo.add(ap1);
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
			Appointment apo=new Appointment(id);
			ResultSet rs = st.executeQuery("Select * from Appointments where DoctorID=" + apo.getDoctorID());
			while (rs.next()) {
				if (rs.getInt(1) == appid)
					return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Appointment GetPatientID(int apid) {
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			Appointment a=new Appointment(apid,0);
			ResultSet rs = st.executeQuery("select * from Appointments where AppointmentID=" + a.getAppointmentID());
			while (rs.next()) {
				a.setPatientId(rs.getInt(3));;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a.getPatientId();
	}

	public int AutoReportID() {
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select MAX(ReportId) as NextUserID from Reports");
			rs.next();
			User u=new User(rs.getInt(1));
			if (rs.wasNull()) {
				u.setUserId(1);
				return u.getUserId();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return u.getUserId() + 1;
	}

	public boolean GenerateReport(int RepId, int appid, int pid, int docid, String MedicinePrescribed,
			String DoctorsComment) {
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			Reports r = new Reports(RepId, appid, pid, docid, MedicinePrescribed, DoctorsComment);
			st.executeUpdate("INSERT INTO Reports VALUES ('" + r.getReportId() + "','" + r.getAppointmentID() + "','"
					+ r.getPatientId() + "','" + r.getDoctorId()
					+ "','" + r.getMedicinePre() + "','" + r.getDocComment() + "')");
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

	public List<Reports> ReportShowReport(int rid) {
		List<Reports> report = new ArrayList<>();
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			Reports r = new Reports(rid);
			ResultSet rs = st.executeQuery(
					"Select patientID,DoctorID,MedicinePrescribed,DoctorComment from reports where ReportId="
							+ r.getReportId());
			if (rs.next()) {
				Reports r1= new Reports(dochecker(con, rs.getInt("DoctorId")).toString(),pahecker(con, rs.getInt("patientId")).toString(),rs.getString("MedicinePrescribed"),rs.getString("DoctorComment"));
			    report.add(r1);	
			}

		} catch (Exception e) {
			System.out.println(e.getMessage() + " hey");
		}
		return report;
	}

	public Doctor dochecker(Connection con, int did) {
		try {
			Statement st = con.createStatement();
			ResultSet name = st.executeQuery("Select First_Name from doctors where DoctorId=" + did);
			if (name.next()) {
			    Doctor d;
				d = new Doctor(name.getString("First_Name"));
				return d;
			} else {
				System.out.println("NoDoctor");
				return null;
			}
		} catch (Exception e) {
			System.out.println("No doctor found");
			return null;
		}
	}

	public Patient pahecker(Connection con, int pid) {
		try {
			Statement st = con.createStatement();
			ResultSet name = st.executeQuery("Select First_Name from patients where patientId=" + pid);
			if (name.next()) { 
				Patient P;
				P = new Patient(name.getString("First_Name"));
				return P;
			} else {
				System.out.println("Sorry no Patient");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Sorry no Patient");
			return null;
		}
	}

}
