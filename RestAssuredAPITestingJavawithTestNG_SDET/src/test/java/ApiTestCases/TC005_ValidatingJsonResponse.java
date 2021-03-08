package ApiTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_ValidatingJsonResponse {
	
	@Test
	public void GetWeatherDetails() {
		
		
		
		//Specify the base uri
				RestAssured.baseURI="http://demoqa.com/utilities/weather/city";
				
				//Request object
				RequestSpecification httpRequest=RestAssured.given();
				
				//Response object
				Response response=httpRequest.request(Method.GET,"/Delhi");
				
				//Print response in console window
				String responseBody=response.getBody().asString();
				System.out.println("Response Body is:"+responseBody);
				
				Assert.assertEquals(responseBody.contains("Delhi"), true);
				
	}

}
