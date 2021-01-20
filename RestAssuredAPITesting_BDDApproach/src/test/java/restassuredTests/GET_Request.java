package restassuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GET_Request 
{
	
	 @Test
	 public void getWeatherDetails() 
	 {
		 
		     given()
		   
		     .when()
		         .get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
		     .then()
		        .statusCode(200)
		        .and()
		        .statusLine("HTTP/1.1 200 OK")
		        .and()
		        .assertThat().body("City",equalTo("Hyderabad"))
		        .body("WeatherDescription", equalTo("haze"))
		        .header("Content-Type", equalTo("application/json"))
		        .log().all();             // To Print the data in console output
	 }

}
