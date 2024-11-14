package emp;

import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		EmployeeDao dao=new EmployeeDao();
		Scanner sc=  new Scanner(System.in);
		
		
		while(true) {
			
			System.out.println("\n1:Create Employee: ,\n2:Search Employee: ,\n3:Update Employee Data:"
					+ " ,\n4:Delete Employee:,\n5:Read Employee Data:,\n6:Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			
			if(choice<1||choice>=6) break;
			switch(choice) {
			case 1:
				System.out.print("Enter ID: ");
                int id = sc.nextInt();
                System.out.print("Enter Name: ");
                String name = sc.next();
                System.out.println("Enter a New email");
                String email=sc.next();
                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();
                Employee employee = new Employee(id, name, email, salary);
                dao.addEmployee(employee);
			System.out.println("Employee Added successfully");
			break;
			
			 case 2:
                 System.out.print("Enter Employee ID: ");
                 id = sc.nextInt();
                 Employee emp = dao.getEmployee(id);
                 if (emp != null) {
                     System.out.println("Employee: " + emp);
                 } else {
                     System.out.println("Employee not found.");
                 }
                 break;
                 
             case 3:
                 System.out.print("Enter Employee ID to Update: ");
                 id = sc.nextInt();
                 System.out.print("Enter New Name: ");
                 name = sc.next();
                 System.out.println("Enter a New email");
                 email=sc.next();
                 System.out.print("Enter New Salary: ");
                 salary = sc.nextDouble();
                 employee = new Employee(id, name, email , salary);
                 dao.updateEmployee(employee);
                 System.out.println("Employee updated successfully!");
                 break;

             case 4:
                 System.out.print("Enter Employee ID to Delete: ");
                 id = sc.nextInt();
                 dao.deleteEmployee(id);
                 System.out.println("Employee deleted successfully!");
                 break;

             case 5:
                 System.out.println("All Employees:");
                 for (Employee e : dao.getAllEmployees()) {
                     System.out.println(e);
                 }
                 break;

             case 6:
                 System.out.println("Exiting...");
                 sc.close();
                 return;

             default:
                 System.out.println("Invalid choice. Please try again.");
                 break;
         }
     }
			
	}
}
		
	


