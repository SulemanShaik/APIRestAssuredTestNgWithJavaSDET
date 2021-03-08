package ApiTestCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GetRequest {
	
	
	@Test
	void getweatherDetails() {
		
		//Specify the base uri
		RestAssured.baseURI="http://demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		
		//Print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		
		//Status code validations
		int statusCode= response.getStatusCode();
		System.out.println("status code is:"+statusCode);
		Assert.assertEquals(statusCode,200);
		
		//Status line verification
		String statusLine=response.getStatusLine();
		System.out.println("status line is:"+statusLine);
	    Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
		
		
		
		
	}

}
