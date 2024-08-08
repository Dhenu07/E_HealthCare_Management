package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.Timestamp;


import DAO.Appointment;

public class AppointmentDAO {
      private static final String[] AVAILABLE_TIMES = {
        "09:00:00", "10:00:00", "11:00:00", "12:00:00",
        "14:00:00", "15:00:00", "16:00:00", "19:00:00", "20:00:00"
    };
    

    public List<String> getAvailableSlots(int doctorId, Date date) {
        List<String> availableSlots = new ArrayList<>();
        String query = "SELECT appointment_time FROM appointments WHERE DoctorID = ? AND DATE(appointment_time) = ?";
        Connection con = null;
        try {
            con = Dbconnection.getConnection();
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.setInt(1, doctorId);
                stmt.setDate(2, new java.sql.Date(date.getTime()));
                ResultSet rs = stmt.executeQuery();

                boolean[] slotTaken = new boolean[AVAILABLE_TIMES.length];
                while (rs.next()) {
                    String time = rs.getTime("appointment_time").toString();
                    for (int i = 0; i < AVAILABLE_TIMES.length; i++) {
                        if (time.equals(AVAILABLE_TIMES[i])) {
                            slotTaken[i] = true;
                            break;
                        }
                    }
                }
                for (int i = 0; i < AVAILABLE_TIMES.length; i++) {
                    if (!slotTaken[i]) {
                        availableSlots.add(AVAILABLE_TIMES[i]);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return availableSlots;
    }
    public List<Appointment> getAppoint(int id) {
        List<Appointment> appo = new ArrayList<>();
        String query = "SELECT * FROM appointments WHERE DoctorID = ? AND PaymentStatus IN('Payed') AND Appointment_Status IN('Pending')";
        Connection con = null;
        try {
            con = Dbconnection.getConnection();
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Appointment ap1 = new Appointment(rs.getInt("AppointmentID"), rs.getString("Problem"), rs.getInt("PatientId"), rs.getInt("DoctorID"), rs.getString("PaymentStatus"));
                    appo.add(ap1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
        String query = "SELECT a.AppointmentID, a.Problem, a.PatientId, a.DoctorId, " +
                       "b.First_Name, b.Doctor_Type, b.Qualification, b.Entry_Charge, " +
                       "a.PaymentStatus, a.Appointment_Status, a.appointment_time " +
                       "FROM appointments a " +
                       "JOIN doctors b ON a.DoctorId = b.DoctorId";
        try (Connection con = Dbconnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            
            while (rs.next()) {
                Appointment a = new Appointment(rs.getInt("AppointmentID"), 
                                                rs.getString("Problem"),
                                                rs.getInt("PatientId"), 
                                                rs.getInt("DoctorId"), 
                                                rs.getString("First_Name"),
                                                rs.getString("Qualification"), 
                                                rs.getInt("Entry_Charge"), 
                                                rs.getString("Doctor_Type"),
                                                rs.getString("PaymentStatus"), 
                                                rs.getString("Appointment_Status"),
                                                rs.getTimestamp("appointment_time"));
                AppoList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

    public boolean bookAppointment(int appointmentID, String problem, int patientId, int doctorID, String paymentStatus, String appointmentStatus, Timestamp appointmentTime) {
        String query = "INSERT INTO appointments (AppointmentId, Problem, PatientId, DoctorId, PaymentStatus, Appointment_Status, appointment_time) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Dbconnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, appointmentID);
            stmt.setString(2, problem);
            stmt.setInt(3, patientId);
            stmt.setInt(4, doctorID);
            stmt.setString(5, paymentStatus);
            stmt.setString(6, appointmentStatus);
            stmt.setTimestamp(7, appointmentTime);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
