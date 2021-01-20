package restassuredTests;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


public class DELETE_Request 

{
         @Test
	public void deleteEmployeeRecord() 
	
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/216324";
		
		
		given()
		
		.when()
		
		   .delete()
		.then()
		
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.log().all();
	}
	
	
}
