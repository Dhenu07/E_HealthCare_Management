package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import DAO.User;

public class UserDAO {
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
    int generateDoctorId() {
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
            User u = new User(pid, "Patient", pass);
            st.executeUpdate("insert into Users values('" + u.getUserId() + "','" + u.getUserType() + "','"
                    + u.getPassword() + "')");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
