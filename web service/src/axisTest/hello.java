package axisTest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class hello {
		
    public  int id=0;
    private String firstName;
    private String lastName;
    private Date birthdate;
    public CurrentAccount account;

    
    public void setCustomer(int id,String firstName, String lastName, String birthdate){

        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.account = new CurrentAccount();
        Date date=Date.valueOf(birthdate);

        this.birthdate = date;
        
        try {
 			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 			Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost\\\\\\\\SQL2019:1433;databaseName=Banque;integratedSecurity=true");
 			Statement statement = connection.createStatement();
			PreparedStatement ps = connection.prepareStatement(
			        "INSERT INTO Customer (id,firstName,lastName,birthdate)" +
			        "VALUES (?,?,?,?)");
			ps.setLong(1, id);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setDate(4, this.birthdate);
		
			ps.executeUpdate();
 			connection.close();

 		} catch (ClassNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} 


     
        
    }
    
    public String getCustomer() throws SQLException {
        ArrayList<String> al = new ArrayList<String>();
        try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost\\\\\\\\SQL2019:1433;databaseName=Banque;integratedSecurity=true");
			Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM Customer");

			while (rs.next()) {
				 al.add((String)rs.getString("id"));
			     al.add(rs.getString("firstName"));
	    		 al.add(rs.getString("lastName"));
	    		 al.add(rs.getString("birthdate"));
	    		 
	    		 System.out.println((String)rs.getString("id") + ", " + rs.getString("firstName") + ", "
	    				+ rs.getString("lastName")+","+rs.getString("birthdate"));
			    }
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
		System.out.println(al.toString());
		
		
			return al.toString();
	
    }

    
    public void deleteCustomer(int id){
        this.account = new CurrentAccount();
        try {
 			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 			Connection connection = DriverManager.getConnection
 					("jdbc:sqlserver://localhost:1433;databaseName=Banque;integratedSecurity=true"); 			
			PreparedStatement ps = connection.prepareStatement(
			        "DELETE FROM Customer WHERE id= " + id);		
			ps.executeUpdate();
 			connection.close();
 		} catch (ClassNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    }
    public void updateCustomer(int id,String firstName, String lastName, String birthdate){
        this.account = new CurrentAccount();
                
        
        try {
 			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 			Connection connection = DriverManager.getConnection
 					("jdbc:sqlserver://localhost:1433;databaseName=Banque;integratedSecurity=true"); 			
			PreparedStatement ps = connection.prepareStatement(
			        "UPDATE Customer "
			      + "SET firstName= '" + firstName + "', lastName= '" + lastName + "', birthdate= '" + Date.valueOf(birthdate) +
			      "' WHERE id= '" + id + "'");		
			
			ps.executeUpdate();
 			connection.close();
 		} catch (ClassNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    }
}
