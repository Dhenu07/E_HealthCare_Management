package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.Feedback;

public class FeedbackDAO {
     public List<Feedback> getAllFeedbacks() {
        List<Feedback> FeedList = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM feedback");
            while (rs.next()) {
                Feedback fee = new Feedback(rs.getInt("PatientID"),rs.getInt("Points"),rs.getString("Doc_Nature"),rs.getString("Location"),rs.getString("PatientComment"));
                FeedList.add(fee);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return FeedList;
    }

    
    public boolean updateFeedback(int id, int points, String Doc_Nature, String Location, String YourComment) {
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            Feedback fee=new Feedback(id, points, Doc_Nature, Location, YourComment);
            st.executeUpdate("INSERT INTO feedback VALUES ('" + fee.getPatientID() + "','" + fee.getPoints() + "','" + fee.getDocNature() + "','"
                    + fee.getLocation() + "','" + fee.getPatientComment() + "')");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
