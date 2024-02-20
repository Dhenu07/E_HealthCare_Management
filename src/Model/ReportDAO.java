package Model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import DAO.Reports;
import DAO.User;
public class ReportDAO {
    public boolean GenerateReport(int RepId, int appid, int pid, int docid, String MedicinePrescribed,
			String DoctorsComment) {
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			Reports r = new Reports(RepId, appid, pid, docid, MedicinePrescribed, DoctorsComment);
			st.executeUpdate("INSERT INTO Reports VALUES ('" + r.getReportId() + "','" + r.getAppointmentID() + "','"
					+ r.getPatientId() + "','" + r.getDoctorId()
					+ "','" + r.getMedicinePre() + "','" + r.getDocComment() + "')");
            AppointmentDAO dao = new AppointmentDAO();
			dao.ChangeStatus(appid);
			return true;
		} catch (Exception e) {
			return false;
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
                DoctorDAO dao = new DoctorDAO();
                PatientDAO pao=new PatientDAO();
				Reports r1 = new Reports(dao.dochecker(con, rs.getInt("DoctorId")).toString(),
						pao.pahecker(con, rs.getInt("patientId")).toString(), rs.getString("MedicinePrescribed"),
						rs.getString("DoctorComment"));
				report.add(r1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage() + " hey");
		}
		return report;
	}
  
    public List<Reports> getAllReports() {
        List<Reports> Reports = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM reports"); 
            while (rs.next()) {
                Reports report = new Reports( rs.getInt("ReportID"),rs.getInt("appointmentID"), rs.getInt("patientID"),rs.getInt("DoctorID"),rs.getString("MedicinePrescribed"),rs.getString("DoctorComment"));
                Reports.add(report);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Reports;
    }

    public List<Reports> getAllReports(int id) {
        List<Reports> doc = new ArrayList<>();
        try {
            Connection con = Dbconnection.getConnection();
            Statement st = con.createStatement();
            Reports e = new Reports(id, null);
            ResultSet rs = st.executeQuery(
                    "select * from Reports where PatientID = " + e.getPatientId());
            while (rs.next()) {
                Reports re = new Reports(rs.getInt("ReportID"), rs.getInt("appointmentID"), e.getPatientId(),
                        rs.getInt("DoctorID"), rs.getString("MedicinePrescribed"), rs.getString("DoctorComment"));
                doc.add(re);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "hey");
        }
        return doc;
    }

    	public int AutoReportID() {
            int i=0;
		try {
			Connection con = Dbconnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select MAX(ReportId) as NextUserID from Reports");
			rs.next();
			i=rs.getInt(1);
			if (rs.wasNull()) {
				return i=1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return i+1;
	}

}
