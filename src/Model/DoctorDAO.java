package Model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import DAO.Doctor;
import DAO.User;
public class DoctorDAO {
 public boolean doctor_Registration(int docid, String fn, String ln, String G, String cn, int age, int ec, String Q,
			String dt, String ed) {
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			Doctor doo = new Doctor(docid, fn, ln, G, cn, age, ec, Q, dt, ed);
			st.executeUpdate("INSERT INTO Doctors VALUES ('" + doo.getDoctorId() + "','" + doo.getFirstName() + "','"
					+ doo.getLastName() + "','" + doo.getGender() + "','" + doo.getContactNumber()
					+ "','" + doo.getAge() + "','" + doo.getEntry() + "','" + doo.getQualification() + "','"
					+ doo.getDoctorType() + "','" + doo.getEmailId() + "')");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
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
						rs.getInt("Age"), rs.getString("Doctor_Type"), rs.getString("Qualification"),
						rs.getString("Email_Id"), rs.getString("ContactNumber"));
				;
				profile.add(doc);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "hey");
		}
		return profile;
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

     public int addDoctor(String password) {
        UserDAO userDAO = new UserDAO();
        int doctorId = userDAO.generateDoctorId();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            User u=new User(doctorId, "Doctor", password);
            st.executeUpdate("insert into Users values('" + u.getUserId() + "','" + u.getUserType() + "','" + u.getPassword() + "')");
            System.out.println("Doctor registered successfully!");
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return doctorId;
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

    
    public List<Doctor> getAllDoctor() {
        List<Doctor> doc = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "Select First_Name,Age,Doctor_Type,Qualification from doctors");
            while (rs.next()) {
                Doctor dc = new Doctor(rs.getString("First_Name"), rs.getInt("Age"), rs.getString("Doctor_Type"),
                        rs.getString("Qualification"));
                doc.add(dc);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "hey");
        }
        return doc;
    }

    
    public List<Doctor> getDoctorType(String Doctype) {
        List<Doctor> dtype = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            Doctor d=new Doctor(Doctype,null);
            ResultSet rs = st.executeQuery(
                    "Select DoctorId,First_Name,Entry_Charge,Email_Id,Qualification from doctors where Doctor_Type LIKE '"
                            + d.getDoctorType() + "'");
            while (rs.next()) {
                Doctor d2=new Doctor(rs.getInt("DoctorId"), rs.getString("First_Name"), rs.getInt("Entry_Charge"), rs.getString("Email_Id"), rs.getString("Qualification"));
                dtype.add(d2);
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
                Doctor d = new Doctor(name.getString("First_Name"));
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

}
