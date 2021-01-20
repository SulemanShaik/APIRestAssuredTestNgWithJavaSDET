package serializationDeserialization;

import java.util.ArrayList;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StudentAPITestNoSerialization {

	
	 static HashMap map=new HashMap();
 	         
	         @Test(priority=1)
	         public void createNewStudent() 
	         {
	        	 map.put("id", "102");
	        	 map.put("firstName", "kotabala");
	        	 map.put("lastName", "balakota");
	        	 map.put("email", "bala123@gmail.com");
	        	 map.put("programme", "DeveloperAdmin");

	        	 ArrayList<String> courses=new ArrayList<String>();
	        	 courses.add("Java");
	        	 courses.add("Selenium");
	        	 courses.add("Angular");
	        	 courses.add("Spring");
	        	 courses.add("Web");
	        	 
	        	 map.put("courses", courses);
	        	 
	        	 //RestAssured.baseURI="http://localhost:8085/student";
	        	 
	        	 Response response=
	        	 given()
	        	   .contentType(ContentType.JSON)
	        	   .body(map)
	        	  
	        	   .when()
	        	      .post("http://localhost:8085/student")
	        	      
	        	   .then()
	        	      .statusCode(201)
	        	      .and()
	        	      .log().body()
	        	      .log().all()
	        	      .header("Content-Type", equalTo("application/json;charset=UTF-8"))
	        	      .extract().response();
	        	 
	        	 
	        	 String msg=response.asString();
	        	 Assert.assertEquals(msg.contains("Student added"), true);
	         }
	         
	         //Retrieving the data 
	         
	         
	         @Test(priority=2)
	         public void getStudentDetails() 
	         {
	        	 RestAssured.baseURI="http://localhost:8085/student";
	        	 RestAssured.basePath="/102";
	        	 
	        	 
	        	 given()
	        	    
	        	   .when()
	        	      .get()
	        	      
	        	    .then()
	        	      .statusCode(200)
	        	      .and()
	        	      .log().body()
	        	      .assertThat().body("id", equalTo(102))
	        	      .body("programme", equalTo("DeveloperAdmin"))
	        	      .body("lastName", equalTo("balakota"))
	        	      .and()
	        	      .header("Transfer-Encoding", equalTo("chunked"));
	         }
}
