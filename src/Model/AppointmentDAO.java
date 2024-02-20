package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.Appointment;

public class AppointmentDAO {
    public List<Appointment> getAppoint(int id) {
		List<Appointment> appo = new ArrayList<>();
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			Appointment ap = new Appointment(id);
			ResultSet rs = st.executeQuery("Select * from  Appointments where DoctorID=" + ap.getDoctorID()
					+ " AND PaymentStatus IN('Payed') AND Appointment_Status In('Pending')");
			while (rs.next()) {
				Appointment ap1 = new Appointment(rs.getInt("AppointmentID"), rs.getString("Problem"),
						rs.getInt("PatientId"), rs.getInt("DoctorFees"), rs.getString("PaymentStatus"));
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
			Appointment apo = new Appointment(id);
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
    public void ChangeStatus(int appid) {
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			Appointment apo = new Appointment(appid, 0);
			st.executeUpdate("UPDATE Appointments SET Appointment_Status='Completed' WHERE AppointmentID="
					+ apo.getAppointmentID());
		} catch (Exception e) {
			System.out.println("e.getMessage()");
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

    public int AutoAppo() {
        int y = 0;
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select MAX(AppointmentID) from Appointments");
            rs.next();
            y = rs.getInt(1);
            if (rs.wasNull()) {
                y = 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (y + 1);
    }


    public boolean CheckAppointment(int Apid, String Problem, int pid, int Doctor_id, String payment_status,
            String Appointment_Status) {
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            Appointment a = new Appointment(Apid, Problem, pid, Doctor_id, payment_status, Appointment_Status);
            st.executeUpdate("INSERT INTO Appointments VALUES ('" + a.getAppointmentID() + "','" + a.getProblem()
                    + "','" + a.getPatientId() + "','" + a.getDoctorID() + "','" + a.getPaymentStatus() + "','"
                    + a.getAppointmentStatus() + "')");
            return true;
        } catch (Exception e) {
            System.out.println("EXCEPTION OCCURS" + e.getMessage());
            return false;
        }
    }

    public List<Appointment> viewAppo(int id, String ap1) {
        List<Appointment> doc = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs;
            Appointment appo = new Appointment(id, ap1);
            rs = st.executeQuery("SELECT * FROM appointments WHERE PatientID=" + appo.getPatientId()
                    + " AND Appointment_Status LIKE 'Pending'");
            while (rs.next()) {
                Appointment ap = new Appointment(rs.getInt("AppointmentID"), rs.getInt("PatientId"), rs.getInt("DoctorID"),
                        rs.getString("Problem"));
                doc.add(ap);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "hey");
        }
        return doc;
    }

}
