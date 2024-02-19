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
// import Controller.PatientController;
public class PatientModel {
    public int AutopatientId() {
        int id_Patient = 0;
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select MAX(userID) as 'NextPatientID' from Users");
            rs.next();
            id_Patient = rs.getInt(1);
            if (rs.wasNull()) {
                return 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return id_Patient + 1;
    }

    public boolean register(int pid, String pass) {
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate("insert into Users values('" + pid + "','" + "Patient" + "','" + pass + "')");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean patient_Registration(int pid, String fn, String ln, String G, String cn, int age, String Eid,
            String BloodGroup, String Address) {
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO Patients VALUES ('" + pid + "','" + fn + "','" + ln + "','" + G + "','" + cn
                    + "','" + age + "','" + Eid + "','" + BloodGroup + "','" + Address + "')");
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
            Patient pa=new Patient(id);
            ResultSet rs = st.executeQuery(
                    "Select PatientID,First_Name,Last_Name,Age,Gender,BloodGroup,EmailId,ContactNumber,Address from patients where PatientId="
                            + pa.getPatientID());
            while (rs.next()) {
                Patient pa1;
                pa1=new Patient(pa.getPatientID(),rs.getString("First_Name") , rs.getString("Last_Name"),rs.getString("Gender"), rs.getString("ContactNumber"),  rs.getInt("Age"), rs.getString("BloodGroup") , rs.getString("Address"), rs.getString("EmailId"));
                profile.add(pa1);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "hey");
        }
        return profile;
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doc = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "Select First_Name,Age,Doctor_Type,Qualification from doctors");
            while (rs.next()) {
                Doctor dc=new Doctor(rs.getString("First_Name"), rs.getInt("Age"), rs.getString("Doctor_Type"), rs.getString("Qualification"));
                doc.add(dc);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "hey");
        }
        return doc;
    }

    public int AutoAppo() {
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select MAX(AppointmentID) from Appointments");
            User u=new User(rs.getInt(1));
            rs.next();
            if (rs.wasNull()) {
                u.setUserId(1);
                return u.getUserId();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return u.getUserId() + 1;
    }

    public List<String> getDoctorType(String Doctype) {
        List<String> dtype = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            // Ensure single quotes around the Doctype value
            ResultSet rs = st.executeQuery(
                    "Select DoctorId,First_Name,Entry_Charge,Email_Id,Qualification from doctors where Doctor_Type = '"
                            + Doctype + "'");
            while (rs.next()) {
                String d = "Doctor Id: "
                        + rs.getInt("DoctorId") + ", First Name: "
                        + rs.getString("First_Name")
                        + ", Entry Charge: " + rs.getString("Entry_Charge")
                        + ", EmailId: "
                        + rs.getString("Email_Id")
                        + ", Qulification: "
                        + rs.getString("Qualification");
                dtype.add(d);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " hey");
        }
        return dtype;
    }

    public String getDoctorName(int did) {
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet name = st.executeQuery("Select First_Name from doctors where DoctorID=" + did);
            if (name.next()) {
                Doctor d=new Doctor(name.getString("First_Name")) ;
                return d.getFirstName();
            } else {
                return "Sorry no Doctor Name";
            }
        } catch (Exception e) {
            return "Sorry no Doctor Name";
        }
    }

    public int getDoctorFees(int did) {
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet name = st.executeQuery("Select Entry_Charge from doctors where DoctorID=" + did);
            if (name.next()) {
                int result = name.getInt("Entry_Charge");
                return result;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public String getDoctorQualification(int did) {
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet name = st.executeQuery("Select Qualification from doctors where DoctorID=" + did);
            if (name.next()) {
                String result = name.getString("Qualification");
                return result;
            } else {
                return "Sorry no Qulaifications";
            }
        } catch (Exception e) {
            return "Sorry no Qualifications";
        }
    }

    public boolean CheckAppointment(int Apid, String Problem, int pid,int Doctor_id,String payment_status,
            String Appointment_Status) {
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            Appointment a=new Appointment(pid, Problem, pid, Doctor_id, payment_status, Appointment_Status);
            st.executeUpdate("INSERT INTO Appointments VALUES ('" + a.getAppointmentID() + "','" + a.getProblem() + "','" + a.getPatientId() + "','" + a.getDoctorID() +"','"+ a.getPaymentStatus() + "','" + a.getAppointmentStatus() + "')");
            return true;
        } catch (Exception e) {
            System.out.println("EXCEPTION OCCURS" + e.getMessage());
            return false;
        }
    }

    public List<Reports> getAllReports(int id) {
        List<Reports> doc = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            Reports e=new Reports(id,null);
            ResultSet rs = st.executeQuery(
                    "select * from Reports where PatientID = " + e.getPatientId());
            while (rs.next()) {
                Reports re=new Reports(rs.getInt("ReportID"), rs.getInt("appointmentID"), e.getPatientId(), rs.getInt("DoctorID"), rs.getString("MedicinePrescribed"), rs.getString("DoctorComment"));
                doc.add(re);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "hey");
        }
        return doc;
    }

    public List<String> viewAppo(int id, String appo) {
        List<String> doc = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs;
            if(appo.equals("Pending")){
                rs = st.executeQuery("SELECT * FROM appointments WHERE PatientID="+id+" AND Appointment_Status IN('Pending')");
            }
            else{
                 rs= st.executeQuery("SELECT * FROM appointments WHERE PatientID="+id+" AND Appointment_Status IN('Completed')");
            }
            while (rs.next()) {
                String d = "Appointment_ID: "
                        + rs.getString("AppointmentID")
                        + ",  Problem  : " + rs.getString("Problem")
                        + ", PatientId: "
                        + rs.getString("PatientId") + ", Doctor_Id : "
                        + rs.getString("DoctorID") + ", DoctorFees: "
                        + rs.getString("DoctorFees");
                doc.add(d);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "hey");
        }
        return doc;
    }
    public boolean updateFeedback(int id,int points,String  Doc_Nature, String Location,String YourComment){
        try {
			Connection con=Dbconnection.getConnection();
			Statement st=con.createStatement();
			st.executeUpdate("INSERT INTO feedback VALUES ('"+id+"','"+points+"','"+Doc_Nature+"','"+Location+"','"+YourComment+"')");
			return true;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
        return false;
    }
}