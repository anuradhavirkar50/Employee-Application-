package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	 public void addEmployee(Employee employee) {
		try {
			Connection con=DB.connect();
			PreparedStatement stmt=con.prepareStatement(Query.insert);
			stmt.setInt(1, employee.getId());
			stmt.setString(2, employee.getName());
			stmt.setString(3, employee.getEmail());
			stmt.setDouble(4, employee.getSalary());
			stmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	 
	 
	 public Employee getEmployee(int id) {
			Connection con=DB.connect();
			 Employee employee = null;
		        try {
		            PreparedStatement stmt = con.prepareStatement(Query.read);
		            stmt.setInt(1, id);
		            ResultSet rs = stmt.executeQuery();
		            if (rs.next()) {
		                employee = new Employee(
		                		rs.getInt("id"), 
		                		rs.getString("name"),
		                		rs.getString("email"), 
		                		rs.getDouble("salary")
		                		);
		            }else {
		            	System.out.println("Employee not found.");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return employee;
		}
	 
	public void updateEmployee(Employee employee) {
		try {
			Connection con=DB.connect();
			PreparedStatement stmt=con.prepareStatement(Query.update);
			
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getEmail());
			stmt.setDouble(3, employee.getSalary());
			stmt.setInt(4, employee.getId());
            
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteEmployee(int id) {
		try {
			Connection con=DB.connect();
			PreparedStatement stmt=con.prepareStatement(Query.delete);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = new ArrayList<>();
        try {
        	Connection con=DB.connect();
            PreparedStatement stmt = con.prepareStatement(Query.select);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) { // Move to the next row before accessing data
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email=rs.getString("email");
                double salary = rs.getDouble("salary");

                Employee employee = new Employee(id, name,email, salary);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
	}
	
}


