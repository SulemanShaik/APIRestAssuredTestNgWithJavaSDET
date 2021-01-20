package serializationDeserialization;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class StudentAPITestSerialization {
	
	
	@Test(priority=1)
	public void createNewStudentSerialization()
	{
	
		
		ArrayList<String>coursesList= new ArrayList<String>();
		
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		Student stu = new Student ();
		stu.setSID(101);
		stu.setFirstName("john");
		stu.setLastName("peter");
		stu.setEmail("abghjk@edu");
		stu.setProgramme("manager");
		stu.setCourses(coursesList);
		
		  given()
		     .contentType(ContentType.JSON)
		     .body(stu)
		      .when()
		           .post("http://localhost:8085/student") 
		           
		      .then()
		      		.statusCode(201)
		      		.body("msg", equalTo("Student added"));
		  
		  
		       
		      
		      
	}  
	
	       @Test(priority=2)   
		      void getStudentRecordDeSerialization()
		      {
		    	 Student stu= get("http://localhost:8085/student/101").as(Student.class);
		    	 System.out.println(stu.getStudentRecord());
		    	 System.out.println(stu.getSID());
		    	 Assert.assertEquals(stu.getSID(), 101);
		      }
		        	   
	
	

}
