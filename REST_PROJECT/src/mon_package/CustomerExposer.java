package mon_package;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@Path("/api")

public class CustomerExposer {

	@Path("/users")
	@GET
	@Produces("application/json")
	public Response getUsers() throws JSONException, SQLException {
		
		//get the list of users
		Customer customer = new Customer(0, "ddddd","ddddd","2015-03-31");
		ArrayList<String> customers = (ArrayList<String>) customer.getAllCustomer();
		
		//Convert users to a JSON object
		JSONArray jsonUsers = new JSONArray();
		
		int s =0;
		System.out.println("siez"+customers.size());
		for(int i = 0; i < customers.size(); i++) {
			
			JSONObject jsonUser = new JSONObject();
			jsonUser.put("id", customers.get(s));
			s=s+1;
			jsonUser.put("firstName", customers.get(s));
			s=s+1;
			jsonUser.put("lastName", customers.get(s));
			s=s+1;
			jsonUser.put("birthdate", customers.get(s));
			s=s+1;
			
			jsonUsers.put(jsonUser);
			if (s==customers.size()) {
				System.out.println(s);
				break;
			}
			
		}

		String result = "" + jsonUsers;

		return Response.status(200).entity(result).build();
	}

	
	@Path("/users")
	@POST	
	@Consumes("application/json")
	@Produces("application/json")	
	public Response addUser(InputStream jUserStream) {
		
		JSONParser jsonParser = new JSONParser();
		org.json.simple.JSONObject jsonObject;
		try {
			jsonObject = (org.json.simple.JSONObject)jsonParser.parse(new InputStreamReader(jUserStream, "UTF-8"));
			
			Customer customer = new Customer(((Long)jsonObject.get("id")).intValue(), (String)jsonObject.get("firstName"), (String)jsonObject.get("lastName"), (String)jsonObject.get("birthdate"));
			
		customer.setCustomer(customer);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		String result = "{'success':1}" ;
		return Response.status(200).entity(result).build();		
	}

	
	
	
	
}
