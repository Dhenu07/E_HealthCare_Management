package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DoctorModel {
    public boolean checkDoctor(int id,String pass){
        try {
		    	Connection con = Dbconnection.getConnection();
                Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("Select * from Users");
				while(rs.next()) {
						if(rs.getInt(1)==id && rs.getString(2).compareTo("Doctor")==0 && (rs.getString(3).compareTo(pass)==0 )){
							return true;
						}
					}
				}catch(Exception e){
					return false;
				}
                return false;

    }
    public void doctor_Registration(int docid,String fn,String ln,String G,String cn,int age,int ec,String Q,String dt,String ed)
	{
		try 
		{
			Connection con = Dbconnection.getConnection();
			Statement st=con.createStatement();
			st.executeUpdate("INSERT INTO Doctors VALUES ('"+docid+"','"+fn+"','"+ln+"','"+G+"','"+cn+"','"+age+"','"+ec+"','"+Q+"','"+dt+"','"+ed+"')");
			System.out.println("Doctor Added Successully");
		}
		catch(Exception e)
		{ System.out.println(e.getMessage());}  
	}
}
