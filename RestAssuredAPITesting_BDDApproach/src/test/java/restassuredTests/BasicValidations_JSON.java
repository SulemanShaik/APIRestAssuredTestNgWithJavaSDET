package restassuredTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class BasicValidations_JSON
{

	/*1) Test Status Code
	2) Log Response
	3) Verifying Single Content in response body
	4) Verifying Multiple Contents in response body
	5) Setting parameters and headers*/
	
	
	//1) Test Status Code
	
	
	@Test(priority=1)
	public void testStatusCode() 
	
	{
		given()
		.when()
		       .get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
		      .statusCode(200);
		      //.log().all();
		
	}     
	
	//2) Log Response
	
	@Test(priority=2)
	public void testLogResponse()
	{
		given()
		.when()
		   .get("http://jsonplaceholder.typicode.com/posts/5")
		   
		 .then()
		 
		    .statusCode(200)
		    .log().all();
		    
	}
	
	//3) Verifying Single Content in response body
	
	@Test(priority=3)
	public void testSingleContent()
	{
		
		given()
		.when()
		    .get("http://jsonplaceholder.typicode.com/posts/5")
		    
		.then()
		      .statusCode(200)
		      .body("title",equalTo("nesciunt quas odio"));
		      
	         
		
		
	}
	//4) Verifying Multiple Contents in response body
	
	@Test(priority=4)
	public void testMultipleContents()
	{
		
		given()
		.when()
		    .get("http://jsonplaceholder.typicode.com/posts/")
		    
		.then()
		      
	         .body("title", hasItems("magnam facilis autem","voluptatem eligendi optio"));
		
		
	}
	
	//5) Setting parameters and headers*/
	
	@Test(priority=5)
	public void testParametersandHeaders()
	{
		
		given()
		    .param("title", "mynameissuleman")  
		    .header("MyHeader","Suleman")
		
		.when()
		    .get("http://jsonplaceholder.typicode.com/posts/5")
		    
		.then()
		
		  .body("title",equalTo("nesciunt quas odio"))
		  .log().all();
	}
	
}
