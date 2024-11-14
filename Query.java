package emp;

public class Query {
	static String insert="INSERT INTO emp(id ,name,email,salary) VALUES(?,?,?,?)";
	static String read="SELECT * FROM emp WHERE id=?";
	static String update="UPDATE emp SET name=? ,email=?, salary=? where id=?";
	static String delete="DELETE FROM emp where id=?";
	static String select="SELECT * FROM emp";
	

}
