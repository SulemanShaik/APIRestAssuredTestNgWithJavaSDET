package restassuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class PUT_Request
             
{
	public static HashMap map = new HashMap();
	
	int emp_id=215297;
	  @BeforeClass
       public void putData()
       
       {
    	    map.put("name",RESTUtils.empName());
    	    map.put("salary", RESTUtils.empSal());
    	    map.put("age", RESTUtils.empAge());
    	    
    	    RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
    	    RestAssured.basePath="/update/"+ emp_id;
       }
	  
	  
	  
	  @Test
	  public void putTest()
	  
	  {
		  given()
		         .contentType("application/json")
		         .body(map)
		  .when()
		  
		         .put()
		  .then()
		  
		  .statusCode(200)
		  .log().all();
	  
		  
		  

	  }
	
	
	
	
}
