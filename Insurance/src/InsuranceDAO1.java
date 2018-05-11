import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsuranceDAO1 {
	 
 	
 	public UserBean isUser(String uid,String pwd)
 	{
 		UserBean details=new UserBean();
 		try{
 			Class.forName("com.mysql.jdbc.Driver");
 		
 		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/divya","root","root");
 		String role="";
 		Statement stmt=con.createStatement();
 		ResultSet rs=stmt.executeQuery("select role,Uname from Underwriter");
 		while(rs.next()) {
 	
 		
 			details.setUsername(rs.getString(1));
 		    details.setRole(rs.getString(2));
 		}
 		rs.close();
 		con.close();
 		}
 		
 		catch(ArithmeticException e)
 		{   
 			System.out.println(e);
 		}
 		finally {
 			return details;
 		}

 	}
}
