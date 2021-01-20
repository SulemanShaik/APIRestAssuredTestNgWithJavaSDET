package restassuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class POST_Request 
{
	
	public static HashMap map = new HashMap();
	
	
	@BeforeClass
	public void postdata()
	{
		
		map.put("FirstName", RESTUtils.getFirstName());
		map.put("LastName", RESTUtils.getLastName());
		map.put("UserName", RESTUtils.getUserName());
		map.put("Password", RESTUtils.getPassword());
		map.put("Gmail", RESTUtils.getGmail());
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
		
		
	}
	
	
	
	@Test
	public void testPost()
	{
		given()
		
		  .contentType("application/json")
		  .body(map)
		  
		.when()
		  
		   .post()
		  
		.then()
		
		  .statusCode(201)
		  .and()
		  .body("SuccessCode", equalTo("OPERATION_SUCCESS"))
		  .and()
		  .body("Message",equalTo("Operation completed successfully"));
	
	}
	
	

}
