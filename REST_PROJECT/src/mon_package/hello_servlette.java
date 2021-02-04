package mon_package;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class hello_servlette extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost\\\\\\\\SQL2019:1433;databaseName=Banque;integratedSecurity=true");
			Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM Customer");
			while (rs.next()) {
			      resp.getWriter().print(rs.getInt("id") + ", " + rs.getString("firstName") + ", "
			          + rs.getString("lastName")+ ", " + rs.getString("birthdate")+"<br />");
			    }
			rs.close();


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
