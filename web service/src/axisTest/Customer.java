package axisTest;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Customer {
    public  int id=0;
    private String firstName;
    private String lastName;
    private Date birthdate;
    public CurrentAccount account;
   

    public Customer(int id,String firstName, String lastName, String birthdate){

        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.account = new CurrentAccount();


        Date date=Date.valueOf(birthdate);

        this.birthdate = date;
        
        
    
    }
    public String getCustomer(int id,String firstName, String lastName, String birthdate){

        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.account = new CurrentAccount();


        Date date=Date.valueOf(birthdate);

        this.birthdate = date;
        
        return "id: "+id+" firstname: "+firstName+" lastname: "+lastName+" birthdate: "+birthdate;
    }
    
    public String getFirstName() throws SQLException {
        return firstName;

    }
    public ArrayList<String> getAllCustomer() throws SQLException {
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
        return al;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setCustomer(Customer client) {
    	 try {
 			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 			Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost\\\\\\\\SQL2019:1433;databaseName=Banque;integratedSecurity=true");
 			Statement statement = connection.createStatement();
			PreparedStatement ps = connection.prepareStatement(
			        "INSERT INTO Customer (id,firstName,lastName,birthdate)" +
			        "VALUES (?,?,?,?)");
			ps.setLong(1, client.id);
			ps.setString(2, client.firstName);
			ps.setString(3, client.lastName);
			ps.setDate(4, client.birthdate);
		
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = (Date) sdf.parse(birthdate);
            this.birthdate = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
