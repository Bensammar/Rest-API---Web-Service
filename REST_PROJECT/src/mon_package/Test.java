package mon_package;
import org.json.JSONException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String []args) throws SQLException, JSONException {
   //Scanner scanner = new Scanner(System.in);

      /*  System.out.println("Entrez votre Nom  ");
        String nom =scanner.nextLine();
        System.out.println("Entrez votre prenom ");
        String prenom =scanner.nextLine();
        System.out.println("Entrez votre Date de naissance ");
        String date =scanner.nextLine();

       Customer clien1 =new Customer(prenom,nom,date);

       System.out.println("le nom du clien1 est "+clien1.getLastName()+" "+ clien1.getFirstName()+"\n"+"Son numéro de compte est "+Account.acountNumber);
       System.out.println("Sa date de naissance : "+clien1.getBirthdate());
       System.out.println("la date de creation "+clien1.account.creationSDate+"\n"+"Son numéro de carte de crédit "+clien1.account.getCreditCardNumber());
       System.out.println("Mon solde est de : "+clien1.account.getSolde()+" €");

       System.out.println("SVP inserer la somme que vous souhaitez : ");
       clien1.account.deposit(new Scanner(System.in).nextDouble());

       System.out.println("Mon solde est de : "+clien1.account.getSolde()+" €"); */
    	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost\\\\\\\\SQL2019:1433;databaseName=Banque;integratedSecurity=true");
			System.out.println("aw connecta");
			Statement statement = connection.createStatement();
			ResultSet rs;
			String sql = "SELECT * FROM Customer ;";
			rs = statement.executeQuery(sql);
			System.out.println("aw manaaref");
		
			//System.out.println(rs.next());
			while (rs.next()) {
			      System.out.println(rs.getInt("id") + ", " + rs.getString("firstName") + ", "
			          + rs.getString("lastName"));
			    }
			rs.close();
			
    	} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
      /*  Customer clien1 =new Customer("prenom","nom","1997/09/27");
        ArrayList<String> al = clien1.getFirstName();
        System.out.println("First element of the ArrayList: "+al.get(0));
        System.out.println("Third element of the ArrayList: "+al.get(1));
        System.out.println("Sixth element of the ArrayList: "+al.get(2));*/
    	
    /*	CustomerExposer cus = new CustomerExposer();
    	cus.getUsers();*/
    	


    }
}

