package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.Appointment;
import DAO.Patient;

public class PatientDAO {
    public int GetPatientID(int apid) {
		int i = 0;
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			Appointment a = new Appointment(apid, 0);
			ResultSet rs = st.executeQuery("select * from Appointments where AppointmentID=" + a.getAppointmentID());
			while (rs.next()) {
				i = (rs.getInt(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int AutoReportID() {
		int y = 0;
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select MAX(ReportId) as NextUserID from Reports");
			rs.next();
			y = rs.getInt(1);
			if (rs.wasNull()) {
				return y;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return y + 1;
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

    public boolean patient_Registration(int pid, String fn, String ln, String G, String cn, int age, String Eid,
            String BloodGroup, String Address) {
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            Patient p = new Patient(pid, ln, cn, G, BloodGroup, age, G, Address, Eid);
            st.executeUpdate("INSERT INTO Patients VALUES ('" + p.getPatientID() + "','" + p.getFirst_Name() + "','"
                    + p.getLast_Name() + "','" + p.getGender() + "','" + p.getContact_Number()
                    + "','" + p.getAge() + "','" + p.getEmail_Id() + "','" + p.getBlood_Group() + "','" + p.getAddress()
                    + "')");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean checkPatient(int id, String pd) {
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from Users");
            while (rs.next()) {
                if (rs.getInt(1) == id && rs.getString(2).compareTo("Patient") == 0
                        && (rs.getString(3).compareTo(pd) == 0)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public List<Patient> getProfile(int id) {
        List<Patient> profile = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            Patient pa = new Patient(id);
            ResultSet rs = st.executeQuery(
                    "Select PatientID,First_Name,Last_Name,Age,Gender,BloodGroup,EmailId,ContactNumber,Address from patients where PatientId="
                            + pa.getPatientID());
            while (rs.next()) {
                Patient pa1;
                pa1 = new Patient(pa.getPatientID(), rs.getString("First_Name"), rs.getString("Last_Name"),
                        rs.getString("Gender"), rs.getString("ContactNumber"), rs.getInt("Age"),
                        rs.getString("BloodGroup"), rs.getString("Address"), rs.getString("EmailId"));
                profile.add(pa1);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "hey");
        }
        return profile;
    }


}
