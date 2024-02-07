package Model;

import java.sql.*;

public class Dbconnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/healthcaremanagementsystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Dsdkdhenu@3522";
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
