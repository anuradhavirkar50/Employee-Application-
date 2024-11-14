package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {
	
	private static Connection con = null;

    public static Connection connect() {
        if (con == null) { // Only create connection if it hasn't been created yet
            try {
                Class.forName("com.mysql.jdbc.Driver"); // Updated MySQL driver class name
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee" , "root", "root");
//                System.out.println("Database connected successfully.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }
	

}
